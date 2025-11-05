/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1edd;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

/**
 *
 * @author gianc
 */
public class Grafo 
{
    private Graph graph;
    
    public void start() {
        System.setProperty("org.graphstream.ui", "swing");

        this.graph = new SingleGraph("grafo");
        graph.setAttribute("ui.stylesheet", 
                "node { " +
                        "text-size: 25; " +
                        "size: 75px; " +
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
                org.graphstream.graph.Edge edge = graph.getEdge(idAxis);
                
                // Evitar duplicados
                if (edge == null) {
                    try {
                        graph.addEdge(idAxis, user.username, relationUser.username, true); // true = dirigida
                    } catch (Exception e) {
                        System.err.println("Error al agregar arista: " + idAxis);
                        System.err.println(e.toString());
                    }
                }

                relation = relation.getNext();
            }

            current1 = current1.getNext();
        }
        
        this.executeKosarajuAlgorithm();
        graph.display();
    }
    
    public void addUserNode(User user) {
        this.graph.addNode(user.getUsername()).setAttribute("ui.label", user.getUsername());
    }
    
    public void removeUserNode(User user) {
        this.graph.removeNode(user.getUsername());
    }
    
    public void executeKosarajuAlgorithm() {
        String[] colors = {
            "#9fabb3", "#9fa1c9", "#6990cf", "#dbd8a2", "#d99eb6", 
            "#ebc38a", "#91bf95", "#6aa1a8", "#787265"
        };
        
        this.resetNodeColors();
        
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
            
            colorIndex++;
            listNode = listNode.getNext();
        }
    }
    
    public void resetNodeColors() {
        Node<User> userNode = Database.getUsers().first();
        while(userNode != null) {
            org.graphstream.graph.Node graphNode = this.graph.getNode(userNode.getData().getUsername());
            if(graphNode != null) {
                graphNode.removeAttribute("ui.style");
            }
            userNode = userNode.getNext();
        }
    }
}
