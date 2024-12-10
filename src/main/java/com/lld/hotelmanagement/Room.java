package com.lld.hotelmanagement;

public class Room {

    private final String id;
    private final double price;
    private RoomStatus roomStatus;
    private final RoomType roomType;

    public Room(String id, double price, RoomType roomType) {
        this.id = id;
        this.price = price;
        this.roomType = roomType;
    }

    public synchronized void book(){
        if(roomStatus==RoomStatus.AVAILABLE){
            roomStatus=RoomStatus.BOOKED;
        }else {
            throw new RuntimeException("");
        }
    }

    public synchronized  void checkIn(){
        if(roomStatus==RoomStatus.BOOKED){
            roomStatus=RoomStatus.OCCUPIED;
        }else {
            throw new RuntimeException("");
        }
    }

    public synchronized void checkOut(){
        if(roomStatus==RoomStatus.OCCUPIED){
            roomStatus=RoomStatus.AVAILABLE;
        }else {
            throw new RuntimeException("");
        }
    }

    public String getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public RoomStatus getRoomStatus() {
        return roomStatus;
    }

    public RoomType getRoomType() {
        return roomType;
    }
}
