package com.db.structural.adapter;

public class Customer {

    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        ITarget target = new Adapter(adaptee);

        System.out.println(target.getName());
        System.out.println(target.lastName());

    }
}
