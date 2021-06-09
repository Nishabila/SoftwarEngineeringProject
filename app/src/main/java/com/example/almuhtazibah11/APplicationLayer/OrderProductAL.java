package com.example.almuhtazibah11.APplicationLayer;

import android.content.Context;

import com.example.almuhtazibah11.DAl.OrderProductsDAL;

public class OrderProductAL implements Order {
    public OrderProductAL(Context context) {
        this.context = context;
    }

    Context context;

    @Override
    public String getOption() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }

    public void insertorder(String customer_email, String name, String price, String size, String length, String pcolor, String proof, String pauO, String deliO, String text) {
        {
            OrderProductsDAL orderProductsDAL = new OrderProductsDAL(context);
            orderProductsDAL.insert(customer_email, name, price, size, length, pcolor, proof, pauO, deliO, text);

        }
    }
}
