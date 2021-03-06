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
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Anas
 */
public class PlaylistTrackDataView extends javax.swing.JFrame {
 
      public static ArrayList<Integer> PlaylistId_list = new ArrayList<>();
      public static ArrayList<Integer> TrackId_list = new ArrayList<>();
      public static ArrayList<Integer> checkPlaylistId_list = new ArrayList<>();
      public static ArrayList<Integer> checkTrackId_list = new ArrayList<>();
      public static HashMap<Integer, Integer> PlaylistTrack_hash = new HashMap<Integer, Integer>();
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
}}
   public boolean checkField(){
       try {
           int a = Integer.parseInt(Text_PlaylistId.getText());
           int b = Integer.parseInt(Text_TrackId.getText());
    
       } catch (NumberFormatException e){
            return false;
       }
      return true;
   }
   public boolean checkNotEmpty(){
       
          if(Text_PlaylistId.getText().isEmpty()){
              return false;
          }
         else if(Text_TrackId.getText().isEmpty()){
              return false;
         }
           
         else {return true;}
   }
   
   public boolean checkExists(){
      
   int a = Integer.parseInt(Text_TrackId.getText());
    int b = Integer.parseInt(Text_PlaylistId.getText());
       if(checkTrackId_list.contains(a) && checkPlaylistId_list.contains(b)){
           return true;
       }
       
       return false;
   }
   public boolean checkUsed(){
      
   int a = Integer.parseInt(Text_TrackId.getText());
     TableIndex = Table11.getSelectedRow();
        TableModel model = Table11.getModel();
      int TempTest =  Integer.parseInt( model.getValueAt(TableIndex, 1).toString() ); 
       if(TrackId_list.contains(a)&& a == TempTest){
           return true;
       }
       
       return false;
   }
    public PlaylistTrackDataView() {
        
    try (Socket clientSocket = new Socket("127.0.0.1",1342)) {
    ObjectOutputStream outToServer = new ObjectOutputStream(clientSocket.getOutputStream());
    ObjectInputStream inFromServer = new ObjectInputStream(clientSocket.getInputStream());

    String ReqAction ="ViewPlaylist_Track";
    outToServer.writeObject(ReqAction);


    
    PlaylistId_list = (ArrayList<Integer>) inFromServer.readObject();
    Data_Store.SavePlaylistId(PlaylistId_list);
    
    TrackId_list = (ArrayList<Integer>) inFromServer.readObject();
    Data_Store.SaveTrackId(TrackId_list);

    clientSocket.close();
    
     } catch (IOException ex) {
         Logger.getLogger(PlaylistTrackDataView.class.getName()).log(Level.SEVERE, null, ex);
     } catch (ClassNotFoundException ex) {
         Logger.getLogger(PlaylistTrackDataView.class.getName()).log(Level.SEVERE, null, ex);
     }

     initComponents();
      Table11.setDefaultEditor(Object.class, null);
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
        jButton2 = new javax.swing.JButton();
        Text_PlaylistId = new javax.swing.JTextField();
        Text_TrackId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PlaylistTrack Table");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowDeactivated(java.awt.event.WindowEvent evt) {
                formWindowDeactivated(evt);
            }
        });

        Table11.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Playlist Id", "Track Id"
            }
        ));
        Table11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table11MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table11);

        jButton2.setText("Print");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Playlist Id");

        jLabel2.setText("Track Id");

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Text_TrackId, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Text_PlaylistId, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)))
                .addGap(10, 10, 10)
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
                    .addComponent(Text_PlaylistId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Text_TrackId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(87, 87, 87)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton5)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     MessageFormat header = new MessageFormat("Report Print");
     MessageFormat footer = new MessageFormat("Page{0,number,integer}");
    
     try {
         Table11.print(JTable.PrintMode.NORMAL, header, footer); // TODO add your handling code here:
     } catch (PrinterException ex) {
         Logger.getLogger(PlaylistTrackDataView.class.getName()).log(Level.SEVERE, null, ex);
     }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
