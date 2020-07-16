/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.awt.print.PrinterException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Anas
 */
public class PlaylistsDataView extends javax.swing.JFrame {

public static ArrayList<String> Name_list = new ArrayList<>();
public static ArrayList<Integer> Id_list = new ArrayList<>();
int TableIndex;
TableModel model;
public boolean rowSelected(){
int row = Table11.getSelectedRow();

if(row == -1)
{
    return false;
}
else
{
   return true;
}
}

  public boolean checkField(){
       try {
           int a = Integer.parseInt(TextId.getText());
    
       } catch (NumberFormatException e){
            return false;
       }
      return true;
   }
   public boolean checkNotEmpty(){
       
          if(TextId.getText().isEmpty()){
              return false;
          }
         else if(TextName.getText().isEmpty()){
              return false;
         }
           
         else {return true;}
   }
   
   public boolean checkUnique(){
      
   int a = Integer.parseInt(TextId.getText());
       if(Id_list.contains(a)){
           return false;
       }
       else 
           return true;
   }
    public PlaylistsDataView() {
        
try (Socket clientSocket = new Socket("127.0.0.1",1342)) {
    ObjectOutputStream outToServer = new ObjectOutputStream(clientSocket.getOutputStream());
    ObjectInputStream inFromServer = new ObjectInputStream(clientSocket.getInputStream());

    String ReqAction ="ViewPlaylists";
    outToServer.writeObject(ReqAction);
      
    Id_list = (ArrayList<Integer>) inFromServer.readObject();
    Data_Store.SavePlaylistId(Id_list);
    
    Name_list = (ArrayList<String>) inFromServer.readObject();
    Data_Store.SavePlaylistId(Name_list);
 
    clientSocket.close();
    
    } catch (IOException ex) {
         Logger.getLogger(PlaylistsDataView.class.getName()).log(Level.SEVERE, null, ex);
     } catch (ClassNotFoundException ex) {
         Logger.getLogger(PlaylistsDataView.class.getName()).log(Level.SEVERE, null, ex);
     }

     initComponents();
     Table11.setDefaultEditor(Object.class, null);
    // 
     Fill_Table();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Table11 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        TextId = new javax.swing.JTextField();
        TextName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Playlists Table");

        Table11.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Playlist Id", "Name"
            }
        ));
        Table11.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Table11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table11MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table11);

        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Print");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Playlist Id");

        jLabel2.setText("Name");

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Insert");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Refresh");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(42, 42, 42))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(TextName, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TextId, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(jButton5)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TextId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
if (rowSelected())
{
        if(checkField() && checkNotEmpty()){        
    try (Socket clientSocket = new Socket("127.0.0.1",1342)) {
    ObjectOutputStream outToServer = new ObjectOutputStream(clientSocket.getOutputStream());
    ObjectInputStream inFromServer = new ObjectInputStream(clientSocket.getInputStream());
      
    String ReqAction ="UpdatePlaylists";
    outToServer.writeObject(ReqAction);
 
            
    int TempId = Integer.parseInt(TextId.getText());
    String TempName = TextName.getText();
  TableIndex = Table11.getSelectedRow();
        TableModel model = Table11.getModel();
        
       
     int TempUp =  Integer.parseInt( model.getValueAt(TableIndex, 0).toString() );   


// int TempUp = Integer.parseInt(model.getValueAt(TableIndex, 0).toString());
    //int UpIndex = Id_list.indexOf(TempUp);
    
     outToServer.writeObject(TempId);
     outToServer.writeObject(TempName);
     outToServer.writeObject(TempUp);
    // outToServer.writeObject(UpIndex);
     
     
   
     Id_list = (ArrayList<Integer>) inFromServer.readObject();
     Data_Store.SavePlaylistId(Id_list);
   
     Name_list = (ArrayList<String>) inFromServer.readObject();
     Data_Store.SavePlaylistId(Name_list);
   
     clientSocket.close();
    showMessageDialog(null,"Updated");
    } catch (IOException ex) {
         Logger.getLogger(PlaylistsDataView.class.getName()).log(Level.SEVERE, null, ex);
     } catch (ClassNotFoundException ex) {
         Logger.getLogger(PlaylistsDataView.class.getName()).log(Level.SEVERE, null, ex);
     }
        Fill_Table();}
 else if (!checkField() && !checkNotEmpty()) {
    TextId.setText("");
    TextName.setText("");
        showMessageDialog(null, "Please enter the correct data and don't leave fields empty");
}
else if (!checkField()) {
     TextId.setText("");
    TextName.setText("");
        showMessageDialog(null,  "Please enter the correct data");}
else if (!checkNotEmpty()) {
     TextId.setText("");
    TextName.setText("");
        showMessageDialog(null,"Please don't leave fields empty");}
} else {
    TextId.setText("");
    TextName.setText("");
        showMessageDialog(null,"Please select a row to update");
}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     MessageFormat header = new MessageFormat("Report Print");
     MessageFormat footer = new MessageFormat("Page{0,number,integer}");
     
     try {
         Table11.print(JTable.PrintMode.NORMAL, header, footer); // TODO add your handling code here:
     } catch (PrinterException ex) {
         Logger.getLogger(PlaylistsDataView.class.getName()).log(Level.SEVERE, null, ex);
     }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
if(checkField() && checkNotEmpty()){
    if(checkUnique())
    {        
    try (Socket clientSocket = new Socket("127.0.0.1",1342)) {
    ObjectOutputStream outToServer = new ObjectOutputStream(clientSocket.getOutputStream());
    ObjectInputStream inFromServer = new ObjectInputStream(clientSocket.getInputStream());
      
    String ReqAction ="InsertToPlaylists";
    outToServer.writeObject(ReqAction);
    
    int TempId = Integer.parseInt(TextId.getText());
    String TempName = TextName.getText();
    
     outToServer.writeObject(TempId);
     outToServer.writeObject(TempName);
    
     
     Id_list = (ArrayList<Integer>) inFromServer.readObject();
    Data_Store.SavePlaylistId(Id_list);
    
    
    
     Name_list = (ArrayList<String>) inFromServer.readObject();
     Data_Store.SavePlaylistId(Name_list);
    
     clientSocket.close();
     
    Fill_Table();
    showMessageDialog(null,"Inserted");
    } catch (IOException ex) {
         Logger.getLogger(PlaylistsDataView.class.getName()).log(Level.SEVERE, null, ex);
     } catch (ClassNotFoundException ex) {
         Logger.getLogger(PlaylistsDataView.class.getName()).log(Level.SEVERE, null, ex);
     }
        }
    else {
    TextId.setText("");
    TextName.setText("");
        showMessageDialog(null, "This Id already exists!");
    }
} else if (!checkField() && !checkNotEmpty()) {
    TextId.setText("");
    TextName.setText("");
        showMessageDialog(null, "Please enter the correct data and don't leave fields empty");
}
else if (!checkField()) {
     TextId.setText("");
    TextName.setText("");
        showMessageDialog(null,  "Please enter the correct data");}
else if (!checkNotEmpty()) {
     TextId.setText("");
    TextName.setText("");
        showMessageDialog(null,"Please don't leave fields empty");}
         
    
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
if(checkField() && checkNotEmpty()){          
    try (Socket clientSocket = new Socket("127.0.0.1",1342)) {
    ObjectOutputStream outToServer = new ObjectOutputStream(clientSocket.getOutputStream());
    ObjectInputStream inFromServer = new ObjectInputStream(clientSocket.getInputStream());
      
    String ReqAction ="DeleteFromPlaylists";
    outToServer.writeObject(ReqAction);
    
    int TempId = Integer.parseInt(TextId.getText());
    outToServer.writeObject(TempId);
   
    int DelIndex = Id_list.indexOf(TempId);
    outToServer.writeObject(DelIndex);
  
    Id_list = (ArrayList<Integer>) inFromServer.readObject();
    Data_Store.SavePlaylistId(Id_list);
    
     Name_list = (ArrayList<String>) inFromServer.readObject();
     Data_Store.SavePlaylistId(Name_list);
    
     clientSocket.close();
    showMessageDialog(null,"Deleted");
    } catch (IOException ex) {
         Logger.getLogger(PlaylistsDataView.class.getName()).log(Level.SEVERE, null, ex);
     } catch (ClassNotFoundException ex) {
         Logger.getLogger(PlaylistsDataView.class.getName()).log(Level.SEVERE, null, ex);
     }
        Fill_Table();}
else if (!checkField() && !checkNotEmpty()) {
    TextId.setText("");
    TextName.setText("");
        showMessageDialog(null, "Please enter the correct data and don't leave fields empty");
}
else if (!checkField()) {
     TextId.setText("");
    TextName.setText("");
        showMessageDialog(null,  "Please enter the correct data");}
else if (!checkNotEmpty()) {
     TextId.setText("");
    TextName.setText("");
        showMessageDialog(null,"Please don't leave fields empty");}
         
    
    }//GEN-LAST:event_jButton3ActionPerformed

    private void Table11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table11MouseClicked
        // Table11.setEnabled(true);    
      
       // Table11.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
        TableIndex = Table11.getSelectedRow();
        TableModel model = Table11.getModel();
        //IdText.setText(model.getValueAt(i,0).toint());
        TextId.setText( model.getValueAt(TableIndex, 0).toString() );
        TextName.setText(model.getValueAt(TableIndex,1).toString());
        // Table11.setEnabled(false);
   
        
    }//GEN-LAST:event_Table11MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed


