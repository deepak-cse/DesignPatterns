package com.db.structural.adapter;

public class Adaptee implements IAdaptee{
    @Override
    public String getName() {
        return "deepak"+"prajapati";
    }
    @Override
    public String getlastname() {
        return "prajapati"+"deepak";
    }
}
