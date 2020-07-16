package Client;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Anas
 */
public class Data_Store {
    
     static ArrayList<String> PlaylistName_list = new ArrayList<>();
     static ArrayList<Integer> PlaylistId_list = new ArrayList<>();
     static ArrayList<Integer> TrackId_list = new ArrayList<>();
     static ArrayList<String> TracksName_list = new ArrayList<>();
     static ArrayList<Integer> AlbumId_list = new ArrayList<>();
     static ArrayList<Integer> MediaTypeId_list = new ArrayList<>();
     static ArrayList<Integer> GenreId_list = new ArrayList<>();
     static ArrayList<String> Composer_list = new ArrayList<>();
     static ArrayList<Integer> Milliseconds_list = new ArrayList<>();
     static ArrayList<Integer> Bytes_list = new ArrayList<>();
     static ArrayList<Double> UnitPrice_list = new ArrayList<>();
     static HashMap<Integer, Integer> PlaylistTrack_hash = new HashMap<Integer, Integer>();   
          
     static int PlaylistId_Place, TrackId_Place, AlbumId_Place, MediaTypeId_Place, GenreId_Place,Milliseconds_Place, Bytes_Place;
     static String PlaylistName_Place, TracksName_Place, Composer_Place;
     static Double UnitPrice_Place;
     
     // Save
     
     public static void ClearAll(){
     PlaylistName_list.clear();
     PlaylistId_list.clear();
     TrackId_list.clear();
     TracksName_list.clear();
     AlbumId_list.clear();
     MediaTypeId_list.clear();
     GenreId_list.clear();
     Composer_list.clear();
     Milliseconds_list.clear();
     Bytes_list.clear();
     UnitPrice_list.clear();
     }
public static void SavePlaylistId(ArrayList list1){
         PlaylistId_list = list1;
     }
public static void Save_PlaylistName(ArrayList list1){
         PlaylistName_list = list1;
     }
public static void SaveTrackId(ArrayList list1){
         TrackId_list = list1;
     }
public static void SaveTracksName(ArrayList list1){
         TracksName_list = list1;
     }
public static void SaveAlbumId(ArrayList list1){
         AlbumId_list = list1;
     }
public static void SaveMediaTypeId(ArrayList list1){
         MediaTypeId_list = list1;
     }
public static void SaveGenreId(ArrayList list1){
         GenreId_list = list1;
     }
public static void SaveComposer(ArrayList list1){
         Composer_list = list1;
     }
public static void SaveMilliseconds(ArrayList list1){
         Milliseconds_list = list1;
     }
public static void SaveBytes(ArrayList list1){
         Bytes_list = list1;
     }
public static void SaveUnitPrice(ArrayList list1){
         UnitPrice_list = list1;
     }
public static void SavePlaylistTrack(HashMap hash){
         PlaylistTrack_hash = hash;
     }

// Copy


 public static void CopyPlaylistId(ArrayList list1){
         list1 = PlaylistId_list; 
      }
 public static void Copy_PlaylistName(ArrayList list1){
         list1 = PlaylistName_list; 
      }
 public static void CopyTrackId(ArrayList list1){
         list1 = TrackId_list; 
      }
 public static void CopyTracksName(ArrayList list1){
         list1 = TracksName_list; 
      }
 public static void CopyAlbumId(ArrayList list1){
         list1 = AlbumId_list; 
      }
 public static void CopyMediaTypeId(ArrayList list1){
         list1 = MediaTypeId_list; 
      }
 public static void CopyGenreId(ArrayList list1){
         list1 = GenreId_list; 
      }
 public static void CopyComposer(ArrayList list1){
         list1 = Composer_list; 
      }
 public static void CopyMilliseconds(ArrayList list1){
         list1 = Milliseconds_list; 
      }
 public static void CopyBytes(ArrayList list1){
         list1 = Bytes_list; 
      }
 public static void CopyUnitPrice(ArrayList list1){
         list1 = UnitPrice_list; 
      }
 public static void CopyPlaylistTrack(HashMap hash){
         hash = PlaylistTrack_hash;
     }

 
 
 // Save Place
 
 public static void SavePlace_Playlists(int PlaylistId, String PlaylistName){
         PlaylistId_Place = PlaylistId;
         PlaylistName_Place = PlaylistName;
      }
  public static void SavePlace_Playlist_Track(int PlaylistId, int TrackId){
         PlaylistId_Place = PlaylistId;
         TrackId_Place = TrackId;
      }
   public static void SavePlace_Tracks(int TrackId, String TracksName, int AlbumId, int MediaTypeId, int GenreId, String Composer, int Milliseconds, int Bytes, Double UnitPrice){
         TrackId_Place = TrackId;
         TracksName_Place = TracksName;
         AlbumId_Place = AlbumId;
         MediaTypeId_Place = MediaTypeId;
         GenreId_Place = GenreId;
         Composer_Place = Composer;
         Milliseconds_Place = Milliseconds;
         Bytes_Place = Bytes;
         UnitPrice_Place = UnitPrice;
      }
   
   
   // Copy Place
   
  public static void CopyPlace_Playlists(int PlaylistId, String PlaylistName){
         PlaylistId =PlaylistId_Place;
          PlaylistName = PlaylistName_Place;
      }
  public static void CopyPlace_Playlist_Track(int PlaylistId, int TrackId){
         PlaylistId =PlaylistId_Place;
          TrackId = TrackId_Place;
      }
  public static void CopyPlace_Tracks(int TrackId, String TracksName, int AlbumId, int MediaTypeId, int GenreId, String Composer, int Milliseconds, int Bytes, Double UnitPrice){
          TrackId = TrackId_Place;
         TracksName = TracksName_Place;
         AlbumId = AlbumId_Place;
         MediaTypeId = MediaTypeId_Place;
         GenreId = GenreId_Place;
         Composer = Composer_Place;
         Milliseconds = Milliseconds_Place;
         Bytes = Bytes_Place;
         UnitPrice = UnitPrice_Place;
      }
}


