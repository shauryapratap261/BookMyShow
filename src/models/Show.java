package models;

import java.util.ArrayList;
import java.util.List;

public class Show {
    Movie movie;
    Screen screen;
    List<Seat> bookedSeats;
    int startTime;

    public Show(Movie movie, Screen screen, int startTime) {
        this.movie = movie;
        this.screen = screen;
        this.bookedSeats = new ArrayList<>();
        this.startTime = startTime;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public List<Seat> getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(List<Seat> bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }
}
