package com.db.structural.adapter;

public class Adapter implements ITarget {

    private final IAdaptee adapted;
    Adapter (Adaptee adaptee){
        this.adapted =adaptee;
    }

    @Override
    public String getName() {
        return adapted.getName();
    }

    @Override
    public String lastName() {
        return adapted.getlastname();
    }
}
