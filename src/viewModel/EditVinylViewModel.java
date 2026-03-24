package viewModel;

import javafx.beans.property.*;
import model.*;

public class EditVinylViewModel{
  private int index;
  private  VinylModel model;
  private  StringProperty title = new SimpleStringProperty();
  private  StringProperty artist = new SimpleStringProperty();
  private  StringProperty reserveName = new SimpleStringProperty();
  private  IntegerProperty year = new SimpleIntegerProperty();
  private  ObjectProperty<VinylState> vinylState = new SimpleObjectProperty<>();
  private VinylState oldVinylState;

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
    oldVinylState = model.getVinyl(index).getCurrentVinylState();
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
    VinylState borrowed = new BorrowedState();
    if(model.getVinyl(index).getCurrentVinylState().getClass() == borrowed.getClass()){
      VinylState temp = new BorrowedReservedState();
      vinylState.set(temp);
      model.getVinyl(index).setCurrentVinylState(temp);
      return;
    }
    VinylState reserved = new ReservedState();
    vinylState.set(reserved);
    model.getVinyl(index).setCurrentVinylState(reserved);
  }

  public void setBorrowedVinylState() {
    VinylState borrowed = new BorrowedState();
    vinylState.set(borrowed);
    model.getVinyl(index).setCurrentVinylState(borrowed);
  }
  public void setToOldVinylState(){
    model.getVinyl(index).setCurrentVinylState(oldVinylState);
  }

  public void setRemovedVinylState() {
    VinylState removed = new RemovedState();
    vinylState.set(removed);
    model.getVinyl(index).setCurrentVinylState(removed);
  }
  public VinylModel getModel(){
    return model;
  }
}
