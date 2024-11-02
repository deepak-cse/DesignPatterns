package com.lld.parkinglot;

import com.lld.parkinglot.vehicle.Vehicle;
import com.lld.parkinglot.vehicle.VehicleType;
import lombok.extern.slf4j.Slf4j;

public class ParkingSpot {

    private final int spotNumber;
    private final VehicleType vehicleType;
    private Vehicle vehicleParked;


    public ParkingSpot(int spotNumber, VehicleType vehicleType) {
        this.spotNumber = spotNumber;
        this.vehicleType = vehicleType;
    }


    public synchronized boolean isAvailable() {
        return vehicleParked==null;
    }

    public synchronized  void parkVehicle (Vehicle vehicle) {
        if(isAvailable() && vehicle.getVehicleType()==vehicleType) {
            this.vehicleParked=vehicle;
        }
        else throw new RuntimeException("not have same vehicle type or the spot already occupied");
    }

    public synchronized void unparkVehicle() {
        this.vehicleParked=null;
    }
    public int getSpotNumber () { return spotNumber;}

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public Vehicle getVehicleParked() {
        return vehicleParked;
    }
}
