package com.lld.atm;

public abstract class Transaction {
    protected  final String transcationId;
    protected final Account account;
    protected  final double amount;

    public Transaction(String transcationId, Account account, double amount) {
        this.transcationId = transcationId;
        this.account = account;
        this.amount = amount;
    }

    public abstract void execute();

}
