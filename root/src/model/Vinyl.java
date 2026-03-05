package model;
public class Vinyl {
    private String title;
    private String artist;
    private VinylState vinylState;
    private int releaseYear;

    public Vinyl(String title,String artist,int releaseYear){
        this.title = title;
      vinylState = new AvailableState();
        this.artist = artist;
        this.releaseYear = releaseYear;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return title;
    }
    public void setArtist(String artist){
        this.artist = artist;
    }
    public  String getArtist(){
        return artist;
    }
    public void setReleaseYear(int releaseYear){
      this.releaseYear = releaseYear;
    }
    public void setVinylState(VinylState newVinylState){
      vinylState = newVinylState;
    }

}
