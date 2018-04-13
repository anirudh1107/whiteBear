package com.example.android.whitebear.Models;

/**
 * Created by dellpc on 3/19/2018.
 */

public class CustomerModel {
    private String cusId;
    private String name;
    private String phone;
    private String address;
    private String eventId;
    private String emailId;

    public CustomerModel() {
    }

    public CustomerModel(String cusId, String name, String phone, String address, String eventId, String emailId) {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
