package com.example.almuhtazibah11.APplicationLayer;

public interface Order {
    public String getOption();
    public String getDescription();
    public void insertorder(String customer_email, String name, String price, String size, String length, String pcolor, String proof, String pauO, String deliO, String text);

    }
