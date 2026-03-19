package model;

import javafx.collections.ObservableList;

public interface VinylModel {
  void addVinyl(String title,String artist,int releaseYear);
  Vinyl getVinyl(int index);
  ObservableList<Vinyl> getVinylList();
  int getVinylCount();
}
