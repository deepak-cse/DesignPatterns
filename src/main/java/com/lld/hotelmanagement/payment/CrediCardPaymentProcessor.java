package com.lld.hotelmanagement.payment;

public class CrediCardPaymentProcessor implements PaymentProcessor{
    @Override
    public boolean processTransaction(double amount) {

        return false;
    }
}
