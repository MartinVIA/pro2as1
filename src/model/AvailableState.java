package model;

public class AvailableState implements VinylState {

  @Override public String getName() {
    return "Available";
  }

  @Override public void reserve(Vinyl vinyl){
        vinyl.setCurrentVinylState(new ReservedState());
    }

  @Override public void borrow(Vinyl vinyl){
        vinyl.setCurrentVinylState(new BorrowedState());
    }

  @Override public void returned(Vinyl vinyl){
        //Unused as available vinyls cannot be returned
    }

}
