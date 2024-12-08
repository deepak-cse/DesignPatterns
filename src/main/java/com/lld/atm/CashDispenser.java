package com.lld.atm;

import javax.naming.InsufficientResourcesException;

public class CashDispenser {
    private int cashAvailable;

    public CashDispenser(int initialCash) {
        this.cashAvailable = initialCash;
    }


    public synchronized void dispenseCash(int amount) throws InsufficientResourcesException {
        if(amount>cashAvailable){
            throw new InsufficientResourcesException("Cash unavailable");
        }
        cashAvailable-=amount;
        System.out.println("Cash dispensed: "+ amount);
    }


}
