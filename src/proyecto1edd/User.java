/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1edd;

/**
 *
 * @author biancazullo
 */
public class User {
    String username;
    List<User> relations;
    private boolean visited;
    
   public User(String username){
       this.username = username;
       this.relations = new List<>();
       this.visited = false;
   }
   public String getUsername(){
       return username;
   }
   public List getRelations(){
       return relations;     
   }
   public void relation(User otherUser){
       this.relations.insert(otherUser);
   }
   public boolean beenVisited() {
       return visited;
   }
   public void setVisited(boolean set) {
       this.visited = set;
   }
}
