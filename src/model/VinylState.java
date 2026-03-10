package model;

import utils.VinylObserver;

public interface VinylState
{
    String getName();
    void reserveVinyl(Vinyl vinyl);
    void borrowVinyl(Vinyl vinyl);
    void returnVinyl(Vinyl vinyl);

}