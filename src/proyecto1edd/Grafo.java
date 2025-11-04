/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1edd;

import java.util.HashSet;
import java.util.Set;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

/**
 *
 * @author gianc
 */
public class Grafo 
{
    public void Start() {
        System.setProperty("org.graphstream.ui", "swing");

        Graph graph = new SingleGraph("grafo");

        // Paso 1: Agregar nodos
        Node<User> current = Database.GetUsers().first();
        while (current != null) {
            User user = current.getData();
            if (graph.getNode(user.username) == null) {
                graph.addNode(user.username).setAttribute("ui.label", user.username);
            }
            current = current.getNext();
        }

        // Paso 2: Agregar aristas evitando duplicados
        Set<String> aristasAgregadas = new HashSet<>();

        Node<User> current1 = Database.GetUsers().first();
        while (current1 != null) {
            User user = current1.getData();

            Node<User> relation = user.relations.first();
            while (relation != null) {
                User relationUser = relation.getData();

                // Asegurar que el nodo destino existe
                if (graph.getNode(relationUser.username) == null) {
                    graph.addNode(relationUser.username).setAttribute("ui.label", relationUser.username);
                }

                // Crear ID único para la arista
                String idArista = user.username + "-" + relationUser.username;

                // Evitar duplicados
                if (!aristasAgregadas.contains(idArista)) {
                    try {
                        graph.addEdge(idArista, user.username, relationUser.username, true); // true = dirigida
                        aristasAgregadas.add(idArista);
                    } catch (Exception e) {
                        System.err.println("Error al agregar arista: " + idArista);
                    }
                }

                relation = relation.getNext();
            }

            current1 = current1.getNext();
        }

        graph.display();
    }

}
