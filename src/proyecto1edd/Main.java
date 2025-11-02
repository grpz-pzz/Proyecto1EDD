/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto1edd;

/**
 *
 * @author gianc
 */
public class Main 
{
    public static List users = new List();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Window w = new Window();
        w.setVisible(true);
    }
    
    public static class User
    {
        String username;
        List relations = new List();
    }
    
    public static User SearchUser(String username)
    {
        Node current = Main.users.first();
        while (current != null) {
            if (username.equals(current.getData())) {
                return (User)current.getData();
            }
            current = current.getNext();
        }
        return null;
    }
}
