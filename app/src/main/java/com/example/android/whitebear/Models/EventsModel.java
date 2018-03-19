package com.example.android.whitebear.Models;

/**
 * Created by dellpc on 3/19/2018.
 */

public class EventsModel {

    private String cusId;
    private String eventType;
    private String venue;

    public EventsModel(String cusId, String eventType, String venue) {
        this.cusId = cusId;
        this.eventType = eventType;
        this.venue = venue;
    }

    public String getCusId() {
        return cusId;
    }

    public String getEventType() {
        return eventType;
    }

    public String getVenue() {
        return venue;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }
}
