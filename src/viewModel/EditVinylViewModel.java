package viewModel;

import javafx.beans.property.*;
import model.Vinyl;
import model.VinylModel;
import model.VinylState;

public class EditVinylViewModel {
  // Platform.runLater() - potentially needed?
  private Vinyl vinyl;
  private VinylModel model;
  private StringProperty title;
  private IntegerProperty year;
  private StringProperty artist;
  private ObjectProperty<VinylState> vinylState;

  public EditVinylViewModel(VinylModel model){
    this.model = model;
  }
  public void setVinyl(Vinyl vinyl){
    this.vinyl = vinyl;
    title = new SimpleStringProperty(vinyl.getTitle());
    year = new SimpleIntegerProperty(vinyl.getReleaseYear());
    artist = new SimpleStringProperty(vinyl.getArtist());
    vinylState = new SimpleObjectProperty<VinylState>(vinyl.getCurrentVinylState());
  }

  public StringProperty getTitleProperty(){
    return title;
  }
  public StringProperty getArtistProperty(){
    return artist;
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




}
