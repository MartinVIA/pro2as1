package model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utils.VinylObserver;

public class VinylLibraryManager implements VinylModel {
  private ObservableList<Vinyl> vinylList;
  public VinylLibraryManager(){
    vinylList = FXCollections.observableArrayList();
    addVinyl("Hamburger","Biggie Cheese", 2026);
    addVinyl("Buvany Special"," GMAN productions", 6767);
    addVinyl("Nandinho Brazil", "Nande",2026);
    addVinyl("Scrum master", "Guillermo", 2005);
    addVinyl("18", "Moby",2010);
    addVinyl("Pizza","Bob", 2007);
    addVinyl("Buvan Jr"," GMAN productions", 1980);
    addVinyl("Play", "Moby",2007);
    addVinyl("Product Owner", "Buvan", 2000);
    addVinyl("Achilleas", "Kampas",2010);
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

  Thread bobThread=new Thread(new Simulation("Bob",1000));
  // bobThread.start();

    public void runBobThread() {
      bobThread.start();  
    }

}