package com.lld.hotelmanagement;

import java.time.LocalDate;
import java.util.Date;

public class Reservation {
    private final String id;
    private final Guest guest;
    private final Room room;
    private final LocalDate checkInDate;
    private final LocalDate checkOutDate;
    private ReservationStatus status;

    public Reservation(String id, Guest guest, Room room, LocalDate checkInDate, LocalDate checkOutDate) {
        this.id = id;
        this.guest = guest;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public synchronized void cancel(){
        if(status==ReservationStatus.CONFIRMED){
            status=ReservationStatus.CANCELLED;
            room.checkOut();
        }else {
            throw new RuntimeException("Resservation is not confirmed, please book first to cancel");
        }
    }


    public String getId() {
        return id;
    }

    public Guest getGuest() {
        return guest;
    }

    public Room getRoom() {
        return room;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public ReservationStatus getStatus() {
        return status;
    }
}
