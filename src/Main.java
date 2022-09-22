import Controllers.BookMyShowController;
import Controllers.MovieControllers;
import Controllers.TheatreController;
import enums.SeatCategory;
import models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        BookMyShowController bookMyShowController =  new BookMyShowController();

        bookMyShowController.initialise();

        // get all shows of bahubali in a SRE
        Map<Theatre, List<Show>>allBahubaliShowsInSre =  bookMyShowController.getTheatreController().getAllShows(new Movie("Bahubali"), "SRE");
        bookMyShowController.printShows(allBahubaliShowsInSre);

        // show avaialable seats for first theatre which has bahubali show available
        Theatre theatre = bookMyShowController.getTheatreController().getAllTheatres().get(0);
        List<Seat>availableSeats = bookMyShowController.getTheatreController().getAvailableSeatsForMovieInTheatre(theatre, "Bahubali");
        bookMyShowController.getTheatreController().printAvailableSeats(availableSeats);

        // get all the shows list of bahubali in sre
        List<Show>allBahubaliShowsListInSre = bookMyShowController.getShows(allBahubaliShowsInSre);
        // selected the seats
        List<Integer>seatIndexToReserve = new ArrayList<>();
        seatIndexToReserve.add(0);
        seatIndexToReserve.add(3);

        Booking booking = bookMyShowController.createBooking(allBahubaliShowsListInSre.get(0), availableSeats, seatIndexToReserve);

        bookMyShowController.getTheatreController().getAvailableSeatsForMovieInTheatre(theatre, "Bahubali");
        booking = bookMyShowController.createBooking(allBahubaliShowsListInSre.get(0), availableSeats, seatIndexToReserve);
    }
}
