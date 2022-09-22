package Controllers;

import models.City;
import models.Movie;
import models.Theatre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieControllers {

    Map<String, List<Movie>> cityVsMovies;
    List<Movie>allMovies;

    public MovieControllers() {
        cityVsMovies = new HashMap<>();
        allMovies = new ArrayList<>();
    }

    public void addMovie(String city, Movie movie){
        allMovies.add(movie);

        if(!cityVsMovies.containsKey(city)){
            cityVsMovies.put(city, new ArrayList<>());
        }
        cityVsMovies.get(city).add(movie);
    }

    public List<Movie> getMoviesInCity(String city){
        return cityVsMovies.get(city);
    }

    public Map<String, List<Movie>> getCityVsMovie() {
        return cityVsMovies;
    }

    public void setCityVsMovie(Map<String, List<Movie>> cityVsMovie) {
        this.cityVsMovies = cityVsMovie;
    }

    public List<Movie> getAllMovies() {
        return allMovies;
    }

    public void setAllMovies(List<Movie> allMovies) {
        this.allMovies = allMovies;
    }
}
