package com.lld.carrentalsystem;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reservation {

    private final String reservationId;

    private final Customer customer;

    private final Car car;

    private final LocalDate startDate;

    private final LocalDate endDate;

    private double totalPrice;

    public Reservation(String reservationId, Customer customer, Car car, LocalDate startDate, LocalDate endDate) {
        this.reservationId = reservationId;
        this.customer = customer;
        this.car = car;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    private double calculateTotalPrice(){
        long rentDays = ChronoUnit.DAYS.between(startDate,endDate)+1;
        return car.getRentalPricePerDay()*rentDays;

    }

    public String getReservationId() {
        return reservationId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Car getCar() {
        return car;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }


}
