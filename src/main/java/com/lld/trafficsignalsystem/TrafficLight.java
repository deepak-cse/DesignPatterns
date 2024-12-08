package com.lld.trafficsignalsystem;

public class TrafficLight {

    String id;
    Signal currentSignal;
    int redDuration;
    int greenDuration;
    int yellowDuration;

    public TrafficLight(String id, int redDuration, int greenDuration, int yellowDuration) {
        this.id = id;
        this.currentSignal = Signal.RED;
        this.redDuration = redDuration;
        this.greenDuration = greenDuration;
        this.yellowDuration = yellowDuration;
    }

    public synchronized void changeSignal(Signal signal) {
        this.currentSignal=signal;
        notifyObservers();
    }

    private void notifyObservers(){
        //observers logic
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Signal getCurrentSignal() {
        return currentSignal;
    }

    public void setCurrentSignal(Signal currentSignal) {
        this.currentSignal = currentSignal;
    }

    public int getRedDuration() {
        return redDuration;
    }

    public void setRedDuration(int redDuration) {
        this.redDuration = redDuration;
    }

    public int getGreenDuration() {
        return greenDuration;
    }

    public void setGreenDuration(int greenDuration) {
        this.greenDuration = greenDuration;
    }

    public int getYellowDuration() {
        return yellowDuration;
    }

    public void setYellowDuration(int yellowDuration) {
        this.yellowDuration = yellowDuration;
    }
}
