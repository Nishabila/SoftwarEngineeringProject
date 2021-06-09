package com.example.almuhtazibah11.APplicationLayer;



public class CustomerModel {

    public int getcId() {
        return cId;
    }

    private int  cId;
    private  String cname;


    public String getCname() {
        return cname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    private String email;
    private String phoneNumber;

    public CustomerModel(int cId, String cname, String email, String phoneNumber) {
        this.cId = cId;
        this.cname = cname;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }




}
