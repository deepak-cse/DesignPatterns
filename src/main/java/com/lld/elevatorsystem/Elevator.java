package com.lld.elevatorsystem;

import java.util.ArrayList;
import java.util.List;

public class Elevator {

    private final int id;
    private final int capacity;
    private int currentFloor;
    private Direction direction;
    private final List<Request> requests;

    public Elevator(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
        this.currentFloor=1;
        this.direction = Direction.UPWARD;
        this.requests = new ArrayList<>();
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void run() {
        processRequests();
    }

    private synchronized void processRequests() {
        while(true){

            while(!requests.isEmpty()){
                Request request = getNextRequest();
                processRequest(request);
            }

            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    private void processRequest(Request request) {
        int sourceFloor = request.getSourceFloor();
        int destinationFloor = request.getDestinationFloor();

        if(sourceFloor<destinationFloor){
            direction = Direction.UPWARD;
            for(int i=sourceFloor;i<=destinationFloor;i++){
                currentFloor=i;
                System.out.println("Elevator " + id + " reached Floor " + currentFloor);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        } else {
            direction = Direction.DOWNWARD;
            for(int i=destinationFloor;i>=sourceFloor;i--){
                currentFloor = i;
                System.out.println("Elevator " + id + " reached Floor " + currentFloor);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    private Request getNextRequest() {
        while(requests.isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return requests.remove(0);
    }

    public synchronized void addRequest(Request request) {
        if(requests.size()<capacity) {
            requests.add(request);
            System.out.println("Elevator " + id + "added request" + request);
            notifyAll();
        }

    }
}
