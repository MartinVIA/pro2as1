package client.model;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Vinyl {
    private String title;
    private String artist;
    private int releaseYear;
    private String reserveName;
    private transient VinylState currentVinylState;
    private String vinylStateName;
    private static final String currentVinylStateProperty = "VinylState";

    public Vinyl(String title, String artist, int releaseYear){
      this.title = title;
      this.artist = artist;
      this.releaseYear = releaseYear;
      reserveName = "";
      currentVinylState = new AvailableState();
      vinylStateName = currentVinylState.toString();
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return title;
    }
    public void setArtist(String artist){
        this.artist = artist;
    }
    public  String getArtist(){
        return artist;
    }
    public void setReleaseYear(int releaseYear){
      this.releaseYear = releaseYear;
    }
    public int getReleaseYear(){
      return releaseYear;
    }

    public void setCurrentVinylState(VinylState newVinylState) {
     VinylState oldState = currentVinylState;
     currentVinylState = newVinylState;
     vinylStateName = newVinylState.getClass().getSimpleName();
    }
  public void restoreState() {
    currentVinylState = switch (vinylStateName) {
      case "BorrowedState"    -> new BorrowedState();
      case "ReservedState"    -> new ReservedState();
      case "RemovedState"     -> new RemovedState();
      default                 -> new AvailableState();
    };
  }
    public VinylState getCurrentVinylState(){
      return currentVinylState;
    }
    public void setReserveName(String reserveName){
      this.reserveName = reserveName;
    }
    public String getReserveName(){
      return reserveName;
    }
}
