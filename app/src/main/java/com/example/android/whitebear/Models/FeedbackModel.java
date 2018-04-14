package com.example.android.whitebear.Models;

public class FeedbackModel {
    private String clientId;
    private String eventId;

    public FeedbackModel(String clientUID, String eventId) {
        this.clientId = clientUID;
        this.eventId = eventId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientUID) {
        this.clientId = clientUID;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }
}
