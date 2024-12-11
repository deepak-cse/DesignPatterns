package com.lld.elevatorsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ElevatorController {

    private final List<Elevator> elevators;

    public ElevatorController(int numElevators, int capacity) {
        elevators = new ArrayList<>();
        for(int i=0;i<numElevators;i++){
            Elevator elevator = new Elevator(i+1,capacity);
            elevators.add(elevator);
            new Thread(elevator::run).start();
        }
    }

    public void requestElevator(int sourceFloor, int destinationFloor) {
        Elevator optimalElevator = findOptimalElevator(sourceFloor, destinationFloor);
        optimalElevator.addRequest(new Request(sourceFloor,destinationFloor));
    }

    private Elevator findOptimalElevator(int sourceFloor, int destinationFloor) {
        Elevator optimalElevator = null;
        int minDistance = Integer.MAX_VALUE;

        for(Elevator elevator : elevators) {
            int diff = Math.abs(elevator.getCurrentFloor()-sourceFloor);
            if(diff<minDistance) {
                minDistance=diff;
                optimalElevator = elevator;
            }
        }

        return optimalElevator;

    }
}
