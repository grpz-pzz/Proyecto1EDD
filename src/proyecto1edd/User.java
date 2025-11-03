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
       this.relations = new List<User>();
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
   public static User searchUser(String targetUser){
       Node<User> current = Main.users.first();
       while (current != null){
           User userInList = current.getData();
           if (targetUser.equals(userInList.username)){
               return userInList;
           }
           current = current.getNext();          
       }
       return null;
       
   }
   
}
