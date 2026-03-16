package model;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Vinyl {
    private String title;
    private String artist;
    private int releaseYear;
    private String reserveName;
    private VinylState currentVinylState;
    private static final String currentVinylStateProperty = "VinylState";
    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public Vinyl(String title, String artist, int releaseYear){
      this.title = title;
      this.artist = artist;
      this.releaseYear = releaseYear;
      reserveName = "";
      currentVinylState = new AvailableState();
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

    public void setCurrentVinylState(VinylState newVinylState){
      VinylState oldState = currentVinylState;
      currentVinylState = newVinylState;
      //When Vinyl State changes, get the name of the old State, and the name of the new state
      propertyChangeSupport.firePropertyChange(currentVinylStateProperty, oldState.toString(), currentVinylState.toString());

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
    public void addPropertyChangeListener(PropertyChangeListener listener){
    propertyChangeSupport.addPropertyChangeListener(listener);
    }
    public void removePropertyChangeListener(PropertyChangeListener listener){
    propertyChangeSupport.removePropertyChangeListener(listener);
    }

}
