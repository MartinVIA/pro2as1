package model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.VinylObserver;
import java.util.ArrayList;

public class VinylLibraryManager implements VinylModel {
  private ObservableList<Vinyl> vinylList;
  public VinylLibraryManager(){
    vinylList = FXCollections.observableArrayList();
    addVinyl("Hamburger","Biggie Cheese", 2026);
    addVinyl("Buvany Special"," GMAN productions", 6767);
  }
  public void addVinyl(String title,String artist,int releaseYear) {
    Vinyl vinyl = new Vinyl(title,artist,releaseYear);
    vinyl.addPropertyChangeListener(new VinylObserver("vinylObserver"));
    vinylList.add(vinyl);
  }
  public Vinyl getVinyl(int index) {
    return vinylList.get(index);
  }
  public int getVinylCount(){
    return vinylList.size();
  }
 public ObservableList<Vinyl> getVinylList(){
    return vinylList;
  }

}