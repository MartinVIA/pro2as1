package client.utils;

import java.beans.PropertyChangeListener;
import java.io.PrintWriter;

public class VinylObserver implements PropertyChangeListener {

  public VinylObserver( ){
  }

  @Override public void propertyChange(java.beans.PropertyChangeEvent propertyChangeEvent){
    System.out.println("State changed from "+propertyChangeEvent.getOldValue()+" to "+propertyChangeEvent.getNewValue());
  }

}