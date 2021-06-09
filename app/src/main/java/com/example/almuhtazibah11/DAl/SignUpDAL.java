package com.example.almuhtazibah11.DAl;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.almuhtazibah11.APplicationLayer.Singleton_RequestQueueInsertData;
import com.example.almuhtazibah11.PresentationLayer.LoginUIPL;

import java.util.HashMap;
import java.util.Map;

public class SignUpDAL {
    Context context;

    private static String TAG = SignUpDAL.class.getSimpleName();
    public SignUpDAL(Context context) {
        this.context = context;
    }


    public void insertdata(String name,String email,String phone, String password){
        String signUpUrl="https://almuhtazibah.000webhostapp.com/sign_up.php";
        StringRequest stringRequest =new StringRequest(Request.Method.POST, signUpUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                String ab=response;
                if(ab.equals("success")){
                    context.startActivity( new Intent(context, LoginUIPL.class));

                    Toast.makeText(context," Welcome to the AlMuhtazibah system",Toast.LENGTH_LONG).show();
                     }
                if(ab.endsWith("taken")){
                    Toast.makeText(context,"Wrong Email Address or Account created using this email!!",Toast.LENGTH_LONG).show();

                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(context, error.getMessage(), Toast.LENGTH_SHORT).show();


            }
        }){

            protected Map<String,String> getParams() throws AuthFailureError {
                Map<String, String> parameters = new HashMap<String, String>();

                parameters.put("Full_name",name);
                parameters.put("customer_email",email);
                parameters.put("Mobile_no",phone);
                parameters.put("password",password);


                return parameters;
            }

        };
        Singleton_RequestQueueInsertData.getInstance(context).addToRequestQueue(stringRequest,TAG);


    }
}
