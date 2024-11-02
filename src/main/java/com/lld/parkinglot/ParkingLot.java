package com.lld.parkinglot;

import com.lld.parkinglot.vehicle.Vehicle;

import java.sql.Struct;
import java.util.ArrayList;
import java.util.List;

//singleton object
public class ParkingLot {

    private static ParkingLot parkingLot;

    private final List<Level> levelList;

    private ParkingLot() {
        this.levelList = new ArrayList<>();
    }

    public static ParkingLot getInstance() {
        if(parkingLot!=null)
            return parkingLot;
        else return parkingLot=new ParkingLot();

    }

    public void addLevel(Level level) {

        levelList.add(level);

    }

    public boolean parkVehicle(Vehicle vehicle) {
        for(Level level : levelList) {
            if(level.parkVehicle(vehicle)) {
                System.out.println("successfully parked vehicle");
                return true;
            }
        }

        System.out.println("could not park vehicle");
        return false;
    }

    public boolean unparkVehicle(Vehicle vehicle) {

        for(Level level : levelList) {
            if(level.unparkVehicle(vehicle)) {
                return true;
            }
        }

        return false;

    }


    public void displayAvailability(){
        for(Level level:levelList){
            level.displayAvailability();
        }
    }



}
