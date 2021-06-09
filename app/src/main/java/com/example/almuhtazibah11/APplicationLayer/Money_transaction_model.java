package com.example.almuhtazibah11.APplicationLayer;

public class Money_transaction_model {




    private int user_id;

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    private int order_id;
    private  String p_name,p_price,paid;


    public Money_transaction_model(int order_id, int user_id, String p_name, String p_price, String paid) {
        this.order_id=order_id;
        this.user_id = user_id;
        this.p_name = p_name;
        this.p_price = p_price;
        this.paid = paid;
    }



    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getP_price() {
        return p_price;
    }

    public void setP_price(String p_price) {
        this.p_price = p_price;
    }

    public String getPaid() {
        return paid;
    }

    public void setPaid(String paid) {
        this.paid = paid;
    }



}
