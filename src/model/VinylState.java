package model;

public interface VinylState{

    @Override
    String toString();
    void reserveVinyl(Vinyl vinyl);
    void borrowVinyl(Vinyl vinyl);
    void returnVinyl(Vinyl vinyl);
    

}