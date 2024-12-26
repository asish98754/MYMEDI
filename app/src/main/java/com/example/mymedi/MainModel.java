package com.example.mymedi;

public class MainModel {

    String name,description,quantity,price,surl;

    MainModel()
    {


    }

    public MainModel(String name, String description, String quantity, String price, String surl) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.surl = surl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSurl() {
        return surl;
    }

    public void setSurl(String surl) {
        this.surl = surl;
    }
}
