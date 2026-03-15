package viewModel;

import javafx.beans.property.*;
import model.*;

public class EditVinylViewModel {
  // Platform.runLater() - potentially needed?
  private Vinyl vinyl;
  private final VinylModel model;
  private StringProperty title = new SimpleStringProperty();
  private StringProperty artist = new SimpleStringProperty();
  private StringProperty reserveName = new SimpleStringProperty();
  private IntegerProperty year = new SimpleIntegerProperty();
  private ObjectProperty<VinylState> vinylState = new SimpleObjectProperty<>();

  public EditVinylViewModel(VinylModel model){
    this.model = model;
  }
  public void setVinyl(Vinyl vinyl){
    this.vinyl = vinyl;
    title.set(vinyl.getTitle());
    artist.set(vinyl.getArtist());
    reserveName.set(vinyl.getReserveName());
    year.set(vinyl.getReleaseYear());
    vinylState.set(vinyl.getCurrentVinylState());
  }

  public StringProperty getTitleProperty(){
    return title;
  }
  public StringProperty getArtistProperty(){
    return artist;
  }
  public StringProperty getReservedNameProperty(){
    return reserveName;
  }
  public IntegerProperty getYearProperty(){
    return year;
  }
  public ObjectProperty<VinylState> getVinylStateProperty(){
    return vinylState;
  }

  public Vinyl getSelectedVinyl(){
    return vinyl;
  }
  public void setAvailableVinylState( ) {
    VinylState available = new AvailableState();
    vinylState.set(available);
    vinyl.setCurrentVinylState(available);
  }



}
