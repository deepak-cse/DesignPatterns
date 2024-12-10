package com.lld.hotelmanagement.payment;

public class PayPalPaymentProcessor implements PaymentProcessor{
    @Override
    public boolean processTransaction(double amount) {

        return false;
    }
}
