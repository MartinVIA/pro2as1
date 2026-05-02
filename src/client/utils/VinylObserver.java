package client.utils;

import java.beans.PropertyChangeListener;
import java.io.PrintWriter;

public class VinylObserver implements PropertyChangeListener {
  private final String name;
  private final PrintWriter writer;
  public VinylObserver(String name){
    this.name = name;
    writer = null;
  }
  public VinylObserver(String name, PrintWriter writer){
    this.name = name;
    this.writer = writer;
  }

  @Override public void propertyChange(java.beans.PropertyChangeEvent propertyChangeEvent){
    if(name.equals("Client")){
      writer.println(propertyChangeEvent.toString());
    }
    else{
    System.out.println("State changed from "+propertyChangeEvent.getOldValue()+" to "+propertyChangeEvent.getNewValue());
    }
  }

}