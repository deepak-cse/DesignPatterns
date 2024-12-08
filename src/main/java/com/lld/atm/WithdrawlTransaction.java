package com.lld.atm;

public class WithdrawlTransaction extends Transaction{

    public WithdrawlTransaction(String transactionId, Account account, double amount) {
        super(transactionId, account, amount);
    }

    @Override
    public void execute() {
        account.debit(amount);
    }
}
