package model;

public interface VinylState   {
    String getName();
    void reserve(Vinyl vinyl);
    void borrow(Vinyl vinyl);
    void returned(Vinyl vinyl);

}