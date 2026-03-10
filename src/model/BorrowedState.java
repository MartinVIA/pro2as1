package model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class BorrowedState implements VinylState{

  @Override public String getName() {
    return "Borrowed";
  }

  @Override public void reserveVinyl(Vinyl vinyl) {
    vinyl.setCurrentVinylState(new ReservedState());
  }
  @Override public void borrowVinyl(Vinyl vinyl) {
    //Unused, borrowed vinyls cannot be borrowed
  }

  @Override public void returnVinyl(Vinyl vinyl) {
    vinyl.setCurrentVinylState(new AvailableState());
  }
}

