package model;

public class RemovedState implements VinylState {

  @Override public void reserveVinyl(Vinyl vinyl) {
    //Leave it blank
  }

  @Override public void borrowVinyl(Vinyl vinyl) {
//Leave it blank
  }

  @Override public void returnVinyl(Vinyl vinyl) {
    //Leave it blank
  }
  public String toString(){
    return "Removed";
  }
}
