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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


/**
 *
 * @author Anas
 */
public class TracksDataView extends javax.swing.JFrame {
  
     static ArrayList<Integer> TrackId_list = new ArrayList<>();
     static ArrayList<String> TracksName_list = new ArrayList<>();
     static ArrayList<Integer> AlbumId_list = new ArrayList<>();
     static ArrayList<Integer> MediaTypeId_list = new ArrayList<>();
     static ArrayList<Integer> GenreId_list = new ArrayList<>();
     static ArrayList<String> Composer_list = new ArrayList<>();
     static ArrayList<Integer> Milliseconds_list = new ArrayList<>();
     static ArrayList<Integer> Bytes_list = new ArrayList<>();
     static ArrayList<Double> UnitPrice_list = new ArrayList<>();
     int TableIndex;
     TableModel model;
   public boolean checkField(){
       try {
           int a = Integer.parseInt(TextTrackId.getText());
           int b = Integer.parseInt(TextAlbumId.getText());
           int c = Integer.parseInt(TextMediaTypeId.getText());
           int d = Integer.parseInt(TextGenreId.getText());
           int e = Integer.parseInt(TextMilliseconds.getText());
           int f = Integer.parseInt(TextBytes.getText());
           double g = Double.parseDouble(TextUnitPrice.getText());
       } catch (NumberFormatException e){
            return false;
       }
      return true;
   }
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
   public boolean checkNotEmpty(){
       
          if(TextTrackId.getText().isEmpty()){
              return false;
          }
         else if(TextTracksName.getText().isEmpty()){
              return false;
          }
         else if(TextAlbumId.getText().isEmpty()){
              return false;
          }
         else if(TextMediaTypeId.getText().isEmpty()){
              return false;
          }
         else if(TextGenreId.getText().isEmpty()){
              return false;
          }
         else if(TextComposer.getText().isEmpty()){
              return false;
          }
         else if(TextMilliseconds.getText().isEmpty()){
              return false;
          }
         else if(TextBytes.getText().isEmpty()){
              return false;
          }
         else if(TextUnitPrice.getText().isEmpty()){
              return false;
          }
           
         else {return true;}
   }
   
