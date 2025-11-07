/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1edd;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.ui.view.Viewer;
import java.util.Random;
/**
 *
 * @author gianc
 */
public class GraphManager 
{
    public static GraphManager graphManager;
    private Graph graph;
    private Random r = new Random();
    
    // Obtener grafo de cualquier lugar
    public GraphManager()
    {
        System.setProperty("org.graphstream.ui", "swing");
        graphManager = this;
        graph = new SingleGraph("grafo");

        Viewer viewer = graph.display();
        viewer.enableAutoLayout();
    }
    
    public void start()
    {
        graph.setAttribute("ui.stylesheet", 
                "node { " +
                        "text-size: 20; " +
                        "size: 60px; " +
                "}"
        );
        
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

                if (graph.getNode(relationUser.username) == null) {
                    graph.addNode(relationUser.username).setAttribute("ui.label", relationUser.username);
                }

                String idAxis = user.username + "-" + relationUser.username;
                org.graphstream.graph.Edge edge = graph.getEdge(idAxis);
                
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
        
        executeKosarajuAlgorithm();
    }
    
    public void UpdateGraph()
    {
        graph.clear();
        start();
    }
    
    private static final String[]  isolatedNodeColors ={ "#9ca399", "#a39999", "#9fabab", "#a4a5b0", "#aea7b5"
        
    };
    public void addUserNode(User user) {       
        org.graphstream.graph.Node newNode = this.graph.addNode(user.getUsername());
        newNode.setAttribute("ui.label", user.getUsername());
        String randomColor = isolatedNodeColors[r.nextInt(isolatedNodeColors.length)];
        String style = String.format("fill-color: %s;", isolatedNodeColors);
        newNode.setAttribute("ui.style", style);             
    }
    
    public void removeUserNode(User user) {
        this.graph.removeNode(user.getUsername());
    }
    
    public void executeKosarajuAlgorithm() {
        String[] colors = {
            "#e89797", "#dba4c4", "#b8a4db", "#8f99cc", "#7eb5cc", 
            "#8fb5ac", "#91c299", "#bec291", "#c2ab91"
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
    
    public boolean relationExists(User user1, User user2) {
        String edgeName = user1.getUsername() + "-" + user2.getUsername();
        return this.graph.getEdge(edgeName) != null;
    }
    
    public void addRelation(User user1, User user2) {
        String edgeName = user1.getUsername() + "-" + user2.getUsername();
        
        try {
            this.graph.addEdge(edgeName, user1.getUsername(), user2.getUsername(), true);
            this.executeKosarajuAlgorithm();
            Viewer viewer = graph.display();
            viewer.enableAutoLayout();
        } catch(Exception e) {
            System.err.println("Error creando eje: " + edgeName + " (" + e.toString() + ")");
        }
    }
    
    public void removeRelation(User user1, User user2) {
        String edgeName = user1.getUsername() + "-" + user2.getUsername();
        
        try {
            this.graph.removeEdge(edgeName);
            this.executeKosarajuAlgorithm();
            Viewer viewer = graph.display();
            viewer.enableAutoLayout();
        } catch(ElementNotFoundException e) {
            System.err.println("Error eliminando eje: " + edgeName + " (" + e.toString() + ")");
        }
    }
}
