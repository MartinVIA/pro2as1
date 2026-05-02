package client.viewModel;

import client.model.Vinyl;
import client.model.VinylState;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeSupport;

public class VinylViewModel {

  private StringProperty title = new SimpleStringProperty();
  private StringProperty artist = new SimpleStringProperty();
  private IntegerProperty releaseYear = new SimpleIntegerProperty();
  private StringProperty currentVinylState = new SimpleStringProperty();
  private StringProperty reserveName = new SimpleStringProperty();
  private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
  private static final String currentVinylStateProperty = "VinylState";

  public VinylViewModel(Vinyl vinyl) {
    this.title.set(vinyl.getTitle());
    this.artist.set(vinyl.getArtist());
    this.releaseYear.set(vinyl.getReleaseYear());
    this.currentVinylState.set(vinyl.getCurrentVinylState().getClass().getSimpleName());
    this.reserveName.set(vinyl.getReserveName());
  }

  public StringProperty titleProperty() { return title; }
  public StringProperty artistProperty() { return artist; }
  public IntegerProperty releaseYearProperty() { return releaseYear; }
  public StringProperty currentVinylStateProperty() { return currentVinylState; }
  public StringProperty reserveNameProperty() { return reserveName; }

  public String getCurrentVinylState(){
    return currentVinylState.get();
  }

  public void setCurrentVinylState(VinylState newVinylState){
    VinylState oldState = (VinylState) currentVinylState;
    currentVinylState = (StringProperty) newVinylState;
    //When Vinyl State changes, get the name of the old State, and the name of the new state
    propertyChangeSupport.firePropertyChange(currentVinylStateProperty, oldState.toString(), currentVinylState.toString());
  }
  public void setReserveName( String s ){
    reserveName.set(s);
  }

}
