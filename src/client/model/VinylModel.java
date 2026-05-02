package client.model;

import javafx.collections.ObservableList;

public interface VinylModel {
  Vinyl getVinyl(int index);
  ObservableList<Vinyl> getVinylList();
  int getVinylCount();
}
