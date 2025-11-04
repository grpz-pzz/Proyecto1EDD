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
   
   public User(String username){
       this.username = username;
       this.relations = new List<>();
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
   
}
