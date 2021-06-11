package com.example.labello.offers;

public class OffersModel {

    private String name;
    private String price;
    private int picture;

    public OffersModel(String name, String price, int picture) {
        this.name = name;
        this.price = price;
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public int getPicture() {
        return picture;
    }

}
