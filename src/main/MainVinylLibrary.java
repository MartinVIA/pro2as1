package main;

import model.AvailableState;
import model.ReservedState;
import model.BorrowedState;
import model.VinylLibraryManager;
import utils.VinylObserver;

public class MainVinylLibrary {
  public static void main(String[] args) {
    VinylLibraryManager manager = new VinylLibraryManager();
    manager.addVinyl("Hamburger","Biggie Cheese", 2026);
    manager.getVinyl(0).setCurrentVinylState(new BorrowedState());
    //Add observer to the first vinyl in the manager list of vinyls
    manager.getVinyl(0).setCurrentVinylState(new ReservedState());
    //"State has been changed from oldState.getName to newState.getName"
    manager.getVinyl(0).setCurrentVinylState(new AvailableState());
  }
}