try (Socket clientSocket = new Socket("127.0.0.1",1342)) {
    ObjectOutputStream outToServer = new ObjectOutputStream(clientSocket.getOutputStream());
    ObjectInputStream inFromServer = new ObjectInputStream(clientSocket.getInputStream());
     //Scanner scan = new Scanner(System.in);
  //  for(int i=0;i<10;i++)
      //  arr[i]=inFromUser.nextInt();
      
     
       // String cMessage ="";
    // cMessage = scan.nextLine();
String ReqAction ="ViewPlaylists";
    outToServer.writeObject(ReqAction);
    
     
     Id_list = (ArrayList<Integer>) inFromServer.readObject();
    Data_Store.SavePlaylistId(Id_list);
    
    
    
     Name_list = (ArrayList<String>) inFromServer.readObject();
     Data_Store.SavePlaylistId(Name_list);
        
        
       
    } catch (IOException ex) {
         Logger.getLogger(PlaylistsDataView.class.getName()).log(Level.SEVERE, null, ex);
     } catch (ClassNotFoundException ex) {
         Logger.getLogger(PlaylistsDataView.class.getName()).log(Level.SEVERE, null, ex);
     }
     TextId.setText("");
     TextName.setText("");
     Fill_Table();
     showMessageDialog(null,"Refreshed");
    }//GEN-LAST:event_jButton5ActionPerformed

        public  void Fill_Table(){
 
             

               DefaultTableModel model = (DefaultTableModel)Table11.getModel();
               model.setRowCount(0);
               Object[] row = new Object[2];
               for(int i =0;i<Id_list.size();i++){
               row[0]=Id_list.get(i);
               row[1]=Name_list.get(i);
               model.addRow(row);
       
            }
               
       TextId.setText("");
    TextName.setText("");
       Data_Store.ClearAll();  
}


    
    public static void main(String args[]) {
    }
        
      public void run() {
               
                new PlaylistsDataView().setVisible(true);
            }
   
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table11;
    private javax.swing.JTextField TextId;
    private javax.swing.JTextField TextName;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
