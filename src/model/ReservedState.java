package model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ReservedState implements VinylState{

  @Override public String toString() {
    return "Reserved";
  }

  @Override public void reserveVinyl(Vinyl vinyl) {
    //Unused, reserved vinyls cannot be reserved
  }

  @Override public void borrowVinyl(Vinyl vinyl) {
    vinyl.setCurrentVinylState(new BorrowedState());
  }

  @Override public void returnVinyl(Vinyl vinyl) {
    vinyl.setCurrentVinylState(new AvailableState());
  }

}