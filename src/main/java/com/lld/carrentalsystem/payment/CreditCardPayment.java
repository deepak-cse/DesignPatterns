package com.lld.carrentalsystem.payment;

public class CreditCardPayment implements PaymentProcessor{
    @Override
    public boolean processPayment(double amount) {
        //credit card payment
        return true;
    }
}
