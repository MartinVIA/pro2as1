package model;

import utils.VinylObserver;

public interface VinylState
{
    String toString();
    void reserveVinyl(Vinyl vinyl);
    void borrowVinyl(Vinyl vinyl);
    void returnVinyl(Vinyl vinyl);

}