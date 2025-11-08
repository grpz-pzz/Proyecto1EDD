/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1edd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author gianc
 */
public class Database 
{

    private static List<User> users = new List();
    private static File file;
    /**
    * adds a user to the database
    * <p>
    * this method iterates the user list and verifies if the username is already registered 
    * if it is not found create a new object {@code User} and inserts it in the list.
    * if the user exists show a message.
    *
     * @param user
    * @return return true if user added successfully
    */
    public static boolean addUser(User user) {
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

    /**
     * users getter
     * @return users list
     */
    public static List<User> getUsers() {
        return users;
    }
    
    /**
     * deletes user
     * @param user 
     */
    public static void deleteUser(User user){
        System.out.print("Eliminado " + user.getUsername());
         Node<User> current = getUsers().first();
        while (current != null) {
            User userInList = current.getData();
            
            if(userInList.relations.contains(user)){
                userInList.relations.delete(user);
            }
            
            current = current.getNext();
        }
        
        getUsers().delete(user);
    }

    /**
     * iterates users list to find target user
     * @param targetUser
     * @return null
     */
    public static User searchUser(String targetUser) {
        Node<User> current = getUsers().first();
        while (current != null) {
            User userInList = current.getData();
            if (targetUser.equals(userInList.getUsername())) {
                return userInList;
            }
            current = current.getNext();
        }
        return null;
    }
    
    /**
     * updates text file
     */
    public static void Save()
    {
        String[] lineas = {
            "Primera línea",
            "Segunda línea",
            "Tercera línea"
        };
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file)))  {
            writer.write("usuarios");
            writer.newLine();
            Node<User> current = getUsers().first();
            while (current != null) {
                User temp = current.getData();
                writer.write("@" + temp.username);
                writer.newLine();
                current = current.getNext();
            }
            writer.write("relaciones");
            writer.newLine();
            Node<User> current1 = getUsers().first();
            while (current1 != null) 
            {
                User temp = current1.getData();
                Node<User> current2 = temp.relations.pFirst;
                while (current2 != null) 
                {
                    User r = current2.getData();
                    writer.write("@" + temp.username + ", " + "@" + r.username);
                    writer.newLine();  
                    current2 = current2.getNext();
                }
                current1 = current1.getNext();
            }
            System.out.println("Archivo escrito correctamente.");
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
    
    /**
     * loads text file 
     * @param f 
     */
    public static void Load(File f)
    {
        file = f;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) 
            { 
                String line;
                String type = "none"; 
                while ((line = reader.readLine()) != null) {
                    if (!line.contains("@")){
                        System.out.println("Leyendo tipo de dato: " + line);
                        type = line;
                        continue; 
                    }
                    switch (type)
                    {
                        case "usuarios": {
                            System.out.println(line);                         
                            String temp = line.substring(1);
                            User newUser = new User(temp);
                            addUser(newUser);
                            break;
                        }
                        case "relaciones": {
                            String[] userNames = line.split(",\\s+");   
                            String temp = userNames[0].substring(1);
                            User mainUser = searchUser(temp);
                            User relationUser = searchUser(userNames[1].substring(1));
                            mainUser.relations.insert(relationUser); 
                            System.out.println("Agregado " + relationUser.username + " a " + mainUser.username);
                            break;
                        }
                    }
                }
            GraphManager graph = new GraphManager();
            graph.start();
        } catch (IOException ex) {
            System.getLogger(Database.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    
    /**
     * resets visited elements
     */
    public static void resetVisited() {
        Node<User> n = Database.getUsers().first();
        while(n != null) {
            n.getData().setVisited(false);
            n = n.getNext();
        }
        
    }
    
    public static void clearUsers() {
        Database.users = new List();
    }
}
