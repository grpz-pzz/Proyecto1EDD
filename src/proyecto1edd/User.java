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
    List relations = new List();
   
   public User(String username){
       this.username = username;
   }
   public String getUsername(){
       return username;
   }
   public List getRelations(){
       return relations;     
   }
   public static User SearchUser(String targetUser ){
       Node current = Main.users.first();
       while (current != null){
           User userInList = (User)current.getData();
           if (targetUser == userInList.username){
               return userInList;
           }
           current = current.getNext();          
       }
       return null;
       
   }
   
}
