package com.example.almuhtazibah11.APplicationLayer;

import com.example.almuhtazibah11.DAl.OrderProductsDAL;

public class OrderProductConcrete implements Order {
    @Override
    public String getOption() {
        return "Order options are: ";
    }

    @Override
    public String getDescription() {
        return "Description: ";
    }

    @Override
    public void insertorder(String customer_email, String name, String price, String size, String length, String pcolor, String proof, String pauO, String deliO, String text) {

    }

}
