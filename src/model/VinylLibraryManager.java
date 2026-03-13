package model;
import utils.VinylObserver;
import java.util.ArrayList;

public class VinylLibraryManager implements VinylModel
{
  private ArrayList<Vinyl> vinylList= new ArrayList<>();

  public VinylLibraryManager(){
  }
  public void addVinyl(String title,String artist,int releaseYear) {
    Vinyl vinyl = new Vinyl(title,artist,releaseYear);
    vinyl.addPropertyChangeListener(new VinylObserver("vinylObserver"));
    vinylList.add(vinyl);
  }
  public Vinyl getVinyl(int index) {
    return vinylList.get(index);
  }

}