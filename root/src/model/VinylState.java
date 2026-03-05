package model;
import utils.VinylObserver;

public interface VinylState extends VinylObserver {
    void reserve(Vinyl vinyl);
    void borrow(Vinyl vinyl);
    void returned(Vinyl vinyl);

}