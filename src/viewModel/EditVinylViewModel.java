package viewModel;

import javafx.beans.property.*;
import model.VinylModel;
import model.VinylState;

public class EditVinylViewModel
{
  // Platform.runLater() - potentially needed?
  private VinylModel model;
  private StringProperty title;
  private StringProperty year;
  private StringProperty artist;
  private ObjectProperty<VinylState> vinylState;

  public EditVinylViewModel(VinylModel model) {
    this.model = model;
    title = new SimpleStringProperty();
    year = new SimpleStringProperty();
    artist = new SimpleStringProperty();
    vinylState = new SimpleObjectProperty<VinylState>();
  }
  public StringProperty getTitleProperty(){
    return title;
  }
  public StringProperty getArtistProperty(){
    return artist;
  }
  public StringProperty getYearProperty(){
    return year;
  }
  public ObjectProperty<VinylState> getVinylStateProperty(){
    return vinylState;
  }

  public Vinyl getSelectedVinyl(){
    return vinyl;
  }




}
