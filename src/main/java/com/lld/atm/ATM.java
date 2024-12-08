package com.lld.atm;

import java.util.concurrent.atomic.AtomicLong;

public class ATM {

    private final BankingService bankingService;

    private final CashDispenser cashDispenser;

    private static final AtomicLong transactionCounter = new AtomicLong(0);

    public ATM(BankingService bankingService, CashDispenser cashDispenser) {
        this.bankingService = bankingService;
        this.cashDispenser = cashDispenser;
    }

    public void authenticateUser(Card card){
        //authenticate user using card number and pin
    }

}
