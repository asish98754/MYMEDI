package com.example.mymedi.Domain;

import java.io.Serializable;

public class RecommendDomain implements Serializable {

    private String title;
    private String pic;
    private String description;
    private double price;
    private int numberInCart;


    public RecommendDomain(String title, String pic, String description, double price) {
        this.title = title;
        this.pic = pic;
        this.description = description;
        this.price = price;
    }

    public RecommendDomain(String title, String pic, String description, double price, int numberInCart) {
        this.title = title;
        this.pic = pic;
        this.description = description;
        this.price = price;
        this.numberInCart = numberInCart;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumberInCart() {
        return numberInCart;
    }

    public void setNumberInCart(int numberInCart) {
        this.numberInCart = numberInCart;
    }
}
