package com.example.almuhtazibah11.APplicationLayer;


public class ReviewModel {
    private int  rId;
    private  String email;
    private String value;

    public int getRId() {
        return rId;
    }

    public String getEmail() {
        return email;
    }

    public String getValue() {
        return value;
    }

    public String getCmt() {
        return cmt;
    }

    private String cmt;

    public ReviewModel(int rId, String email, String value, String cmt) {
        this.rId = rId;
        this.email = email;
        this.value = value;
        this.cmt = cmt;
    }










}
