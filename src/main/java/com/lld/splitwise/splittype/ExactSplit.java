package com.lld.splitwise.splittype;

import com.lld.splitwise.User;

public class ExactSplit extends Split{

    public ExactSplit(User user, double amount) {
        super(user);
        this.amount =amount;
    }

    @Override
    public double getAmount() {
        return 0;
    }


}
