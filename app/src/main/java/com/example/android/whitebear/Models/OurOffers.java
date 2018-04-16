package com.example.android.whitebear.Models;

public class OurOffers {
    private String offerName;
    private int offerCount;
    private int thumbnail;
    public OurOffers(String offerName,int offerCount,int thumbnail){
        this.offerName=offerName;
        this.offerCount=offerCount;
        this.thumbnail=thumbnail;

    }

    public String getOfferName() {
        return offerName;
    }

    public int getOfferCount() {
        return offerCount;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setOfferName(String offeerName) {
        this.offerName = offeerName;
    }

    public void setOfferCount(int offerCount) {
        this.offerCount = offerCount;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
