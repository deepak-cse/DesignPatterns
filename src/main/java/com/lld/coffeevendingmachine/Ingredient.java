package com.lld.coffeevendingmachine;

public class Ingredient {
    private String name;
    int quantity;

    public Ingredient(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }


    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public synchronized void updateQuantity(int amount){
        this.quantity+=amount;
    }

}
