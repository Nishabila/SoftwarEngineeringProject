package com.example.almuhtazibah11.APplicationLayer;

import android.content.Context;

import com.example.almuhtazibah11.DAl.LoginDAL;

public class LoginAL {


    Context context;

    public LoginAL(Context context) {
        this.context = context;
    }

    public void login(String stUser,String stPass){
        LoginDAL loginDAL=new LoginDAL(context);
       loginDAL.logindata(stUser, stPass);

    }




}
