package com.lld.parkinglot;

import com.lld.parkinglot.vehicle.Vehicle;
import com.lld.parkinglot.vehicle.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Level {
    private final int floor;

    List<ParkingSpot> parkingSpotList;


    public Level(int floor, int numSpots) {
       this.floor=floor;
       parkingSpotList = new ArrayList<>(numSpots);

       double bikeSpotsRatio = 0.50;
       double carsSpotsRatio = 0.40;

       int bikeSpots = (int) (numSpots * bikeSpotsRatio);
       int carsSpots = (int) (numSpots * carsSpotsRatio);


       for(int i=0;i<=bikeSpots;i++) {
           parkingSpotList.add(new ParkingSpot(i, VehicleType.Bike));
       }

        for(int i=bikeSpots+1;i<=bikeSpots+carsSpots;i++) {
            parkingSpotList.add(new ParkingSpot(i, VehicleType.Car));
        }

        for(int i=bikeSpots+carsSpots+1;i<=numSpots;i++) {
            parkingSpotList.add(new ParkingSpot(i, VehicleType.Cycle));
        }

    }


    public synchronized boolean parkVehicle(Vehicle vehicle) {
        for(ParkingSpot parkingSpot : parkingSpotList) {
            if(parkingSpot.isAvailable() && parkingSpot.getVehicleType()==vehicle.getVehicleType()){
                parkingSpot.parkVehicle(vehicle);
                return true;
            }
        }

        return false;
    }


    public synchronized boolean unparkVehicle ( Vehicle vehicle) {
        for( ParkingSpot parkingSpot : parkingSpotList) {
            if(!parkingSpot.isAvailable() && parkingSpot.getVehicleParked().equals(vehicle)){
                parkingSpot.unparkVehicle();
                return true;
            }
        }

        return false;
    }


    public void displayAvailability() {
        System.out.println("level" + floor + "with parking spot capacity" + parkingSpotList.size());
        for(ParkingSpot parkingSpot: parkingSpotList) {
            if(parkingSpot.isAvailable()){
                System.out.println("Spot number" + parkingSpot.getSpotNumber()+"with vehicle type"+parkingSpot.getVehicleType());
            }
            else System.out.println("Spot number"+ parkingSpot.getSpotNumber()+"occupied by"+parkingSpot.getVehicleParked().getNumberPlate());

        }

    }





}
