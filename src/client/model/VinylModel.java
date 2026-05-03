package client.model;

import javafx.collections.ObservableList;

import java.util.ArrayList;

public interface VinylModel {
  Vinyl getVinyl(int index);
  ObservableList<Vinyl> getVinylList();
  int getVinylCount();
  void setVinylList(ArrayList<Vinyl> updatedList);
}
