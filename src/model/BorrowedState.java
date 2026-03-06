package model;
public class BorrowedState implements VinylState{

  @Override public String getName() {
    return "Borrowed";
  }

  @Override public void reserve(Vinyl vinyl) {
    vinyl.setCurrentVinylState(new ReservedState());
  }
  @Override public void borrow(Vinyl vinyl) {
    //Unused, borrowed vinyls cannot be borrowed
  }

  @Override public void returned(Vinyl vinyl) {
    vinyl.setCurrentVinylState(new AvailableState());
  }

}

