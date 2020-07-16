package Server;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.sqlite.SQLiteConfig;



public class RunCode implements Runnable {
    
    protected Socket clientSocket = null;
 
    public RunCode(Socket clientSocket){
        this.clientSocket = clientSocket;
        
    }
     int PlaylistId,PlaylistId_Text, TrackId,TrackId_Text,AlbumId, AlbumId_Text, MediaTypeId, MediaTypeId_Text, GenreId, GenreId_Text,Milliseconds,Milliseconds_Text,Bytes,Bytes_Text, UpdateId, UpdateIndex;
     String PlaylistName, PlaylistName_Text, TracksName, TracksName_Text, Composer,Composer_Text;
     Double UnitPrice,UnitPrice_Text;
  
     static ArrayList<String> PlaylistName_list = new ArrayList<>();
     static ArrayList<Integer> PlaylistId_list = new ArrayList<>();
     static ArrayList<Integer> TrackId_list = new ArrayList<>();
     static ArrayList<Integer> checkPlaylistId_list = new ArrayList<>();
     static ArrayList<Integer> checkTrackId_list = new ArrayList<>();
     static ArrayList<String> TracksName_list = new ArrayList<>();
     static ArrayList<Integer> AlbumId_list = new ArrayList<>();
     static ArrayList<Integer> MediaTypeId_list = new ArrayList<>();
     static ArrayList<Integer> GenreId_list = new ArrayList<>();
     static ArrayList<String> Composer_list = new ArrayList<>();
     static ArrayList<Integer> Milliseconds_list = new ArrayList<>();
     static ArrayList<Integer> Bytes_list = new ArrayList<>();
     static ArrayList<Double> UnitPrice_list = new ArrayList<>();
     static HashMap<Integer, Integer> PlaylistTrack_hash = new HashMap<Integer, Integer>();
      ObjectInputStream inFromClient = null;
      ObjectOutputStream outToClient = null;
     public static final String DB_URL = "jdbc:sqlite:chinook.db";  
     public static final String DRIVER = "org.sqlite.JDBC";  
     

public static Connection connect() throws ClassNotFoundException {  
    Class.forName(DRIVER);  
    Connection conn = null;  
    try {  
        SQLiteConfig config = new SQLiteConfig();  
        config.enforceForeignKeys(true);  
        conn = DriverManager.getConnection(DB_URL,config.toProperties());  
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }  
    return conn;  }

