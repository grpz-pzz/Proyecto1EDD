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

    private static List users = new List();

    /**
    * Agrega un nuevo usuario a la base de datos
    * <p>
    * Este método recorre la lista de usuarios y verifica si el nombre de usuario ya está registrado.
    * Si no se encuentra, crea un nuevo objeto {@code User} y lo inserta en la lista.
    * Si el usuario ya existe, se muestra un mensaje en consola.
    *
    * @param username el nombre de usuario que se desea agregar
    * @return retorna verdadero si se agrego correctamente
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

        GetUsers().insert(user);
        System.out.println("Usuario agregado: " + user.username);
        return true;
    }


    public static List GetUsers() {
        return users;
    }
    
    public static void DeleteUser(User user)
    {
        // Solo test
        System.out.print("Eliminado " + user.username);
    }

    public static User SearchUser(String targetUser) {
        Node<User> current = Database.GetUsers().first();
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
