package com.example.almuhtazibah11.APplicationLayer;

public class OrderDeteailModel {
    private int order_id;
    private String pname;
    private String pprice;
    private String pcolor;
    private String plength;
    private String psize;
    private String payProof;
    private String customer_email;
    private String deliviery_option;
    private String description;
    public OrderDeteailModel(int order_id, String pname, String pprice,
                             String pcolor, String plength, String psize, String payProof,
                             String customer_email, String deliviery_option, String description) {
        this.order_id = order_id;
        this.pname = pname;
        this.pprice = pprice;
        this.pcolor = pcolor;
        this.plength = plength;
        this.psize = psize;
        this.payProof = payProof;
        this.customer_email = customer_email;
        this.deliviery_option = deliviery_option;
        this.description = description;
    }
    public int getOrder_id() {
        return order_id;
    }

    public String getPname() {
        return pname;
    }

    public String getPprice() {
        return pprice;
    }

    public String getPcolor() {
        return pcolor;
    }

    public String getPlength() {
        return plength;
    }

    public String getPsize() {
        return psize;
    }

    public String getPayProof() {
        return payProof;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public String getDeliviery_option() {
        return deliviery_option;
    }

    public String getDescription() {
        return description;
    }









}
