package com.lld.hotelmanagement.payment;

public interface PaymentProcessor {
    boolean processTransaction(double amount);
}
