package model;

public class AvailableState implements VinylState {

  @Override public void reserve(Vinyl vinyl){
        vinyl.setVinylState(new ReservedState());
    }

  @Override public void borrow(Vinyl vinyl){
        vinyl.setVinylState(new BorrowedState());
    }

  @Override public void returned(Vinyl vinyl){
        //Unused as available vinyls cannot be returned
    }
}
