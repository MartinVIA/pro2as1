package client.model;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

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
  public synchronized void setVinylList(ArrayList<Vinyl> list) {
    Platform.runLater(() -> vinylList.setAll(list));
  }
}