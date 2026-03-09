package model;

public class AvailableState implements VinylState {

  @Override public String getName() {
    return "";
  }

  @Override public void reserveVinyl(Vinyl vinyl){
        vinyl.setCurrentVinylState(new ReservedState());
    }

  @Override public void borrowVinyl(Vinyl vinyl){
        vinyl.setCurrentVinylState(new BorrowedState());
    }

  @Override public void returnVinyl(Vinyl vinyl){
        //Unused as available vinyls cannot be returned
    }

}
