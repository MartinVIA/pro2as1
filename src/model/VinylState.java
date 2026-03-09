package model;

import utils.VinylObserver;

public interface VinylState  extends VinylObserver
{
    String getName();
    void reserveVinyl(Vinyl vinyl);
    void borrowVinyl(Vinyl vinyl);
    void returnVinyl(Vinyl vinyl);

}