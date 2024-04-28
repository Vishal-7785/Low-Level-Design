import java.util.*;

public class Show {
    int id;
    String name;
    String minutes;
    Boolean trending;
    List<String> actors;
    Genre genre;
    double rating;
    String description;

    public Show(int id,String name,String minutes,Boolean trending,List<String> actors,Genre genre,double rating,String description){
        this.id = id;
        this.name = name;
        this.minutes = minutes;
        this.trending = trending;
        this.actors = actors;
        this.genre = genre;
        this.rating = rating;
        this.description = description;
    } 

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getMinutes(){
        return minutes;
    }
    public Boolean getTrending(){
        return trending;
    }
    public List<String> getActors(){
        return actors;
    }
    public Genre getGenre(){
        return genre;
    }
    public double getRating(){
        return rating;
    }
    public String getDescription(){
        return description;
    }




}
