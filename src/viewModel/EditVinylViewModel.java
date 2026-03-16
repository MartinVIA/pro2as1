package viewModel;

import javafx.beans.property.*;
import model.*;

import java.beans.PropertyChangeListener;

public class EditVinylViewModel{
  private int index;
  private final VinylModel model;
  private StringProperty title = new SimpleStringProperty();
  private StringProperty artist = new SimpleStringProperty();
  private StringProperty reserveName = new SimpleStringProperty();
  private IntegerProperty year = new SimpleIntegerProperty();
  private ObjectProperty<VinylState> vinylState = new SimpleObjectProperty<>();

  public EditVinylViewModel(VinylModel model){
    this.model = model;
  }
  public void setVinylIndex(int index){
    this.index = index;
    title.set(model.getVinyl(index).getTitle());
    artist.set(model.getVinyl(index).getArtist());
    reserveName.set(model.getVinyl(index).getReserveName());
    year.set(model.getVinyl(index).getReleaseYear());
    vinylState.set(model.getVinyl(index).getCurrentVinylState());
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
  public void setReserveName(String name){
    reserveName.set(name);
    model.getVinyl(index).setReserveName(name);
  }
  private void setReserveName( ){
    reserveName.set("");
    model.getVinyl(index).setReserveName("");
  }
  public void setAvailableVinylState() {
    VinylState available = new AvailableState();
    vinylState.set(available);
    model.getVinyl(index).setCurrentVinylState(available);
    //Making sure the name is an empty string when making the vinly available
    setReserveName();
  }

  public void setReservedVinylState() {
    VinylState reserved = new ReservedState();
    vinylState.set(reserved);
    model.getVinyl(index).setCurrentVinylState(reserved);
  }

  public void setBorrowedVinylState() {
    VinylState borrowed = new BorrowedState();
    vinylState.set(borrowed);
    model.getVinyl(index).setCurrentVinylState(borrowed);
  }
}
