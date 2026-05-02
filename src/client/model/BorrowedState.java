package client.model;

public class BorrowedState implements VinylState{

  @Override public String toString() {
    return "BorrowedState";
  }

  @Override public void reserveVinyl(Vinyl vinyl) {
    vinyl.setCurrentVinylState(new BorrowedReservedState());
  }
  @Override public void borrowVinyl(Vinyl vinyl) {
    //Unused, borrowed vinyls cannot be borrowed
  }

  @Override public void returnVinyl(Vinyl vinyl) {
    vinyl.setCurrentVinylState(new AvailableState());
  }
}

