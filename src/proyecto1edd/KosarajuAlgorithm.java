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
    
    private void firstDFS(User user, List<User> visited, Stack<User> stack){
        visited.insert(user);
        Node <User> currentRelationNode = user.getRelations().first();
        while (currentRelationNode != null){
            User neighbor = currentRelationNode.getData();
            if (!visited.contains(neighbor)){
                firstDFS(neighbor, visited, stack);
            }
            currentRelationNode = currentRelationNode.getNext();    
        }
        stack.push(user);
    }
    private void secondDFS (User user, List<User> visited, List<User> currentSCC){
        visited.insert(user);
        currentSCC.insert(user);
        Node<User> allUsersNode = Database.getUsers().first();
        while (allUsersNode != null){
            User potentialPredecessor = allUsersNode.getData();
            if (potentialPredecessor.getRelations().contains(user) && !visited.contains(potentialPredecessor)){
                secondDFS(potentialPredecessor, visited, currentSCC);
            }
            allUsersNode = allUsersNode.getNext();
        }
    }
    public List<List<User>> findSCCs(List<User> allUsers){
        Stack<User> stack = new Stack<>();
        List<User> visited = new List<>();
        Node<User> currentNode = allUsers.first();
        while (currentNode != null){
            User user = currentNode.getData();
            if(!visited.contains(user)){
                firstDFS(user, visited, stack);               
            }
            currentNode= currentNode.getNext();
        }
        visited = new List<>();
        List<List<User>> sccs = new List<>();
        while (!stack.isEmpty()){
            User user = stack.pop();
            if (!visited.contains(user)){
                List<User> currentSCC = new List<>();
                secondDFS(user, visited, currentSCC);
                sccs.insert(currentSCC);               
            }
        }
        return sccs;
    }
}