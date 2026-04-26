package client.viewModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import client.model.Vinyl;
import client.model.ModelManager;
import client.model.VinylModel;

public class VinylListViewModel {
  private VinylModel model;
  private ObservableList<Vinyl> vinylList;
  private ModelManager libraryManager;

  public VinylListViewModel( VinylModel model ) {
    this.model = model;
    vinylList = FXCollections.observableArrayList(model.getVinylList());
  }
  public ObservableList<Vinyl> getVinylList() {
    return vinylList;
  }
  public void clear(){
  }
  public void reload(){
    vinylList.clear();
    vinylList.addAll(model.getVinylList());
  }

}
