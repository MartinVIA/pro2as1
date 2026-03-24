package viewModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Vinyl;
import model.VinylModel;

public class VinylListViewModel {
  private VinylModel model;
  private ObservableList<Vinyl> vinylList;

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
  private Thread bobThread=new Thread(new Simulation(this,model,"Bob",1000,1));
  public void runBobThread() {
    bobThread.start();
  }

}
