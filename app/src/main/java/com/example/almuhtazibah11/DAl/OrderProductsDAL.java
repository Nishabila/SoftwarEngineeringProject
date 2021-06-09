package com.example.almuhtazibah11.DAl;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.almuhtazibah11.APplicationLayer.Singleton_RequestQueueInsertData;

import java.util.HashMap;
import java.util.Map;

public class OrderProductsDAL {
    public static String  notifyOwners;
    String OrderID;
    Context context;

    public OrderProductsDAL(Context context) {
        this.context = context;
    }

    public void insert(String customer_email,String name,String price,String size, String  length,String pcolor,String proof,String pauO,String deliO,String text ) {
        String insertOrderDataURL ="https://almuhtazibah.000webhostapp.com/addOrder.php";
        String TAG =OrderProductsDAL.class.getSimpleName();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, insertOrderDataURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                OrderID=response;
                insertPayDeliveyInfo(pauO,deliO,text);
                Toast.makeText(context, "Your Order ID is "+OrderID+" Please remember it to track", Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> param = new HashMap<String, String>();
                param.put("customer_email", customer_email);
                param.put("PName", name);
                param.put("pprice", price);
                param.put("psize", size);
                param.put("plength", length);
                param.put("pcolor", pcolor);
                param.put("proof_detail", proof);
                return param;
            }
        };
       Singleton_RequestQueueInsertData.getInstance(context).addToRequestQueue(stringRequest, TAG);
    }
    public void insertPayDeliveyInfo(String pauO,String deliO, String text) {

        String insertpDURL = "https://almuhtazibah.000webhostapp.com/addPaymentDelivery.php";
        String TAG =OrderProductsDAL.class.getSimpleName();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, insertpDURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                notifyOwners=OrderID;
                Toast.makeText(context, "You will recieve your Order wthin 2 weeks!!", Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> param = new HashMap<String, String>();
                param.put("Order_id",OrderID);
                param.put("Payment_method",pauO);
                param.put("Delivery_method",deliO);
                param.put("Description",text);

                return param;
            }
        };
        Singleton_RequestQueueInsertData.getInstance(context).addToRequestQueue(stringRequest, TAG);
    }

}
