package com.example.almuhtazibah11.APplicationLayer;

import android.content.Context;

import com.example.almuhtazibah11.DAl.AddProductDAL;

public class ADDProductAL {
    Context context;
    public ADDProductAL(Context context) {
        this.context = context;
    }


    public void addproduct(String name,String pcolor,String price,String description,String imgurl) {
        AddProductDAL addProductDAL = new AddProductDAL(context);
        addProductDAL.uploaddatatodb(name, pcolor, price, description, imgurl);
    }
}
