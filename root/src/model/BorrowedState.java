package model;
public class BorrowedState implements VinylState{

  @Override public void reserve(Vinyl vinyl) {
    vinyl.setVinylState(new ReservedState());
  }
  @Override public void borrow(Vinyl vinyl) {
    //Unused, borrowed vinyls cannot be borrowed
  }

  @Override public void returned(Vinyl vinyl) {
    vinyl.setVinylState(new AvailableState());
  }
}

