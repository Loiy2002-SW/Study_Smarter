package com.loisan.studysmarter.model;

import android.graphics.drawable.Drawable;

public class Theme {

    private Drawable img;
    private int price;

    public Theme(Drawable img, int price) {
        this.img = img;
        this.price = price;
    }

    public Drawable getImg() {
        return img;
    }

    public int getPrice() {
        return price;
    }

}
