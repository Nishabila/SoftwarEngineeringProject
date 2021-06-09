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
import com.example.almuhtazibah11.CustomerDashboard;
import com.example.almuhtazibah11.PresentationLayer.DahboardUIPL;
import com.example.almuhtazibah11.PresentationLayer.LoginUIPL;

import java.util.HashMap;
import java.util.Map;

import static com.example.almuhtazibah11.PresentationLayer.LoginUIPL.sp2;

public class LoginDAL {

    public static String IsLoggin;
    Context context;

    public LoginDAL(Context context) {
        this.context = context;
    }



    String validate;
    public void  logindata(String username,String Password) {
        String loginUrl = "https://almuhtazibah.000webhostapp.com/login_maker.php";
        String TAG = LoginUIPL.class.getSimpleName();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, loginUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

               validate=response;
                if (validate.endsWith("found")) {

                    Toast.makeText(context, "Welcome to Al Muntazibah As a Customer", Toast.LENGTH_SHORT).show();
                    sp2.edit().putBoolean("logged",true).apply();
                    IsLoggin="LoggdIN";
                    Intent i = new Intent(context, CustomerDashboard.class);
                    context.startActivity(i);
                } else {
                    Intent logint = new Intent(context, DahboardUIPL.class);
                    context.startActivity(logint);
                    Toast.makeText(context, "please Sign In First!!", Toast.LENGTH_SHORT).show();

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(context, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {

            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parameters = new HashMap<String, String>();


                parameters.put("customer_email",username);

                parameters.put("password", Password);


                return parameters;
            }

        };
      Singleton_RequestQueueInsertData.getInstance(context).addToRequestQueue(stringRequest, TAG);

    }

}
