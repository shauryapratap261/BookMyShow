package models;

import java.util.ArrayList;
import java.util.List;

public class Booking {
    Show show;
    List<Seat> bookedSeats;

    public Booking(Show show, List<Seat> bookedSeats) {
        this.show = show;
        this.bookedSeats = bookedSeats;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public List<Seat> getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(List<Seat> bookedSeats) {
        this.bookedSeats = bookedSeats;
    }
}
