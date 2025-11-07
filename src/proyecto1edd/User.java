/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1edd;

/**
 * creates adjacency list 
 * @author biancazullo
 */
public class User {
    String username;
    List<User> relations;
    private boolean visited;
    
    /**
     * creates user
     * @param username 
     */
    public User(String username){
       this.username = username;
       this.relations = new List<>();
       this.visited = false;
   }
   
   /**
    * user name getter
    * @return username
    */
   public String getUsername(){
       return username;
   }
   
   /**
    * relation getter
    * @return relation
    */
   public List getRelations(){
       return relations;     
   }
   
   /**
    * inserts relation
    * @param otherUser 
    */
   public void relation(User otherUser){
       this.relations.insert(otherUser);
   }
   
   /**
    * checks if node has been visited
    * @return true or false 
    */
   public boolean beenVisited() {
       return visited;
   }
   
   /**
    * sets visited 
    * @param set 
    */
   public void setVisited(boolean set) {
       this.visited = set;
   }
}
