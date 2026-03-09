package utils;

import java.beans.PropertyChangeListener;

public interface VinylObserver extends PropertyChangeListener {

  void addListener(PropertyChangeListener listener);
  void removeListener(PropertyChangeListener listener);

 // @Override
 //  default void propertyChange(java.beans.PropertyChangeEvent propertyChangeEvent) {
  //  System.out.println("State changed from"+propertyChangeEvent.getOldValue()+" to " +propertyChangeEvent.getNewValue());
  }
