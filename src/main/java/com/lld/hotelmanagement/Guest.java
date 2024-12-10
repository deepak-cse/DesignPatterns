package com.lld.hotelmanagement;

public class Guest {

    private final String id;
    private final String name;
    private final String emailId;
    private final String phoneNumber;

    public Guest(String id, String name, String emailId, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
