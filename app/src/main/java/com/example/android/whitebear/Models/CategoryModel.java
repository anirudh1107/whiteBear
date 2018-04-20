package com.example.android.whitebear.Models;

/**
 * Created by dellpc on 4/21/2018.
 */

public class CategoryModel {

    int Imgres;
    String name;

    public CategoryModel(int imgres, String name) {
        Imgres = imgres;
        this.name = name;
    }

    public int getImgres() {
        return Imgres;
    }

    public String GetName() {
        return name;
    }

    public void setImgres(int imgres) {
        Imgres = imgres;
    }

    public void SetName(String name) {
        this.name = name;
    }
}
