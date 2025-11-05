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
    private static void firstDFS(User user, List<User> visited, Stack<User> stack) {
        if (visited.contains(user)) {
            return;
        }
        
        visited.insert(user);

        List<User> neighbors = user.getRelations();
        Node<User> neighborNode = neighbors.first();

        while (neighborNode != null) {
            User neighbor = neighborNode.getData();
            if (!visited.contains(neighbor)) {
                firstDFS(neighbor, visited, stack);
            }
            neighborNode = neighborNode.getNext();
        }

        stack.push(user);
    }

    private static void secondDFS(User user, List<User> visited, List<User> currentSCC, List<User> allUsers) {
        if (visited.contains(user)) {
            return;
        }
        visited.insert(user);
        currentSCC.insert(user);

        Node<User> allUsersNode = allUsers.first();
        while (allUsersNode != null) {
            User potentialPredecessor = allUsersNode.getData();

            if (potentialPredecessor.getRelations().contains(user)) {
                
                if (!visited.contains(potentialPredecessor)) {
                    secondDFS(potentialPredecessor, visited, currentSCC, allUsers);
                }
            }
            allUsersNode = allUsersNode.getNext();
        }
    }

    public static List<List<User>> findSCCs() {
        List<User> allUsers = Database.getUsers();

        Stack<User> stack = new Stack<>();
        List<User> visitedPass1 = new List<>();

        Node<User> currentNode = allUsers.first();
        while (currentNode != null) {
            User user = currentNode.getData();
            if (!visitedPass1.contains(user)) {
                firstDFS(user, visitedPass1, stack);
            }
            currentNode = currentNode.getNext();
        }
        
        List<List<User>> allSCCs = new List<>();
        List<User> visitedPass2 = new List<>();

        while (!stack.isEmpty()) {
            User user = stack.pop();

            if (!visitedPass2.contains(user)) {
                List<User> currentSCC = new List<>();
                
                secondDFS(user, visitedPass2, currentSCC, allUsers);
                
                allSCCs.insert(currentSCC);
            }
        }
        return allSCCs;
    }
}