    public void run() {
        String ActionCalled = null;
        try {
            inFromClient = new ObjectInputStream(clientSocket.getInputStream());
             outToClient = new ObjectOutputStream(clientSocket.getOutputStream());
             if ((inFromClient == null)) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(RunCode.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                } else 
             ActionCalled = (String) inFromClient.readObject();
            switch (ActionCalled) {
                case "ViewPlaylists":
                    ViewPlaylists();
                    break;
                    
                case "InsertToPlaylists" :
                  InsertToPlaylists();
                    break;
                    
                case "DeleteFromPlaylists" :
                   DeleteFromPlaylists();
                    break;
                    
                case "UpdatePlaylists":
                    UpdatePlaylists();
                    break;
                    
                case "ViewPlaylist_Track":
                   ViewPlaylist_Track();
                    break;
                    
                    
                case "DeleteFromPlaylist_Track" :
                   DeleteFromPlaylist_Track();
                    break;
                    
                case "UpdatePlaylist_Track":
                 UpdateFromPlaylist_Track();
                    break;
                    
                case "ViewTracks":
                  ViewTracks(); 
                    break;
                    
                case "InsertToTracks" :
                    InsertToTracks();
                    break;
                    
                case "DeleteFromTracks" :
                    DeleteFromTracks();
                    break;
                    
                case "UpdateTracks":
                    UpdateTracks();
                    break;
                    
                default:System.out.println("Invalid");
                break;  }
            
            inFromClient.close();
            outToClient.close();
            clientSocket.close();
            
        } catch (IOException ex) {
            Logger.getLogger(RunCode.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RunCode.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                inFromClient.close();
            } catch (IOException ex) {
                Logger.getLogger(RunCode.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
 public void ViewPlaylists() throws ClassNotFoundException, IOException{
   
                    
                    try (Connection conn = this.connect();
                            Statement stmt  = conn.createStatement();
                            ResultSet rs    = stmt.executeQuery("SELECT PlaylistId, Name FROM playlists")){
                        
                        // loop through the result set
                        PlaylistId_list.clear();
                        PlaylistName_list.clear();
                        
                        while (rs.next()) {
                            PlaylistId_list.add((rs.getInt("PlaylistId")));
                            PlaylistName_list.add((rs.getString("Name")));
                        }
                        
                        outToClient.writeObject(PlaylistId_list);
                        outToClient.writeObject(PlaylistName_list);
                        
                    }
                    catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
}
 
 public void InsertToPlaylists() throws IOException, ClassNotFoundException{
     
                    PlaylistId_Text = (Integer) inFromClient.readObject();
                    PlaylistName_Text = (String) inFromClient.readObject();
                   
                    try (Connection conn = this.connect();
                           
                            PreparedStatement stat = (PreparedStatement) conn.prepareStatement("INSERT INTO Playlists(PlaylistID,Name)Values(?,?)");){
                        
                        
                        stat.setInt(1, PlaylistId_Text);
                        stat.setString(2, PlaylistName_Text);
                        stat.executeUpdate();
                        stat.close();
                        
                        PlaylistId_list.add(PlaylistId_Text);
                        PlaylistName_list.add(PlaylistName_Text);
                        
                        outToClient.writeObject(PlaylistId_list);
                        outToClient.writeObject(PlaylistName_list);
                        
                        PlaylistId_list.clear();
                        PlaylistName_list.clear();
                        
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
 }

public void DeleteFromPlaylists() throws ClassNotFoundException, IOException{
                   
                    PlaylistId_Text = (Integer) inFromClient.readObject();

                    try (Connection conn = this.connect();
                           PreparedStatement stat = (PreparedStatement) conn.prepareStatement("delete from Playlists where PlaylistId=?");){
                        
                        
                        stat.setInt(1, PlaylistId_Text);
                        stat.executeUpdate();
                        stat.close();
                        
                        int Del = (Integer) inFromClient.readObject();
                        
                        PlaylistId_list.remove(Del);
                        PlaylistName_list.remove(Del);
                        
                        outToClient.writeObject(PlaylistId_list);
                        outToClient.writeObject(PlaylistName_list);
                        
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
}

public void UpdatePlaylists() throws IOException, ClassNotFoundException{
    
                    PlaylistId_Text = (Integer) inFromClient.readObject();
                    PlaylistName_Text =(String) inFromClient.readObject();
                  UpdateId =(Integer) inFromClient.readObject();
                  //  UpdateIndex =(Integer) inFromClient.readObject();

                    
                        try (Connection conn = this.connect();
                                 PreparedStatement stat = (PreparedStatement) conn.prepareStatement("update Playlists " + "set PlaylistId = ?, " + "Name = ?" + "where PlaylistId = ?");){
                            
                           
                            
                            stat.setInt(1, PlaylistId_Text);
                            stat.setString(2, PlaylistName_Text);
                            stat.setInt(3, UpdateId);
                            stat.executeUpdate();
                            stat.close();
                            int Up = PlaylistId_list.indexOf(UpdateId);
                            PlaylistId_list.set(Up, PlaylistId_Text);
                            PlaylistName_list.set(Up, PlaylistName_Text);
                            
                            outToClient.writeObject(PlaylistId_list);
                            outToClient.writeObject(PlaylistName_list);
                            
                        } catch (SQLException e) {
                            System.out.println(e.getMessage());
                        }
}

public void ViewPlaylist_Track() throws ClassNotFoundException, IOException{
        
    try (Connection conn = this.connect();
                            Statement stmt  = conn.createStatement();
                            ResultSet rs    = stmt.executeQuery("SELECT PlaylistId, TrackId FROM playlist_Track")){
                       
                            PlaylistId_list.clear();
                            TrackId_list.clear();
                            
                        while (rs.next()) {
                            
                            PlaylistId_list.add((rs.getInt("PlaylistId")));
                            TrackId_list.add((rs.getInt("TrackId")));
                            
                        } 
                        
                        outToClient.writeObject(PlaylistId_list);
                        outToClient.writeObject(TrackId_list);
                        
                    }
                    catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
}


public void DeleteFromPlaylist_Track() throws IOException, ClassNotFoundException{
                    TrackId_Text = (Integer) inFromClient.readObject();
                  
                    try (Connection conn = this.connect();
                            PreparedStatement stat = (PreparedStatement) conn.prepareStatement("delete from Playlist_Track where TrackId=?");){
                        
                        
                        stat.setInt(1, TrackId_Text);
                        stat.executeUpdate();
                        stat.close();
                        
                       int Del = TrackId_list.indexOf(TrackId_Text);
                        
            
          PlaylistId_list.remove(Del);
                     TrackId_list.remove(Del);
                        
                        outToClient.writeObject(PlaylistId_list);
                        outToClient.writeObject(TrackId_list);
                        
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
}

public void UpdateFromPlaylist_Track() throws IOException, ClassNotFoundException{
                    PlaylistId_Text = (Integer) inFromClient.readObject();
                    TrackId_Text =(Integer) inFromClient.readObject();
                    UpdateId =(Integer) inFromClient.readObject();
                   
             
                    try (Connection conn = this.connect();
                            PreparedStatement stat = (PreparedStatement) conn.prepareStatement("update Playlist_Track " + "set PlaylistId = ?, " + "TrackId = ?" + "where TrackId = ?");){
                        
                        stat.setInt(1, PlaylistId_Text);
                        stat.setInt(2, TrackId_Text);
                        stat.setInt(3, UpdateId);
                        stat.executeUpdate();
                        stat.close();
                     int index = TrackId_list.indexOf(UpdateId);
                        PlaylistId_list.set(index, PlaylistId_Text);
                        TrackId_list.set(index, TrackId_Text);
                        
                        outToClient.writeObject(PlaylistId_list);
                        outToClient.writeObject(TrackId_list);
                        
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
}

public void ViewTracks() throws ClassNotFoundException, IOException{
    
                        try (Connection conn = this.connect();
                            Statement stmt  = conn.createStatement();
                            ResultSet rs    = stmt.executeQuery("SELECT TrackId, Name, AlbumId, MediaTypeId, GenreId, Composer,Milliseconds, Bytes,UnitPrice FROM Tracks")){
                        
                            TrackId_list.clear();
                            TracksName_list.clear();
                            AlbumId_list.clear();
                            MediaTypeId_list.clear();
                            GenreId_list.clear();
                            Composer_list.clear();
                            Milliseconds_list.clear();
                            Bytes_list.clear();
                            UnitPrice_list.clear();
                            
                        while (rs.next()) {
                            TrackId_list.add((rs.getInt("TrackId")));
                            TracksName_list.add((rs.getString("Name")));
                            AlbumId_list.add((rs.getInt("AlbumId")));
                            MediaTypeId_list.add((rs.getInt("MediaTypeId")));
                            GenreId_list.add((rs.getInt("GenreId")));
                            Composer_list.add((rs.getString("Composer")));
                            Milliseconds_list.add((rs.getInt("Milliseconds")));
                            Bytes_list.add((rs.getInt("Bytes")));
                            UnitPrice_list.add((rs.getDouble("UnitPrice")));
                            
                        }
                        
                        outToClient.writeObject(TrackId_list);
                        outToClient.writeObject(TracksName_list);
                        outToClient.writeObject(AlbumId_list);
                        outToClient.writeObject(MediaTypeId_list);
                        outToClient.writeObject(GenreId_list);
                        outToClient.writeObject(Composer_list);
                        outToClient.writeObject(Milliseconds_list);
                        outToClient.writeObject(Bytes_list);
                        outToClient.writeObject(UnitPrice_list);
                        
                    }
                    catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
}

public void InsertToTracks() throws IOException, ClassNotFoundException{
                    TrackId_Text = (Integer) inFromClient.readObject();
                    TracksName_Text = (String) inFromClient.readObject();
                    AlbumId_Text = (Integer) inFromClient.readObject();
                    MediaTypeId_Text = (Integer) inFromClient.readObject();
                    GenreId_Text = (Integer) inFromClient.readObject();
                    Composer_Text = (String) inFromClient.readObject();
                    Milliseconds_Text = (Integer) inFromClient.readObject();
                    Bytes_Text = (Integer) inFromClient.readObject();
                    UnitPrice_Text = (Double) inFromClient.readObject();
                    
                    try (Connection conn = this.connect();
                            PreparedStatement stat = (PreparedStatement) conn.prepareStatement("INSERT INTO Tracks(TrackId,Name,AlbumId,MediaTypeId,GenreId,Composer,Milliseconds,Bytes,UnitPrice)Values(?,?,?,?,?,?,?,?,?)");){
                       
                        
                        stat.setInt(1, TrackId_Text);
                        stat.setString(2, TracksName_Text);
                        stat.setInt(3, AlbumId_Text);
                        stat.setInt(4, MediaTypeId_Text);
                        stat.setInt(5, GenreId_Text);
                        stat.setString(6, Composer_Text);
                        stat.setInt(7, Milliseconds_Text);
                        stat.setInt(8, Bytes_Text);
                        stat.setDouble(9, UnitPrice_Text);
                        stat.executeUpdate();
                        stat.close();

                        TrackId_list.add(TrackId_Text);
                        TracksName_list.add(TracksName_Text);
                        AlbumId_list.add(AlbumId_Text);
                        MediaTypeId_list.add(MediaTypeId_Text);
                        GenreId_list.add(GenreId_Text);
                        Composer_list.add(Composer_Text);
                        Milliseconds_list.add(Milliseconds_Text);
                        Bytes_list.add(Bytes_Text);
                        UnitPrice_list.add(UnitPrice_Text);
                        
                        outToClient.writeObject(TrackId_list);
                        outToClient.writeObject(TracksName_list);
                        outToClient.writeObject(AlbumId_list);
                        outToClient.writeObject(MediaTypeId_list);
                        outToClient.writeObject(GenreId_list);
                        outToClient.writeObject(Composer_list);
                        outToClient.writeObject(Milliseconds_list);
                        outToClient.writeObject(Bytes_list);
                        outToClient.writeObject(UnitPrice_list);
                        
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    } 
}

public void  DeleteFromTracks() throws IOException, ClassNotFoundException{
                    TrackId_Text = (Integer) inFromClient.readObject();
                    
                    try (Connection conn = this.connect();
                            PreparedStatement stat = (PreparedStatement) conn.prepareStatement("delete from Tracks where TrackId=?");){
                        
                        
                        stat.setInt(1, TrackId_Text);
                        stat.executeUpdate();
                        stat.close();
                        
                        int Del = TrackId_list.indexOf(TrackId_Text);
                        
                        TrackId_list.remove(Del);
                        TracksName_list.remove(Del);
                        AlbumId_list.remove(Del);
                        MediaTypeId_list.remove(Del);
                        GenreId_list.remove(Del);
                        Composer_list.remove(Del);
                        Milliseconds_list.remove(Del);
                        Bytes_list.remove(Del);
                        UnitPrice_list.remove(Del);
                        
                        outToClient.writeObject(TrackId_list);
                        outToClient.writeObject(TracksName_list);
                        outToClient.writeObject(AlbumId_list);
                        outToClient.writeObject(MediaTypeId_list);
                        outToClient.writeObject(GenreId_list);
                        outToClient.writeObject(Composer_list);
                        outToClient.writeObject(Milliseconds_list);
                        outToClient.writeObject(Bytes_list);
                        outToClient.writeObject(UnitPrice_list);
                        
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
}

 public void UpdateTracks() throws IOException, ClassNotFoundException{
     
                    TrackId_Text = (Integer) inFromClient.readObject();
                    TracksName_Text = (String) inFromClient.readObject();
                    AlbumId_Text = (Integer) inFromClient.readObject();
                    MediaTypeId_Text = (Integer) inFromClient.readObject();
                    GenreId_Text = (Integer) inFromClient.readObject();
                    Composer_Text = (String) inFromClient.readObject();
                    Milliseconds_Text = (Integer) inFromClient.readObject();
                    Bytes_Text = (Integer) inFromClient.readObject();
                    UnitPrice_Text = (Double) inFromClient.readObject();
                    UpdateId =(Integer) inFromClient.readObject();
                   
                    try (Connection conn = this.connect();
                            PreparedStatement stat = (PreparedStatement) conn.prepareStatement("update Tracks " + "set TrackId = ?, " + "Name = ?," + "AlbumId = ?," + "MediaTypeId = ?," + "GenreId = ?," + "Composer = ?," + "Milliseconds = ?," + "Bytes = ?," + "UnitPrice = ?" + "where TrackId = ?");){
                        
                        
                        
                        stat.setInt(1, TrackId_Text);
                        stat.setString(2, TracksName_Text);
                        stat.setInt(3, AlbumId_Text);
                        stat.setInt(4, MediaTypeId_Text);
                        stat.setInt(5, GenreId_Text);
                        stat.setString(6, Composer_Text);
                        stat.setInt(7, Milliseconds_Text);
                        stat.setInt(8, Bytes_Text);
                        stat.setDouble(9, UnitPrice_Text);
                        stat.setInt(10, UpdateId);
                        stat.executeUpdate();
                        stat.close();

                       int Up = TrackId_list.indexOf(UpdateId);
                        TrackId_list.set(Up, TrackId_Text);
                        TracksName_list.set(Up, TracksName_Text);
                        AlbumId_list.set(Up, AlbumId_Text);
                        MediaTypeId_list.set(Up, MediaTypeId_Text);
                        GenreId_list.set(Up, GenreId_Text);
                        Composer_list.set(Up, Composer_Text);
                        Milliseconds_list.set(Up, Milliseconds_Text);
                        Bytes_list.set(Up, Bytes_Text);
                        UnitPrice_list.set(Up, UnitPrice_Text);
                        
                        outToClient.writeObject(TrackId_list);
                        outToClient.writeObject(TracksName_list);
                        outToClient.writeObject(AlbumId_list);
                        outToClient.writeObject(MediaTypeId_list);
                        outToClient.writeObject(GenreId_list);
                        outToClient.writeObject(Composer_list);
                        outToClient.writeObject(Milliseconds_list);
                        outToClient.writeObject(Bytes_list);
                        outToClient.writeObject(UnitPrice_list);
                        
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
 }
                    
// end
}