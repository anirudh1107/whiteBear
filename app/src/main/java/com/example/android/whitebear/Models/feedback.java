package com.example.android.whitebear.Models;

/**
 * Created by hp on 10-04-2018.
 */

public class feedback {
    public String titleid;
    public int sadid;
    public int normalid;
    public int happyid;
    public int aagid;

    public feedback() {
    }

    public feedback(String titleid, int sadid, int normalid, int happyid, int aagid) {
        this.titleid = titleid;
        this.sadid = sadid;
        this.normalid = normalid;
        this.happyid = happyid;
        this.aagid = aagid;
    }

    public void setTitleid(String titleid) {
        this.titleid = titleid;
    }

    public void setSadid(int sadid) {
        this.sadid = sadid;
    }

    public void setNormalid(int normalid) {
        this.normalid = normalid;
    }

    public void setHappyid(int happyid) {
        this.happyid = happyid;
    }

    public void setAagid(int aagid) {
        this.aagid = aagid;
    }

    public String getTitleid() {
        return titleid;
    }

    public int getSadid() {
        return sadid;
    }

    public int getNormalid() {
        return normalid;
    }

    public int getHappyid() {
        return happyid;
    }

    public int getAagid() {
        return aagid;
    }
}
