package com.lld.carrentalsystem.payment;

public class PayPalPayment implements PaymentProcessor{
    @Override
    public boolean processPayment(double amount) {
        //paypal payment
        return true;
    }
}
