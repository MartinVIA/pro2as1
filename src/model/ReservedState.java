package model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ReservedState implements VinylState{

  @Override public String getName() {
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

  @Override public void addListener(PropertyChangeListener listener)
  {

  }

  @Override public void removeListener(PropertyChangeListener listener)
  {

  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {

  }
}