package client.model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ModelManager implements VinylModel {
  private ObservableList<Vinyl> vinylList;

  public ModelManager(){
    vinylList = FXCollections.observableArrayList();
  }
  public synchronized Vinyl getVinyl(int index) {
    return vinylList.get(index);
  }
  public int getVinylCount(){
    return vinylList.size();
  }
 public ObservableList<Vinyl> getVinylList(){
    return vinylList;
  }



}