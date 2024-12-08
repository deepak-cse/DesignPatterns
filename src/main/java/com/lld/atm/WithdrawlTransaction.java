package com.lld.atm;

public class WithdrawlTransaction extends Transaction{

    public WithdrawlTransaction(String transcationId, Account account, double amount) {
        super(transcationId, account, amount);
    }

    @Override
    public void execute() {
        account.debit(amount);
    }
}
