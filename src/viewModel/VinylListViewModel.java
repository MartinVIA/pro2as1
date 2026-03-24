package viewModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Vinyl;
import model.VinylLibraryManager;
import model.VinylModel;

public class VinylListViewModel {
  private VinylModel model;
  private ObservableList<Vinyl> vinylList;
  private VinylLibraryManager libraryManager;

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
  private Thread bobThread=new Thread(new Simulation(this,libraryManager,"Bob",1000,1));
  public void runBobThread() {
    bobThread.start();
  }
  public void addLibrary(VinylLibraryManager libraryManager) {
    this.libraryManager=libraryManager;
  }

}
