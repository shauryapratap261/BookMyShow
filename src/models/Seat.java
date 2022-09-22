package models;

import enums.SeatCategory;

public class Seat {
    private int row;
    private int id;
    private SeatCategory seatCategory;
    private boolean seatLocked;

    public Seat(int row, int id, SeatCategory seatCategory) {
        this.row = row;
        this.id = id;
        this.seatCategory = seatCategory;
        this.seatLocked = false;
    }

    public boolean reserveSeat(){
        synchronized (this) {
            if (this.seatLocked) {
                System.out.println("Seat already occupied, try another");
                return false;
            }
            this.seatLocked = true;
            return true;
        }
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SeatCategory getSeatCategory() {
        return seatCategory;
    }

    public void setSeatCategory(SeatCategory seatCategory) {
        this.seatCategory = seatCategory;
    }

    public boolean isSeatLocked() {
        return seatLocked;
    }

    public void setSeatLocked(boolean seatLocked) {
        this.seatLocked = seatLocked;
    }
}
