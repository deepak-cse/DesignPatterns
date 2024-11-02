package com.lld.parkinglot;

import com.lld.parkinglot.vehicle.*;

public class Driver {
    public static void main(String[] args) {

        ParkingLot parkingLot = ParkingLot.getInstance();
        parkingLot.addLevel(new Level(1,100));
        parkingLot.addLevel(new Level(2,80));


        Vehicle car = new Car("1234");

        Vehicle bike = new Bike("2345");

        Vehicle cycle = new Cycle("1234");

        parkingLot.parkVehicle(car);
        parkingLot.parkVehicle(bike);
        parkingLot.unparkVehicle(car);

        parkingLot.displayAvailability();


    }

}
