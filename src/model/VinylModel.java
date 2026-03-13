package model;

public interface VinylModel {
  void addVinyl(String title,String artist,int releaseYear);
  Vinyl getVinyl(int index);
  int getVinylCount();
}
