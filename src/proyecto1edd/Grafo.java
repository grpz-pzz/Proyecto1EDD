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
        graph.setAttribute("ui.stylesheet", 
                "node { " +
                        "size: 20px; " +
                "}"
        );
        
        // Paso 1: Agregar nodos
        Node<User> current = Database.getUsers().first();
        while (current != null) {
            User user = current.getData();
            if (graph.getNode(user.username) == null) {
                graph.addNode(user.username).setAttribute("ui.label", user.username);
            }
            current = current.getNext();
        }

        // Paso 2: Agregar aristas evitando duplicados
        Set<String> addedAxes = new HashSet<>();

        Node<User> current1 = Database.getUsers().first();
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
                String idAxis = user.username + "-" + relationUser.username;

                // Evitar duplicados
                if (!addedAxes.contains(idAxis)) {
                    try {
                        graph.addEdge(idAxis, user.username, relationUser.username, true); // true = dirigida
                        addedAxes.add(idAxis);
                    } catch (Exception e) {
                        System.err.println("Error al agregar arista: " + idAxis);
                    }
                }

                relation = relation.getNext();
            }

            current1 = current1.getNext();
        }
        
        String[] colors = {
            "red", "blue", "green", "orange", "purple", 
            "yellow", "pink", "cyan", "magenta", "brown"
        };
      
        int colorIndex = 0;
        List<List<User>> l = KosarajuAlgorithm.findSCCs();
        System.out.println(l.asString());
        
        Node<List<User>> listNode = l.first();
        while(listNode != null) {
            List<User> currentSCC = listNode.getData();
            
            Node<User> userInSCC = currentSCC.first();
            while(userInSCC != null) {
                User user = userInSCC.getData();
                
                org.graphstream.graph.Node node = graph.getNode(user.getUsername());
                if(node != null)
                    node.setAttribute("ui.style", "fill-color: " + colors[colorIndex % colors.length] + ";");
                
                userInSCC = userInSCC.getNext();
            }
            
            listNode = listNode.getNext();
            colorIndex++;
        }
        
        graph.display();
    }

}
