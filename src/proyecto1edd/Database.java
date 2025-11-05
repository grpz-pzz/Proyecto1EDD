/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1edd;

/**
 *
 * @author gianc
 */
public class Database 
{

    private static List<User> users = new List();

    /**
    * adds a user to the database
    * <p>
    * this method iterates the user list and verifies if the username is s\already registered 
    * if it is not found create a new object {@code User} and inserts it in the list.
    * if the user exists show a message.
    *
     * @param user
    * @return return true if user added successfully
    */
    public static boolean AddUser(User user) {
        Node<User> current = users.first();
        while (current != null) {
            User temp = current.getData();
            if (user.username.equals(temp.username)) {
                System.out.println("El usuario ya existe");
                return false;
            }
            current = current.getNext();
        }

        getUsers().insert(user);
        System.out.println("Usuario agregado: " + user.username);
        return true;
    }


    public static List<User> getUsers() {
        return users;
    }
    
    public static void DeleteUser(User user)
    {
        getUsers().delete(user);
        System.out.print("Eliminado " + user.username);
    }

    public static User SearchUser(String targetUser) {
        Node<User> current = Database.getUsers().first();
        while (current != null) {
            User userInList = current.getData();
            if (targetUser.equals(userInList.username)) {
                return userInList;
            }
            current = current.getNext();
        }
        return null;
    }
}
