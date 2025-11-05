/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto1edd;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author biancazullo
 */
public class Window extends javax.swing.JFrame {

    // Map de Users por claves Usernames, solamente auxiliar para la interfaz y ahorrar recursos
    private Map<String, User> tempUsers = new Map<>();
    private User selected;
    private User selectedFirst;
    private GraphManager graph;
    private String loadedFilePath = "";
    private DefaultListModel<String> modelList = new DefaultListModel<>();
    private boolean selectingUser = false;
    
    public Window() {
        initComponents();
        jList1.setModel(modelList);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        uploadtxt = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        delButton = new javax.swing.JButton();
        removeRelation = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jMenuItem1.setText("jMenuItem1");

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        uploadtxt.setText("Cargar archivo");
        uploadtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadtxtActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Administrar usuarios"));

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jList1MouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jList1);

        jButton1.setText("Crear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        editButton.setText("Relacionar con");
        editButton.setEnabled(false);
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        delButton.setText("Eliminar");
        delButton.setEnabled(false);
        delButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delButtonActionPerformed(evt);
            }
        });

        removeRelation.setText("Eliminar relación");
        removeRelation.setEnabled(false);
        removeRelation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeRelationActionPerformed(evt);
            }
        });

        jButton2.setText("Guardar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeRelation)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(delButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(editButton)
                    .addComponent(delButton)
                    .addComponent(removeRelation)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uploadtxt))
                .addContainerGap(409, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(uploadtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void uploadtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadtxtActionPerformed
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo txt", "txt");
        chooser.setFileFilter(filter);
        chooser.setMultiSelectionEnabled(false);
        int returnValue = chooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION)
        {
            File selectedFile = chooser.getSelectedFile();

            try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) 
            { 
                String line;
                String type = "none"; //usuarios o relaciones
                while ((line = reader.readLine()) != null) {
                     // Si la linea no contiene '@' significa que lo proximo es ese tipo de dato
                    if (!line.contains("@"))
                    {
                        System.out.println("Leyendo tipo de dato: " + line);

                        type = line;
                        continue; // hace que esta linea no haga nada mas y siga con la proxima
                    }
                    
                    switch (type)
                    {
                        case "usuarios": {
                            System.out.println(line);
                           
                            // Elimina el carcater '@'
                            String temp = line.substring(1);
                            
                            // Crea instancia usuario
                            User newUser = new User(temp);
                            
                            // Añade newUser a un hashmap auxiliar
                            tempUsers.insert(temp, newUser);
                            
                            // Añade newUser a la lista de la interfaz
                            addToList(temp);
                            
                            // Añade newUser a la lista principal de los usuarios
                            Database.addUser(newUser);
                            break;
                        }
                        
                        case "relaciones": {
                            
                             // Coma seguida de uno o más espacios para separar usuarios
                            String[] userNames = line.split(",\\s+");   
                            
                            // Elimina el caracter '@'
                            String temp = userNames[0].substring(1);
                            
                            // Buscar usuario al que se le añadira las relaciones
                            User mainUser = Database.searchUser(temp);
                            
                            // Buscar usuario para añadirlo como relacion
                            User relationUser = Database.searchUser(userNames[1].substring(1));
                            mainUser.relations.insert(relationUser); 
                            
                            System.out.println("Agregado " + relationUser.username + " a " + mainUser.username);
                            
                            break;
                        }
                    }
                }
                
                this.uploadtxt.setEnabled(false);
                this.graph = new GraphManager();
                this.graph.start();
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_uploadtxtActionPerformed
    
    boolean isSelected = false;
    private void jList1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseReleased
        int index = jList1.locationToIndex(evt.getPoint());
        if (index >= 0)
        {
            String tempSelected = jList1.getModel().getElementAt(index);
            
            // Obtiene el User del hashmap
            selected = Database.searchUser(tempSelected);

            // Se activan los botones cuando se selecciona un item
            // Es asi para que no se llame setEnabled ineccesariamente y
            // no afecta el funcionamiento del programa
            if(!isSelected)
            {
                editButton.setEnabled(true);
                delButton.setEnabled(true);
                removeRelation.setEnabled(true);
            }
            
            isSelected = true;
            System.out.println("Usuario seleccionado: " + selected.getUsername());
        }
    }//GEN-LAST:event_jList1MouseReleased

    private void delButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delButtonActionPerformed
        if(selectedFirst == selected) {
            selectedFirst = null;
            selectingUser = false;
        }
        
        this.graph.removeUserNode(selected);
        modelList.removeElement(selected.getUsername());
        Database.deleteUser(selected);
        this.graph.executeKosarajuAlgorithm();
    }//GEN-LAST:event_delButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String username = JOptionPane.showInputDialog(this, "Introduzca el nombre del nuevo usuario a crear (sin @):", "Crear nuevo usuario", JOptionPane.INFORMATION_MESSAGE);
        if(username.isBlank()) {
            JOptionPane.showMessageDialog(this, "El nombre de usuario no puede estar en blanco.");
            return;
        }
        
        if(Database.searchUser(username) != null) {
            JOptionPane.showMessageDialog(this, "Ya existe un usuario con ese nombre.");
            return;
        }
        
        User newUser = new User(username);
        Database.addUser(newUser);
        this.graph.addUserNode(newUser);
        addToList(username);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        if(!selectingUser) {
            selectedFirst = selected;
            selectingUser = true;
            System.out.println("" + selectedFirst);
            JOptionPane.showMessageDialog(this, "Selecciona otro usuario y vuelve a presionar el botón para agregar una relación.");
        } else {
            if(selected == null) {
                JOptionPane.showMessageDialog(this, "No seleccionaste un usuario al que agregar la relación. Selección cancelada.");
                selectingUser = false;
                selectedFirst = null;
                return;
            }
            
            if(selectedFirst == selected) {
                JOptionPane.showMessageDialog(this, "No puedes agregar una relación al mismo usuario. Selección cancelada.");
                selectingUser = false;
                selectedFirst = null;
                return;
            }
            
            if(this.graph.relationExists(selectedFirst, selected))
            {
                JOptionPane.showMessageDialog(this, "Ya existe una relación desde " + selectedFirst.getUsername() + " a " + selected.getUsername() + ". Selección cancelada.");
                selectingUser = false;
                selectedFirst = null;
                return;
            }
            
            selectingUser = false;
            selectedFirst.getRelations().insert(selected);
            this.graph.addRelation(selectedFirst, selected);
            JOptionPane.showMessageDialog(this, "Relación creada: " + selectedFirst.getUsername() + " -> " + selected.getUsername());
        }
    }//GEN-LAST:event_editButtonActionPerformed

    private void removeRelationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeRelationActionPerformed
        if(!selectingUser) {
            selectedFirst = selected;
            selectingUser = true;
            System.out.println("" + selectedFirst);
            JOptionPane.showMessageDialog(this, "Selecciona otro usuario y vuelve a presionar el botón para eliminar su relación.");
        } else {
            if(selected == null) {
                JOptionPane.showMessageDialog(this, "No seleccionaste un usuario al que eliminar la relación. Selección cancelada.");
                selectingUser = false;
                selectedFirst = null;
                return;
            }
            
            if(selectedFirst == selected) {
                JOptionPane.showMessageDialog(this, "No puedes eliminar una relación al mismo usuario. Selección cancelada.");
                selectingUser = false;
                selectedFirst = null;
                return;
            }
            
            if(!this.graph.relationExists(selectedFirst, selected))
            {
                JOptionPane.showMessageDialog(this, "No existe una relación desde " + selectedFirst.getUsername() + " a " + selected.getUsername() + ". Selección cancelada.");
                selectingUser = false;
                selectedFirst = null;
                return;
            }
            
            selectingUser = false;
            selectedFirst.getRelations().delete(selected);
            this.graph.removeRelation(selectedFirst, selected);
            JOptionPane.showMessageDialog(this, "Relación eliminada: " + selectedFirst.getUsername() + " -> " + selected.getUsername());
        }
    }//GEN-LAST:event_removeRelationActionPerformed


    public void addToList(String text)
    {
       modelList.addElement(text);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton delButton;
    private javax.swing.JButton editButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton removeRelation;
    private javax.swing.JButton uploadtxt;
    // End of variables declaration//GEN-END:variables
}
