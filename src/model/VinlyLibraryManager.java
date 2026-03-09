package model;

import utils.VinylObserver;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class VinlyLibraryManager implements VinylModel, VinylObserver
{
  private Vinyl viny;
  private PropertyChangeSupport support;

  public VinlyLibraryManager(){
    this.viny = new Vinyl();
    this.support = new PropertyChangeSupport(this);
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {

  }

  @Override public void addVinyl(String title)
  {

  }

  @Override public Vinyl getVinyl(String title)
  {
    return null;
  }

  @Override public void reserveVinyl()
  {

  }

  @Override public void borrowVinyl()
  {

  }
  @Override public void returnVinyl()
  {

  }



  @Override public void addListener(PropertyChangeListener listener)
  {

  }

  @Override public void removeListener(PropertyChangeListener listener)
  {

  }
}