if(checkField() && checkNotEmpty()){          
    try (Socket clientSocket = new Socket("127.0.0.1",1342)) {
    ObjectOutputStream outToServer = new ObjectOutputStream(clientSocket.getOutputStream());
    ObjectInputStream inFromServer = new ObjectInputStream(clientSocket.getInputStream());
      
    String ReqAction ="DeleteFromPlaylist_Track";
    outToServer.writeObject(ReqAction);
    
    int tempTrackId = Integer.parseInt(Text_TrackId.getText());
    outToServer.writeObject(tempTrackId);
//
int index= TrackId_list.indexOf(tempTrackId);
    
    //outToServer.writeObject(index);
//
    PlaylistId_list = (ArrayList<Integer>) inFromServer.readObject();
    Data_Store.SavePlaylistId(PlaylistId_list);
   
    TrackId_list = (ArrayList<Integer>) inFromServer.readObject();
    Data_Store.SavePlaylistId(TrackId_list);
     clientSocket.close();
    showMessageDialog(null,  "Deleted");
    } catch (IOException | ClassNotFoundException ex) {
         Logger.getLogger(PlaylistTrackDataView.class.getName()).log(Level.SEVERE, null, ex);
     }
        Fill_Table();} else if (!checkField() && !checkNotEmpty()) {
    Text_PlaylistId.setText("");
    Text_TrackId.setText("");
        showMessageDialog(null, "Please enter the correct data and don't leave fields empty");
}
else if (!checkField()) {
     Text_PlaylistId.setText("");
    Text_TrackId.setText("");
        showMessageDialog(null,  "Please enter the correct data");}
else if (!checkNotEmpty()) {
     Text_PlaylistId.setText("");
    Text_TrackId.setText("");
        showMessageDialog(null,"Please don't leave fields empty");}  
    
    }//GEN-LAST:event_jButton3ActionPerformed

    private void Table11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table11MouseClicked

        TableIndex = Table11.getSelectedRow();
        TableModel model = Table11.getModel();
        Text_PlaylistId.setText( model.getValueAt(TableIndex, 0).toString() );
        Text_TrackId.setText(model.getValueAt(TableIndex,1).toString());
        
    }//GEN-LAST:event_Table11MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
   
    try (Socket clientSocket = new Socket("127.0.0.1",1342)) {
    ObjectOutputStream outToServer = new ObjectOutputStream(clientSocket.getOutputStream());
    ObjectInputStream inFromServer = new ObjectInputStream(clientSocket.getInputStream());

    String ReqAction ="ViewPlaylist_Track";
    outToServer.writeObject(ReqAction);
  
    PlaylistId_list = (ArrayList<Integer>) inFromServer.readObject();
    Data_Store.SavePlaylistId(PlaylistId_list);
    
    TrackId_list = (ArrayList<Integer>) inFromServer.readObject();
    Data_Store.SaveTrackId(TrackId_list);

    clientSocket.close();
    
     } catch (IOException ex) {
         Logger.getLogger(PlaylistTrackDataView.class.getName()).log(Level.SEVERE, null, ex);
     } catch (ClassNotFoundException ex) {
         Logger.getLogger(PlaylistTrackDataView.class.getName()).log(Level.SEVERE, null, ex);
     }

     Text_PlaylistId.setText("");
     Text_TrackId.setText("");
     Fill_Table();
     showMessageDialog(null,  "Refreshd");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
          new ChooseData().setVisible(true);
  
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
            new ChooseData().setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void formWindowDeactivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowDeactivated
;          new ChooseData().setVisible(true);
    }//GEN-LAST:event_formWindowDeactivated

    /**
     * @param args the command line arguments
     */
        public  void Fill_Table(){
 
             
               DefaultTableModel model = (DefaultTableModel)Table11.getModel();
               model.setRowCount(0);
               Object[] row = new Object[2];
               for(int i =0;i<PlaylistId_list.size();i++){
               row[0]=PlaylistId_list.get(i);
               row[1]=TrackId_list.get(i);
               model.addRow(row);
            }
     
               Text_PlaylistId.setText("");
    Text_TrackId.setText("");
               Data_Store.ClearAll();
}


    
    public static void main(String args[]) {
    }
        
      public void run() {
               
                new PlaylistTrackDataView().setVisible(true);
            }
   
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table11;
    private javax.swing.JTextField Text_PlaylistId;
    private javax.swing.JTextField Text_TrackId;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
