package viewModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Vinyl;
import model.VinylModel;

public class VinylListViewModel {
  // Platform.runLater() - potentially needed?
  private VinylModel model;
  private ObservableList<Vinyl> vinylList;
  private int index;

  public VinylListViewModel( VinylModel model ) {
    this.model = model;
    vinylList = FXCollections.observableArrayList();
    loadVinyls();
  }
  private void loadVinyls() {
    vinylList.addAll(model.getVinylList());
  }
  public ObservableList<Vinyl> getVinylList() {
    return vinylList;
  }
  public void setIndex(int i){
    index = i;
  }
  public void clear(){
  }
  public Vinyl getSelectedVinyl(){
    return vinylList.get(index);
  }
}
