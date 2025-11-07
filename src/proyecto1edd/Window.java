/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto1edd;
import java.io.File;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author biancazullo
 */


public class Window extends javax.swing.JFrame {

    private User selected;
    private User selectedFirst;
    private final DefaultListModel<String> modelList = new DefaultListModel<>();
    private boolean loadedFile = false;
    
    public Window() {
        initComponents();
        allUsersDynamicList.setModel(modelList);
        savetxt.setEnabled(false);
        userGuide.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        uploadtxt = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        allUsersDynamicList = new javax.swing.JList<>();
        createUserButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        helpButton = new javax.swing.JButton();
        savetxt = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        userGuide = new javax.swing.JTextArea();

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

        allUsersDynamicList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        allUsersDynamicList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        allUsersDynamicList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                allUsersDynamicListMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(allUsersDynamicList);

        createUserButton.setText("Crear");
        createUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createUserButtonActionPerformed(evt);
            }
        });

        editButton.setText("Editar");
        editButton.setEnabled(false);
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Eliminar");
        deleteButton.setEnabled(false);
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        helpButton.setText("Ayuda");
        helpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(createUserButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(helpButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(createUserButton)
                        .addComponent(deleteButton)
                        .addComponent(helpButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                .addContainerGap())
        );

        savetxt.setText("Guardar archivo");
        savetxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savetxtActionPerformed(evt);
            }
        });

        userGuide.setEditable(false);
        userGuide.setColumns(20);
        userGuide.setRows(5);
        userGuide.setText("Bienvenid@ a nuestra guía de usuario para el manejo de\npágina representación gráfica de relaciones de usuario \npara cualquier red social!\nA continuación, les porporcionamos como operar nuestro \nprograma --->\n\n- Para cargar archivo: presione el botón \"Cargar archivo\" \ny seleccione un archivo txt. Y listo! Su grafo será mostrado\n en otra ventana.\n\n- Para crear un nuevo usuario: presione en botón \"Crear\", \ningrese el nombre del nuevo usuario y presione el botón \n\"Aceptar\".\n\n- Para eliminar un usuario: seleccione el usuario a eliminar\ny presione el botón \"Eliminar\". Su grafo se actualizará \nautomaticamente.\n\n- Para agregar una relación: seleccione el \nusuario al que desea relacionar con otro, \npresione el botón de \"Editar\". Se abrirá una \nnueva ventana, seleccione un usuario de la \nlista \"Usuarios Disponibles\" y presione el \nbotón \"Agregar\". Ahora su primer usuario \nseleccionado \"sigue\" al otro usuario. \nRepita este paso para agregar mas \nrelaciones, y luego presione el botón \"Aceptar\". \nEl grafo mostrado se actualizará automaticamente.\n\n- Para eliminar una relación: seleccione el usuario al \nque desea eliminarle relaciones y presione el botón \n\"Editar\". Se abrirá una nueva ventana, seleccione un \nusuario de la lista \"Relaciones\" y presione el botón \n\"Eliminar\". Repita este paso para eliminar mas \nrelaciones, y luego presione el botón \"Aceptar\". El grafo\nmostrado se actualizará automaticamente.\n\n- Para actualizar el archivo txt: luego de efectuar los \ncambios deseados, presione el botón \"Guardar Archivo\"\n y su archivo txt se actializará y guardará \nautomaticamente. \n\n- Para ocultar la guía de usuario: presione nuevamente \nel botón \"Ayuda\".\n\nGracias por preferirnos! Que tenga un buen día! <3\n");
        jScrollPane1.setViewportView(userGuide);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(uploadtxt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(savetxt))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(uploadtxt, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                            .addComponent(savetxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * 
     * @param evt 
     * 
     */
    private void uploadtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadtxtActionPerformed
        if(loadedFile) {
            int ret = JOptionPane.showConfirmDialog(this, "Estás a punto de cargar otro archivo. Antes de hacerlo, deberías guardar los cambios que hayas hecho en el archivo actual.", "Cargar archivo", JOptionPane.OK_CANCEL_OPTION);
            if(ret == JOptionPane.CANCEL_OPTION)
                return;
        }
        
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo txt", "txt");
        chooser.setFileFilter(filter);
        chooser.setMultiSelectionEnabled(false);
        int returnValue = chooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION)
        {
            if(loadedFile) {
                GraphManager.graphManager.clear();
                Database.clearUsers();
            }
            
            File selectedFile = chooser.getSelectedFile();
            Database.Load(selectedFile);
            Node<User> current = Database.getUsers().first();
            while (current != null) {
                User temp = current.getData();
                modelList.addElement(temp.username);
                current = current.getNext();
            }
            savetxt.setEnabled(true);
            loadedFile = true;
        }
    }//GEN-LAST:event_uploadtxtActionPerformed
    
    /**
     * activates buttons when an item is selected
     * to avoid calling setEnabled needlessly 
     * doesn't affect the functioning of the program
     */
    
    boolean isSelected = false;
    private void allUsersDynamicListMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_allUsersDynamicListMouseReleased
        int index = allUsersDynamicList.locationToIndex(evt.getPoint());
        if (index >= 0)
        {
            String tempSelected = allUsersDynamicList.getModel().getElementAt(index);
            selected = Database.searchUser(tempSelected);
            if(!isSelected)
            {
                editButton.setEnabled(true);
                deleteButton.setEnabled(true);
            }          
            isSelected = true;
            System.out.println("Usuario seleccionado: " + selected.getUsername());
        }
    }//GEN-LAST:event_allUsersDynamicListMouseReleased

    
    /**
     * deletes node and relations associated with said node 
     * executes algorithm again to automatically update graph
     * @param evt 
     */
    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        if(selectedFirst == selected) {
            selectedFirst = null;
        }
        GraphManager.graphManager.removeUserNode(selected);
        modelList.removeElement(selected.getUsername());
        Database.deleteUser(selected);
        GraphManager.graphManager.executeKosarajuAlgorithm();
    }//GEN-LAST:event_deleteButtonActionPerformed

    
    /**
     * opens the CreateUser window
     * @param evt 
     */
    private void createUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createUserButtonActionPerformed
        CreateUser cu = new CreateUser(null);
        cu.setVisible(true);
    }//GEN-LAST:event_createUserButtonActionPerformed

    /**
     * gets selected value from all users list 
     * opens CreateUser window
     * @param evt 
     */
    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed

        String value = allUsersDynamicList.getSelectedValue();
        CreateUser cu = new CreateUser(value);
        cu.setVisible(true);
    }//GEN-LAST:event_editButtonActionPerformed

    /**
     * saves changes in txt file
     * @param evt 
     */
    private void savetxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savetxtActionPerformed
        Database.Save();
    }//GEN-LAST:event_savetxtActionPerformed

    /**
     * shows user guide
     * @param evt 
     */
    private void helpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpButtonActionPerformed
        userGuide.setVisible(!userGuide.isVisible());
    }//GEN-LAST:event_helpButtonActionPerformed

    /**
     * adds element to model list
     * @param text 
     */
    public void addToList(String text)
    {
       modelList.addElement(text);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> allUsersDynamicList;
    private javax.swing.JButton createUserButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JButton helpButton;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton savetxt;
    private javax.swing.JButton uploadtxt;
    private javax.swing.JTextArea userGuide;
    // End of variables declaration//GEN-END:variables
}
