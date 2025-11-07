/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1edd;

/**
 *
 * @author biancazullo
 */
public class KosarajuAlgorithm {
    /**
     * first depth search implementation over original graph
     * fills the stack with nodes in finalization time order
     * 
     * @param user
     * @param stack 
     */
    private static void firstDFS(User user, Stack<User> stack) {
        if(user.beenVisited())
            return;
        user.setVisited(true);
        List<User> neighbors = user.getRelations();
        Node<User> neighborNode = neighbors.first();
        while (neighborNode != null) {
            User neighbor = neighborNode.getData();
            if (!neighbor.beenVisited()) {
                firstDFS(neighbor, stack);
            }
            neighborNode = neighborNode.getNext();
        }
        stack.push(user);
    }
    /**
     * creates a simulation of a transposed graph (inverts edges)
     * and implements a depth first search on the simulated transposed graph
     * @param user
     * @param currentSCC
     * @param allUsers 
     */
    private static void secondDFS(User user, List<User> currentSCC, List<User> allUsers) {
        if(user.beenVisited())
            return;
        
        user.setVisited(true);
        currentSCC.insert(user);

        Node<User> allUsersNode = allUsers.first();
        while (allUsersNode != null) {
            User potentialPredecessor = allUsersNode.getData();

            if (potentialPredecessor.getRelations().contains(user)) {
                
                if (!potentialPredecessor.beenVisited()) {
                    secondDFS(potentialPredecessor, currentSCC, allUsers);
                }
            }
            allUsersNode = allUsersNode.getNext();
        }
    }
    
    /**
     * principal method that executes the algorithm 
     * @return adjacency list, every internal list is a SCC
     */
    public static List<List<User>> findSCCs() {
        List<User> allUsers = Database.getUsers();

        Stack<User> stack = new Stack<>();
        Database.resetVisited();

        Node<User> currentNode = allUsers.first();
        while (currentNode != null) {
            User user = currentNode.getData();
            if (!user.beenVisited()) {
                firstDFS(user, stack);
            }
            currentNode = currentNode.getNext();
        }
        
        List<List<User>> allSCCs = new List<>();
        Database.resetVisited();

        while (!stack.isEmpty()) {
            User user = stack.pop();

            if (!user.beenVisited()) {
                List<User> currentSCC = new List<>();
                
                secondDFS(user, currentSCC, allUsers);
                
                allSCCs.insert(currentSCC);
            }
        }
        return allSCCs;
    }
}