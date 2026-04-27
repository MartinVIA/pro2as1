package client.viewModel;

import client.model.Vinyl;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class VinylViewModel {

  private StringProperty title = new SimpleStringProperty();
  private StringProperty artist = new SimpleStringProperty();
  private IntegerProperty releaseYear = new SimpleIntegerProperty();
  private StringProperty currentVinylState = new SimpleStringProperty();
  private StringProperty reserveName = new SimpleStringProperty();

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

  public void setCurrentVinylState( String s ){
    currentVinylState.set(s);
  }
  public void setReserveName( String s ){
    reserveName.set(s);
  }

}
