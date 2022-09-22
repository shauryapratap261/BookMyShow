package Controllers;

import enums.SeatCategory;
import models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BookMyShowController {

    TheatreController theatreController;
    MovieControllers movieControllers;

    public BookMyShowController() {
        this.theatreController = new TheatreController();
        this.movieControllers = new MovieControllers();
    }

    public void initialise(){

        // 2 Cities
        City city1 = new City("SRE");
        City city2 = new City("DDN");

        // create 2 theatres in each city

        List<Seat>seatsInScreen = getSeats();
        // create 2 screens in a theatre
        Screen screen1 = new Screen(1, seatsInScreen);
        Screen screen2 = new Screen(2, seatsInScreen);
        List<Screen>screens = new ArrayList<>();
        screens.add(screen1);
        screens.add(screen2);

        // make 2 shows
        Show bahubaliShow1 = new Show(new Movie("Bahubali"), screen1, 5);
        Show KGFShow1 = new Show(new Movie("KGF"), screen2, 8);


        // put shows in theatre
        List<Show>showsInTheatre1 = new ArrayList<>();
        showsInTheatre1.add(bahubaliShow1);
        showsInTheatre1.add(KGFShow1);

        theatreController.addTheatre(city1.getName(), new Theatre("SRE_PVR",showsInTheatre1, screens));



//        2nd theatre
        // create 2 screens in a theatre
        screen1 = new Screen(1, seatsInScreen);
        screen2 = new Screen(2, seatsInScreen);
        screens = new ArrayList<>();
        screens.add(screen1);
        screens.add(screen2);

        // make 2 shows
        bahubaliShow1 = new Show(new Movie("Bahubali"), screen1, 6);
        KGFShow1 = new Show(new Movie("KGF"), screen2, 9);


        // put shows in theatre
        showsInTheatre1 = new ArrayList<>();
        showsInTheatre1.add(bahubaliShow1);
        showsInTheatre1.add(KGFShow1);

        theatreController.addTheatre(city2.getName(), new Theatre("DDN_PVR", showsInTheatre1, screens));

    }

    private List<Seat> getSeats(){

        List<Seat>seatsInScreen = new ArrayList<>();
//        add 2 rows with 2 seats each, first row as normal and second as premium
        for(int i=1;i<=2;i++){
            for(int j=1;j<=2;j++){
                Seat seat;
                if(i == 1){
                    seat = new Seat(i, j, SeatCategory.NORMAL);
                } else{
                    seat = new Seat(i, j, SeatCategory.PREMIUM);
                }
                seatsInScreen.add(seat);
            }
        }

        return seatsInScreen;

    }

    public void printShows(Map<Theatre, List<Show>> shows){

        for(Map.Entry<Theatre, List<Show>> theatreListEntry : shows.entrySet()){
            List<Show> theatreShows = theatreListEntry.getValue();
            System.out.println("Printing all the shows in " + theatreListEntry.getKey().getName());
            for(Show show : theatreShows){
                System.out.println("Movie : " + show.getMovie().getName() + " at : " + show.getStartTime());
            }
        }
    }

    public List<Show> getShows(Map<Theatre, List<Show>> shows){

        List<Show>allShows = new ArrayList<>();
        for(Map.Entry<Theatre, List<Show>> theatreListEntry : shows.entrySet()){
            List<Show> theatreShows = theatreListEntry.getValue();
            System.out.println("Printing all the shows in " + theatreListEntry.getKey().getName());
            for(Show show : theatreShows){
                allShows.add(show);
                System.out.println("Movie : " + show.getMovie().getName() + " at : " + show.getStartTime());
            }
        }

        return allShows;
    }

    public Booking createBooking(Show show, List<Seat>seats, List<Integer>indexOfSeats){

        List<Seat>bookedSeats =  new ArrayList<>();
        for(int i : indexOfSeats){
            if(seats.get(i).isSeatLocked()){
                System.out.println("Can't reserve the seat with row : " + seats.get(i).getRow() + " and id : " + seats.get(i).getId());
                return null;
            }
            bookedSeats.add(seats.get(i));
        }

        for (Seat seat : bookedSeats){
            seat.reserveSeat();
        }

        Booking booking = new Booking(show, bookedSeats);

        System.out.println("Created booking for the selected seats");
        return booking;

    }

    public TheatreController getTheatreController() {
        return theatreController;
    }

    public void setTheatreController(TheatreController theatreController) {
        this.theatreController = theatreController;
    }

    public MovieControllers getMovieControllers() {
        return movieControllers;
    }

    public void setMovieControllers(MovieControllers movieControllers) {
        this.movieControllers = movieControllers;
    }
}
