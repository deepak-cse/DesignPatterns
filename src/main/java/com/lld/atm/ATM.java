package com.lld.atm;

import javax.naming.InsufficientResourcesException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    public double checkBalance(String accountNumber) {
        Account account = bankingService.getAccount(accountNumber);
        return account.getBalance();

    }

    public void withdrawCash(String accountNumber, double amount) throws InsufficientResourcesException {
        Account account = bankingService.getAccount(accountNumber);
        Transaction transaction = new WithdrawlTransaction( getTransactionId(), account, amount);
        bankingService.processTransaction(transaction);
        cashDispenser.dispenseCash((int)amount);
    }

    private String getTransactionId() {
        long transactionNumber = transactionCounter.getAndIncrement();
        String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        return "TXN" + timeStamp + String.format("%010d",transactionNumber);
    }

    public void depositCash(String accountNumber, double amount){
        Account account = bankingService.getAccount(accountNumber);
        Transaction transaction = new DepositTransaction( getTransactionId(), account, amount);
        bankingService.processTransaction(transaction);

    }

}
