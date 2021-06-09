package com.example.almuhtazibah11.APplicationLayer;

import android.content.Context;

import com.example.almuhtazibah11.DAl.AddReviewDAL;

public class AddReviewBL{
    public AddReviewBL(Context context) {
        this.context = context;
    }

    Context context;

    public void addreview(String email, String comnt, String rating) {
        AddReviewDAL addReviewDAL=new AddReviewDAL(context);
        addReviewDAL.insertReviewData(email,comnt,rating);
    }
}
