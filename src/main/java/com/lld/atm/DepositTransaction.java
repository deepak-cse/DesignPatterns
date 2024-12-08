package com.lld.atm;

public class DepositTransaction extends Transaction{

    public DepositTransaction(String transcationId, Account account, double amount) {
        super(transcationId, account, amount);
    }

    @Override
    public void execute() {
        account.credit(amount);
    }
}