   public boolean checkUnique(){
      
   int a = Integer.parseInt(TextTrackId.getText());
       if(TrackId_list.contains(a)){
           return false;
       }
       else 
           return true;
   }
    public TracksDataView() {
     
    try (Socket clientSocket = new Socket("127.0.0.1",1342)) {
    ObjectOutputStream outToServer = new ObjectOutputStream(clientSocket.getOutputStream());
    ObjectInputStream inFromServer = new ObjectInputStream(clientSocket.getInputStream());
   
    String ReqAction ="ViewTracks";
    outToServer.writeObject(ReqAction);
    Data_Store.ClearAll();
    TrackId_list = (ArrayList<Integer>) inFromServer.readObject();
    Data_Store.SaveTrackId(TrackId_list);
    
    TracksName_list = (ArrayList<String>) inFromServer.readObject();
    Data_Store.SaveTracksName(TracksName_list);
        
    AlbumId_list = (ArrayList<Integer>) inFromServer.readObject();
    Data_Store.SaveAlbumId(AlbumId_list);    
    
    MediaTypeId_list = (ArrayList<Integer>) inFromServer.readObject();
    Data_Store.SaveMediaTypeId(MediaTypeId_list);
    
    GenreId_list = (ArrayList<Integer>) inFromServer.readObject();
    Data_Store.SaveGenreId(GenreId_list);
    
    Composer_list = (ArrayList<String>) inFromServer.readObject();
    Data_Store.SaveComposer(Composer_list);
    
    Milliseconds_list = (ArrayList<Integer>) inFromServer.readObject();
    Data_Store.SaveMilliseconds(Milliseconds_list);
    
    Bytes_list = (ArrayList<Integer>) inFromServer.readObject();
    Data_Store.SaveBytes(Bytes_list);
    
    UnitPrice_list = (ArrayList<Double>) inFromServer.readObject();
    Data_Store.SaveUnitPrice(UnitPrice_list);
    
    clientSocket.close();
    
    } catch (IOException ex) {
         Logger.getLogger(TracksDataView.class.getName()).log(Level.SEVERE, null, ex);
     } catch (ClassNotFoundException ex) {
         Logger.getLogger(TracksDataView.class.getName()).log(Level.SEVERE, null, ex);
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        TextTrackId = new javax.swing.JTextField();
        TextTracksName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        TextAlbumId = new javax.swing.JTextField();
        TextMediaTypeId = new javax.swing.JTextField();
        TextGenreId = new javax.swing.JTextField();
        TextUnitPrice = new javax.swing.JTextField();
        TextMilliseconds = new javax.swing.JTextField();
        TextComposer = new javax.swing.JTextField();
        TextBytes = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tracks Table");

        Table11.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Track Id", "Name", "Album Id", "MediaType Id", "Genre Id", "Composer", "Milliseconds", "Bytes", "UnitPrice"
            }
        ));
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

        jLabel1.setText("TrackId");

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

        jLabel3.setText("AlbumId");

        jLabel4.setText("MediaTypeId");

        jLabel5.setText("GenreId");

        jLabel6.setText("Composer");

        jLabel7.setText("Milliseconds");

        jLabel8.setText("Bytes");

        jLabel9.setText("UnitPrice");

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
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TextAlbumId, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TextTrackId, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addComponent(jLabel6))
                                    .addGap(42, 42, 42)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(TextMilliseconds, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(TextComposer, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(TextBytes, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(TextUnitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(TextGenreId, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TextMediaTypeId, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TextTracksName, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 998, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TextTrackId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TextTracksName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TextAlbumId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TextMediaTypeId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TextGenreId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(TextComposer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(TextMilliseconds, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(TextBytes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(TextUnitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5)
                .addContainerGap(47, Short.MAX_VALUE))
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
      
    String ReqAction ="UpdateTracks";
    outToServer.writeObject(ReqAction);
 
            
   
    int TempTrackId = Integer.parseInt(TextTrackId.getText());
    String TempTracksName = (TextTracksName.getText());
    int TempAlbumId = Integer.parseInt(TextAlbumId.getText());
    int TempMediaTypeId = Integer.parseInt(TextMediaTypeId.getText());
    int TempGenreId = Integer.parseInt(TextGenreId.getText());
    String TempComposer = (TextComposer.getText());
    int TempMilliseconds = Integer.parseInt(TextMilliseconds.getText());
    int TempBytes = Integer.parseInt(TextBytes.getText());
    double TempUnitPrice = Double.parseDouble(TextUnitPrice.getText());
     TableIndex = Table11.getSelectedRow();
        TableModel model = Table11.getModel();
       
     int TempUp =  Integer.parseInt( model.getValueAt(TableIndex, 0).toString() );   

    outToServer.writeObject(TempTrackId);
    outToServer.writeObject(TempTracksName);
    outToServer.writeObject(TempAlbumId);
    outToServer.writeObject(TempMediaTypeId);
    outToServer.writeObject(TempGenreId);
    outToServer.writeObject(TempComposer);
    outToServer.writeObject(TempMilliseconds);
    outToServer.writeObject(TempBytes);
    outToServer.writeObject(TempUnitPrice);
    outToServer.writeObject(TempUp);
   // outToServer.writeObject(UpIndex);
     
     
   
    TrackId_list = (ArrayList<Integer>) inFromServer.readObject();
    Data_Store.SaveTrackId(TrackId_list);
    
    TracksName_list = (ArrayList<String>) inFromServer.readObject();
    Data_Store.SaveTracksName(TracksName_list);
        
    AlbumId_list = (ArrayList<Integer>) inFromServer.readObject();
    Data_Store.SaveAlbumId(AlbumId_list);    
    
    MediaTypeId_list = (ArrayList<Integer>) inFromServer.readObject();
    Data_Store.SaveMediaTypeId(MediaTypeId_list);
    
    GenreId_list = (ArrayList<Integer>) inFromServer.readObject();
    Data_Store.SaveGenreId(GenreId_list);
    
    Composer_list = (ArrayList<String>) inFromServer.readObject();
    Data_Store.SaveComposer(Composer_list);
    
    Milliseconds_list = (ArrayList<Integer>) inFromServer.readObject();
    Data_Store.SaveMilliseconds(Milliseconds_list);
    
    Bytes_list = (ArrayList<Integer>) inFromServer.readObject();
    Data_Store.SaveBytes(Bytes_list);
    
    UnitPrice_list = (ArrayList<Double>) inFromServer.readObject();
    Data_Store.SaveUnitPrice(UnitPrice_list);
    
     clientSocket.close();
     Fill_Table();
    showMessageDialog(null,  "Updated");
    } catch (IOException ex) {
         Logger.getLogger(TracksDataView.class.getName()).log(Level.SEVERE, null, ex);
     } catch (ClassNotFoundException ex) {
         Logger.getLogger(TracksDataView.class.getName()).log(Level.SEVERE, null, ex);
     }
        }
     else if (!checkField() && !checkNotEmpty()) {
         TextTrackId.setText("");
    TextTracksName.setText("");
    TextAlbumId.setText("");
    TextMediaTypeId.setText("");
    TextGenreId.setText("");
    TextComposer.setText("");
    TextMilliseconds.setText("");
    TextBytes.setText("");
    TextUnitPrice.setText("");
         showMessageDialog(null, "Please enter the correct data and don't leave fields empty");}
     else if (!checkField()) {
     TextTrackId.setText("");
    TextTracksName.setText("");
    TextAlbumId.setText("");
    TextMediaTypeId.setText("");
    TextGenreId.setText("");
    TextComposer.setText("");
    TextMilliseconds.setText("");
    TextBytes.setText("");
    TextUnitPrice.setText("");
        showMessageDialog(null,  "Please enter the correct data");}
else if (!checkNotEmpty()) {
   TextTrackId.setText("");
    TextTracksName.setText("");
    TextAlbumId.setText("");
    TextMediaTypeId.setText("");
    TextGenreId.setText("");
    TextComposer.setText("");
    TextMilliseconds.setText("");
    TextBytes.setText("");
    TextUnitPrice.setText("");
        showMessageDialog(null,"Please don't leave fields empty");}
} else {
   TextTrackId.setText("");
    TextTracksName.setText("");
    TextAlbumId.setText("");
    TextMediaTypeId.setText("");
    TextGenreId.setText("");
    TextComposer.setText("");
    TextMilliseconds.setText("");
    TextBytes.setText("");
    TextUnitPrice.setText("");
        showMessageDialog(null,"Please select a row to update");
}
     
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    
     MessageFormat header = new MessageFormat("Report Print");
     MessageFormat footer = new MessageFormat("Page{0,number,integer}");
     try {
         Table11.print(JTable.PrintMode.NORMAL, header, footer); // TODO add your handling code here:
     } catch (PrinterException ex) {
         Logger.getLogger(TracksDataView.class.getName()).log(Level.SEVERE, null, ex);
     }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
if(checkField() && checkNotEmpty()){
    if(checkUnique())
    {
    try (Socket clientSocket = new Socket("127.0.0.1",1342)) {
    ObjectOutputStream outToServer = new ObjectOutputStream(clientSocket.getOutputStream());
    ObjectInputStream inFromServer = new ObjectInputStream(clientSocket.getInputStream());
      
    String ReqAction ="InsertToTracks";
    outToServer.writeObject(ReqAction);
    
    int TempTrackId = Integer.parseInt(TextTrackId.getText());
    String TempTracksName = (TextTracksName.getText());
    int TempAlbumId = Integer.parseInt(TextAlbumId.getText());
    int TempMediaTypeId = Integer.parseInt(TextMediaTypeId.getText());
    int TempGenreId = Integer.parseInt(TextGenreId.getText());
    String TempComposer = (TextComposer.getText());
    int TempMilliseconds = Integer.parseInt(TextMilliseconds.getText());
    int TempBytes = Integer.parseInt(TextBytes.getText());
    double TempUnitPrice = Double.parseDouble(TextUnitPrice.getText());
  
    outToServer.writeObject(TempTrackId);
    outToServer.writeObject(TempTracksName);
    outToServer.writeObject(TempAlbumId);
    outToServer.writeObject(TempMediaTypeId);
    outToServer.writeObject(TempGenreId);
    outToServer.writeObject(TempComposer);
    outToServer.writeObject(TempMilliseconds);
    outToServer.writeObject(TempBytes);
    outToServer.writeObject(TempUnitPrice);
     
    TrackId_list = (ArrayList<Integer>) inFromServer.readObject();
    Data_Store.SaveTrackId(TrackId_list);
    
    TracksName_list = (ArrayList<String>) inFromServer.readObject();
    Data_Store.SaveTracksName(TracksName_list);
        
    AlbumId_list = (ArrayList<Integer>) inFromServer.readObject();
    Data_Store.SaveAlbumId(AlbumId_list);    
    
    MediaTypeId_list = (ArrayList<Integer>) inFromServer.readObject();
    Data_Store.SaveMediaTypeId(MediaTypeId_list);
    
    GenreId_list = (ArrayList<Integer>) inFromServer.readObject();
    Data_Store.SaveGenreId(GenreId_list);
    
    Composer_list = (ArrayList<String>) inFromServer.readObject();
    Data_Store.SaveComposer(Composer_list);
    
    Milliseconds_list = (ArrayList<Integer>) inFromServer.readObject();
    Data_Store.SaveMilliseconds(Milliseconds_list);
    
    Bytes_list = (ArrayList<Integer>) inFromServer.readObject();
    Data_Store.SaveBytes(Bytes_list);
    
    UnitPrice_list = (ArrayList<Double>) inFromServer.readObject();
    Data_Store.SaveUnitPrice(UnitPrice_list);
     
     clientSocket.close();
    showMessageDialog(null,  "Inserted");
    } catch (IOException ex) {
         Logger.getLogger(TracksDataView.class.getName()).log(Level.SEVERE, null, ex);
     } catch (ClassNotFoundException ex) {
         Logger.getLogger(TracksDataView.class.getName()).log(Level.SEVERE, null, ex);
     }
        Fill_Table();    
    }
    else {
    TextTrackId.setText("");
    TextTracksName.setText("");
    TextAlbumId.setText("");
    TextMediaTypeId.setText("");
    TextGenreId.setText("");
    TextComposer.setText("");
    TextMilliseconds.setText("");
    TextBytes.setText("");
    TextUnitPrice.setText("");
        showMessageDialog(null, "This TrackId already exists!");
    }
} else if (!checkField() && !checkNotEmpty()) {
     TextTrackId.setText("");
    TextTracksName.setText("");
    TextAlbumId.setText("");
    TextMediaTypeId.setText("");
    TextGenreId.setText("");
    TextComposer.setText("");
    TextMilliseconds.setText("");
    TextBytes.setText("");
    TextUnitPrice.setText("");
    showMessageDialog(null, "Please enter the correct data and don't leave fields empty");
}
else if (!checkField()) {
     TextTrackId.setText("");
    TextTracksName.setText("");
    TextAlbumId.setText("");
    TextMediaTypeId.setText("");
    TextGenreId.setText("");
    TextComposer.setText("");
    TextMilliseconds.setText("");
    TextBytes.setText("");
    TextUnitPrice.setText("");
    showMessageDialog(null, "Please enter the correct data");}
else if (!checkNotEmpty()) {
     TextTrackId.setText("");
    TextTracksName.setText("");
    TextAlbumId.setText("");
    TextMediaTypeId.setText("");
    TextGenreId.setText("");
    TextComposer.setText("");
    TextMilliseconds.setText("");
    TextBytes.setText("");
    TextUnitPrice.setText("");
    showMessageDialog(null, "Please don't leave fields empty");}
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
if(checkField() && checkNotEmpty()){
     try (Socket clientSocket = new Socket("127.0.0.1",1342)) {
    ObjectOutputStream outToServer = new ObjectOutputStream(clientSocket.getOutputStream());
    ObjectInputStream inFromServer = new ObjectInputStream(clientSocket.getInputStream());
      
    String ReqAction ="DeleteFromTracks";
    outToServer.writeObject(ReqAction);
    
    int TempTrackId = Integer.parseInt(TextTrackId.getText());
    outToServer.writeObject(TempTrackId);
     
 
    TrackId_list = (ArrayList<Integer>) inFromServer.readObject();
    Data_Store.SaveTrackId(TrackId_list);
    
    TracksName_list = (ArrayList<String>) inFromServer.readObject();
    Data_Store.SaveTracksName(TracksName_list);
        
    AlbumId_list = (ArrayList<Integer>) inFromServer.readObject();
    Data_Store.SaveAlbumId(AlbumId_list);    
    
    MediaTypeId_list = (ArrayList<Integer>) inFromServer.readObject();
    Data_Store.SaveMediaTypeId(MediaTypeId_list);
    
    GenreId_list = (ArrayList<Integer>) inFromServer.readObject();
    Data_Store.SaveGenreId(GenreId_list);
    
    Composer_list = (ArrayList<String>) inFromServer.readObject();
    Data_Store.SaveComposer(Composer_list);
    
    Milliseconds_list = (ArrayList<Integer>) inFromServer.readObject();
    Data_Store.SaveMilliseconds(Milliseconds_list);
    
    Bytes_list = (ArrayList<Integer>) inFromServer.readObject();
    Data_Store.SaveBytes(Bytes_list);
    
    UnitPrice_list = (ArrayList<Double>) inFromServer.readObject();
    Data_Store.SaveUnitPrice(UnitPrice_list);
    
     clientSocket.close();
    showMessageDialog(null,  "Deleted");
    } catch (IOException | ClassNotFoundException ex) {
         Logger.getLogger(TracksDataView.class.getName()).log(Level.SEVERE, null, ex);
     }
        Fill_Table();
}        else if (!checkField() && !checkNotEmpty()) {
     TextTrackId.setText("");
    TextTracksName.setText("");
    TextAlbumId.setText("");
    TextMediaTypeId.setText("");
    TextGenreId.setText("");
    TextComposer.setText("");
    TextMilliseconds.setText("");
    TextBytes.setText("");
    TextUnitPrice.setText("");
    showMessageDialog(null, "Please enter the correct data and don't leave fields empty");
}
else if (!checkField()) {
     TextTrackId.setText("");
    TextTracksName.setText("");
    TextAlbumId.setText("");
    TextMediaTypeId.setText("");
    TextGenreId.setText("");
    TextComposer.setText("");
    TextMilliseconds.setText("");
    TextBytes.setText("");
    TextUnitPrice.setText("");
    showMessageDialog(null, "Please enter the correct data");}
else if (!checkNotEmpty()) {
     TextTrackId.setText("");
    TextTracksName.setText("");
    TextAlbumId.setText("");
    TextMediaTypeId.setText("");
    TextGenreId.setText("");
    TextComposer.setText("");
    TextMilliseconds.setText("");
    TextBytes.setText("");
    TextUnitPrice.setText("");
    showMessageDialog(null, "Please don't leave fields empty");}

    }//GEN-LAST:event_jButton3ActionPerformed

    private void Table11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table11MouseClicked
            TableIndex = Table11.getSelectedRow();
        TableModel model = Table11.getModel();
        //IdText.setText(model.getValueAt(i,0).toint());
        TextTrackId.setText( model.getValueAt(TableIndex, 0).toString() );
        TextTracksName.setText(model.getValueAt(TableIndex,1).toString());
        TextAlbumId.setText( model.getValueAt(TableIndex, 2).toString() );
        TextMediaTypeId.setText( model.getValueAt(TableIndex, 3).toString() );
        TextGenreId.setText( model.getValueAt(TableIndex, 4).toString() );
        TextComposer.setText( model.getValueAt(TableIndex, 5).toString() );
        TextMilliseconds.setText( model.getValueAt(TableIndex, 6).toString() );
        TextBytes.setText( model.getValueAt(TableIndex, 7).toString() );
        TextUnitPrice.setText( model.getValueAt(TableIndex, 8).toString() );
        
    }//GEN-LAST:event_Table11MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
      
    try (Socket clientSocket = new Socket("127.0.0.1",1342)) {
    ObjectOutputStream outToServer = new ObjectOutputStream(clientSocket.getOutputStream());
    ObjectInputStream inFromServer = new ObjectInputStream(clientSocket.getInputStream());
   
    String ReqAction ="ViewTracks";
    outToServer.writeObject(ReqAction);

    TrackId_list = (ArrayList<Integer>) inFromServer.readObject();
    Data_Store.SaveTrackId(TrackId_list);
    
    TracksName_list = (ArrayList<String>) inFromServer.readObject();
    Data_Store.SaveTracksName(TracksName_list);
        
    AlbumId_list = (ArrayList<Integer>) inFromServer.readObject();
    Data_Store.SaveAlbumId(AlbumId_list);    
    
    MediaTypeId_list = (ArrayList<Integer>) inFromServer.readObject();
    Data_Store.SaveMediaTypeId(MediaTypeId_list);
    
    GenreId_list = (ArrayList<Integer>) inFromServer.readObject();
    Data_Store.SaveGenreId(GenreId_list);
    
    Composer_list = (ArrayList<String>) inFromServer.readObject();
    Data_Store.SaveComposer(Composer_list);
    
    Milliseconds_list = (ArrayList<Integer>) inFromServer.readObject();
    Data_Store.SaveMilliseconds(Milliseconds_list);
    
    Bytes_list = (ArrayList<Integer>) inFromServer.readObject();
    Data_Store.SaveBytes(Bytes_list);
    
    UnitPrice_list = (ArrayList<Double>) inFromServer.readObject();
    Data_Store.SaveUnitPrice(UnitPrice_list);
    
    clientSocket.close();
    
    } catch (IOException ex) {
         Logger.getLogger(TracksDataView.class.getName()).log(Level.SEVERE, null, ex);
     } catch (ClassNotFoundException ex) {
         Logger.getLogger(TracksDataView.class.getName()).log(Level.SEVERE, null, ex);
     }
  
    TextTrackId.setText("");
    TextTracksName.setText("");
    TextAlbumId.setText("");
    TextMediaTypeId.setText("");
    TextGenreId.setText("");
    TextComposer.setText("");
    TextMilliseconds.setText("");
    TextBytes.setText("");
    TextUnitPrice.setText("");
    
    Fill_Table();
    showMessageDialog(null,  "Refreshd");
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
        public  void Fill_Table(){
 
             
               DefaultTableModel model = (DefaultTableModel)Table11.getModel();
               model.setRowCount(0);
               Object[] row = new Object[9];
               for(int i =0;i<TrackId_list.size();i++){
               row[0]=TrackId_list.get(i);
               row[1]=TracksName_list.get(i);
               row[2]=AlbumId_list.get(i);
               row[3]=MediaTypeId_list.get(i);
               row[4]=GenreId_list.get(i);
               row[5]=Composer_list.get(i);
               row[6]=Milliseconds_list.get(i);
               row[7]=Bytes_list.get(i);
               row[8]=UnitPrice_list.get(i);
               model.addRow(row);
            }             
    TextTrackId.setText("");
    TextTracksName.setText("");
    TextAlbumId.setText("");
    TextMediaTypeId.setText("");
    TextGenreId.setText("");
    TextComposer.setText("");
    TextMilliseconds.setText("");
    TextBytes.setText("");
    TextUnitPrice.setText("");
}


    
    public static void main(String args[]) {
    }
        
      public void run() {
               
                new TracksDataView().setVisible(true);
            }
   
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table11;
    private javax.swing.JTextField TextAlbumId;
    private javax.swing.JTextField TextBytes;
    private javax.swing.JTextField TextComposer;
    private javax.swing.JTextField TextGenreId;
    private javax.swing.JTextField TextMediaTypeId;
    private javax.swing.JTextField TextMilliseconds;
    private javax.swing.JTextField TextTrackId;
    private javax.swing.JTextField TextTracksName;
    private javax.swing.JTextField TextUnitPrice;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
