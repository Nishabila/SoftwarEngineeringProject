package com.example.almuhtazibah11.APplicationLayer;

import android.content.Context;


import com.example.almuhtazibah11.DAl.SignUpDAL;

public class SignUpAL  {

    Context mcontext;

    public SignUpAL(Context mcontext) {
        this.mcontext = mcontext;
    }


    public void insert(String name,String email,String phone, String password ) {

        SignUpDAL signUpDAL = new SignUpDAL(mcontext);
        signUpDAL.insertdata(name, email, phone, password);
    }
}


