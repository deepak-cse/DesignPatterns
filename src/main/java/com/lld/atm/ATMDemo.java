package com.lld.atm;

public class ATMDemo {

    public static void main(String[] args) {

        BankingService bankingService = new BankingService();
        CashDispenser cashDispenser = new CashDispenser();
        ATM atm = new ATM(bankingService,cashDispenser);

        cashDispenser.

    }
}
