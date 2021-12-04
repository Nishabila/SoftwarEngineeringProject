package com.example.almuhtazibah11.APplicationLayer;

public class Product {
    private int id;
    private String name;

    private String price;
    private String photo;

    public String getPhoto() {
        return photo;
    }



    public Product(int id, String name, String price, String photo) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public String getPrice() {
        return price;
    }













}
