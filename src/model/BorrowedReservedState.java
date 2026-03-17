package model;

public class BorrowedReservedState implements VinylState {

  public String toString(){
    return "Borrowed Reserved";
  }
  @Override public void reserveVinyl(Vinyl vinyl) {
    //Leave it blank
  }

  @Override public void borrowVinyl(Vinyl vinyl) {
  //Leave it blank
  }

  @Override public void returnVinyl(Vinyl vinyl) {
    vinyl.setCurrentVinylState(new ReservedState());
  }
}
