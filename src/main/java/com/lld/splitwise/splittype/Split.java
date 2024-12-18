package com.lld.splitwise.splittype;

import com.lld.splitwise.User;

public abstract class Split {

    protected  User user;
    protected double amount;

    public Split(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public abstract double getAmount();

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
