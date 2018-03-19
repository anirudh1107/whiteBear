package com.example.android.whitebear.Models;

/**
 * Created by dellpc on 3/19/2018.
 */

public class CustomerModel {
    private String cusId;
    private String name;
    private long phone;
    private String address;
    private String eventId;
    private String emailId;

    public CustomerModel(String cusId, String name, long phone, String address, String eventId, String emailId) {
        this.cusId = cusId;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.eventId = eventId;
        this.emailId = emailId;
    }

    public String getCusId() {
        return cusId;
    }

    public String getName() {
        return name;
    }

    public long getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getEventId() {
        return eventId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
