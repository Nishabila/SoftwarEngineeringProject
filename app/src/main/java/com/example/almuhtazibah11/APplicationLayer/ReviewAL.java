package com.example.almuhtazibah11.APplicationLayer;


public class ReviewAL {
    private int  rId;
    private  String email;
    private String value;
    private String cmt;
    public ReviewAL(int rId, String email, String value, String cmt) {
        this.rId = rId;
        this.email = email;
        this.value = value;
        this.cmt = cmt;
    }

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





}
