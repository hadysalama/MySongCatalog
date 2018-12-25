/** 
*Hady Salama
*Song Catalog Program
*2018 APCSP Create Task
*The Song class defines the Song object and defines methods that return its attributes as well as reset the Song's rating.
*The MySongCatalog class uses the Song class so the Song class is in the same folder as MySongCatalog.
*/
public class Song {
    private String name; //The Song's name.
    private String artist; //The The Song's artist.
    private int year; //The Song's year of release.
    private boolean single; //If true then Song is a single, otherwise it will be part of an album or extended play.
    private double rating; //The users personalized rating on a scale of 1-10
    //Variable names in these feilds are another example of abstraction.

    //The Song constructor creates the song object through parameters that are assigneed to the Song object's private attributes.
    public Song(String name, String artist, int year, boolean single, double rating) {
        this.name = name;
        this.artist = artist;
        this.year = year;
        this.single = single;
        this.rating = rating;
    }

    //@return: the Song object's name.
    public String getName() {
        return this.name;
    }

    //@return: returns the Song object's artist.
    public String getArtist() {
        return this.artist;
    }

    //@return: the Song object's year of release.
    public int getYear() {
        return this.year;
    }

    //@return: true if the Song object is a single and false if the Song object is part of an album or extended play.
    public boolean isSingle() {
        return this.single;
    }

    //@return: the Song object's user generated rating.
    public double getRating() {
        return this.rating;
    }

    //Resets the Song object's user generated rating.
    //@param newRating: a double (0.0-10.0) that is fed into the method and becomes the rating of new Song object.
    //newRating is an example of abstraction used as a parameter.
    public void setRating(double newRating) {
        this.rating = newRating;
    }

}
