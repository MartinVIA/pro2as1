package utils;

import java.beans.PropertyChangeListener;

public class VinylObserver implements PropertyChangeListener {
  private final String name;
  public VinylObserver(String name){
    this.name = name;
  }

  @Override public void propertyChange(java.beans.PropertyChangeEvent propertyChangeEvent){
    System.out.println("State changed from "+propertyChangeEvent.getOldValue()+" to "+propertyChangeEvent.getNewValue());
  }

}