package com.lld.trafficsignalsystem;

public class Road {

    String id;
    String name;
    TrafficLight trafficLight;

    public Road(String id, String name) {
        this.id = id;
        this.name = name;

    }

    public TrafficLight getTrafficLight() {
        return trafficLight;
    }

    public void setTrafficLight(TrafficLight trafficLight) {
        this.trafficLight = trafficLight;
    }

    public String getId() {
        return id;
    }
}
