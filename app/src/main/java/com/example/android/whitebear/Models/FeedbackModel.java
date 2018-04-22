package com.example.android.whitebear.Models;

/**
 * Created by dellpc on 4/15/2018.
 */

public class FeedbackModel {

    private boolean celeb;
    private String cusId;
    private String day;
    private String eventType;
    private String guestN;
    private String month;
    private boolean nonVeg;
    private String pack;
    private String total;
    private String venue;
    private String year;
    private String key;
    private String eventId;
    private String phone;

    public FeedbackModel() {
    }

    public FeedbackModel(boolean celeb, String cusId, String day, String eventType, String guestN, String month, boolean nonVeg, String pack, String total, String venue, String year, String key, String eventId,String phone) {
        this.celeb = celeb;
        this.cusId = cusId;
        this.day = day;
        this.eventType = eventType;
        this.guestN = guestN;
        this.month = month;
        this.nonVeg = nonVeg;
        this.pack = pack;
        this.total = total;
        this.venue = venue;
        this.year = year;
        this.key = key;
        this.eventId = eventId;
        this.phone=phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isCeleb() {
        return celeb;
    }

    public String getCusId() {
        return cusId;
    }

    public String getDay() {
        return day;
    }

    public String getEventType() {
        return eventType;
    }

    public String getGuestN() {
        return guestN;
    }

    public String getMonth() {
        return month;
    }

    public boolean isNonVeg() {
        return nonVeg;
    }

    public String getPack() {
        return pack;
    }

    public String getTotal() {
        return total;
    }

    public String getVenue() {
        return venue;
    }

    public String getYear() {
        return year;
    }

    public String getKey() {
        return key;
    }

    public void setCeleb(boolean celeb) {
        this.celeb = celeb;
    }

    public String getEventId() {
        return eventId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public void setGuestN(String guestN) {
        this.guestN = guestN;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setNonVeg(boolean nonVeg) {
        this.nonVeg = nonVeg;
    }

    public void setPack(String pack) {
        this.pack = pack;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }
}