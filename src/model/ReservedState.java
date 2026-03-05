package model;

public class ReservedState implements VinylState{

  @Override public String getName() {
    return "";
  }

  @Override public void reserve(Vinyl vinyl) {
    //Unused, reserved vinyls cannot be reserved
  }

  @Override public void borrow(Vinyl vinyl) {
    vinyl.setCurrentVinylState(new BorrowedState());
  }

  @Override public void returned(Vinyl vinyl) {
    vinyl.setCurrentVinylState(new AvailableState());
  }

}