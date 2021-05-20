package com.example.myapp.data.models;


public class DrinkModel {
private int image;
private String price;
private String name;



    public DrinkModel(String price,String name, int image){
        this.image=image;
        this.name=name;
        this.price=price;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public String getPrice() {
        return price;
    }
}
