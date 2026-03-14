package model;

import java.util.ArrayList;

public interface VinylModel {
  void addVinyl(String title,String artist,int releaseYear);
  Vinyl getVinyl(int index);
  ArrayList<Vinyl> getVinylList();
  int getVinylCount();
}
