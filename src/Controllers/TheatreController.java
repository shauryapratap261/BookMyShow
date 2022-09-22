package Controllers;

import models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreController {

    Map<String, List<Theatre>>cityVsTheatres;
    List<Theatre>allTheatres;

    public TheatreController() {
        cityVsTheatres = new HashMap<>();
        allTheatres = new ArrayList<>();
    }

    public void addTheatre(String city, Theatre theatre){
        allTheatres.add(theatre);

        if(!cityVsTheatres.containsKey(city)){
            cityVsTheatres.put(city, new ArrayList<>());
        }
        cityVsTheatres.get(city).add(theatre);
    }

    // get all the shows in the city for a theatre and a given movie
    public Map<Theatre, List<Show>> getAllShows(Movie movie, String city){

        if(!cityVsTheatres.containsKey(city)){
            System.out.println("No shows in the city");
            return new HashMap<>();
        }

        List<Theatre> allTheatres = cityVsTheatres.get(city);
        Map<Theatre, List<Show>> theatreWiseShows = new HashMap<>();
        for(Theatre theatre : allTheatres){

            List<Show> allShowsForMovie = getShowsOfMovieInTheatre(theatre, movie);
            theatreWiseShows.put(theatre, allShowsForMovie);

        }

        return theatreWiseShows;

    }

    public List<Seat> getAvailableSeatsForMovieInTheatre(Theatre theatre, String movie){

        return getAvailableSeatsForMovie(theatre, movie);
//         = new ArrayList<>();
//
//        for(Theatre theatre1 : allTheatres){
//            if(theatre.getName().equals(theatre.getName())){
//                seats =
//                printAvailableSeats(seats);
//                return seats;
//            }
//        }
//
//        return seats;
    }

    private List<Seat> getAvailableSeatsForMovie(Theatre theatre, String movie){

        for(Show  show : theatre.getShows()){
            if(show.getMovie().getName().equals(movie)){
                return getAvailableSeatsInShow(show.getScreen());
            }
        }

        return new ArrayList<>();
    }

    private List<Seat> getAvailableSeatsInShow(Screen screen){
        List<Seat> availableSeats = new ArrayList<>();
        for(Seat seat : screen.getSeats()){
            if(!seat.isSeatLocked()){
                availableSeats.add(seat);
            }
        }
        return availableSeats;
    }

    public void printAvailableSeats(List<Seat>seats){
        System.out.println("Showing the available Seats");
        for(Seat seat : seats){
            System.out.println("Seat row : " + seat.getRow() + " seat ID : " + seat.getId() + " seat type : " + seat.getSeatCategory());
        }

    }

    private List<Show> getShowsOfMovieInTheatre(Theatre theatre, Movie movie){

        List<Show> shows = theatre.getShows();
        List<Show> movieShows = new ArrayList<>();
        for(Show show : shows){
            if(show.getMovie().getName().equals(movie.getName())){
                movieShows.add(show);
            }
        }
        return movieShows;
    }



    public Map<String, List<Theatre>> getCityVsTheatres() {
        return cityVsTheatres;
    }

    public void setCityVsTheatres(Map<String, List<Theatre>> cityVsTheatres) {
        this.cityVsTheatres = cityVsTheatres;
    }

    public List<Theatre> getAllTheatres() {
        return allTheatres;
    }

    public void setAllTheatres(List<Theatre> allTheatres) {
        this.allTheatres = allTheatres;
    }
}
