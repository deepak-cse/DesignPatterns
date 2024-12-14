package com.lld.splitwise.splittype;

import com.lld.splitwise.User;

public class PercentSplit extends Split{
    private final double percent;

    public PercentSplit(User user, double percent) {
        super(user);
        this.percent = percent;
    }


    @Override
    public double getAmount() {
        return 0;
    }

    public double getPercent() {
        return percent;
    }
}
