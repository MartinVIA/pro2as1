package utils;

import java.beans.PropertyChangeListener;

public class VinylObserver implements PropertyChangeListener {
  @Override
  public void propertyChange(java.beans.PropertyChangeEvent propertyChangeEvent) {
    System.out.println("State changed from"+propertyChangeEvent.getOldValue()+" to " +propertyChangeEvent.getNewValue());
  }
}
