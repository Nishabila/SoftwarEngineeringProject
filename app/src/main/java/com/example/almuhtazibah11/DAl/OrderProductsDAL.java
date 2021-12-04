package com.example.almuhtazibah11.DAl;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.almuhtazibah11.APplicationLayer.Observer;
import com.example.almuhtazibah11.APplicationLayer.Singleton_RequestQueueInsertData;
import com.example.almuhtazibah11.APplicationLayer.Subject;
import com.example.almuhtazibah11.PresentationLayer.CustomerDashboardUIPL;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.HashMap;
import java.util.Map;

public class OrderProductsDAL implements Observer {
    private String customer_email, name,price,size,length,pcolor,proof,pauO,deliO,text ;
    private Subject orderData;
    String OrderID;
    Context context;

    public OrderProductsDAL(Context context,Subject orderData) {
        this.context = context;
        this.orderData=orderData;
        orderData.registerObserver(this);
    }

    public void insert(){
        String insertOrderDataURL ="https://almuhtazibah.000webhostapp.com/addOrder.php";
        String TAG =OrderProductsDAL.class.getSimpleName();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, insertOrderDataURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                OrderID=response;
                Toast.makeText(context, "Your Order ID is "+OrderID+" Please remember it to track", Toast.LENGTH_LONG).show();
                insertPayDeliveyInfo();
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

    public void insertPayDeliveyInfo() {

        String insertpDURL = "https://almuhtazibah.000webhostapp.com/addPaymentDelivery.php";
        String TAG =OrderProductsDAL.class.getSimpleName();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, insertpDURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(context, "You will recieve your Order wthin 2 weeks!!", Toast.LENGTH_LONG).show();
                String ab=response;
                if(ab.equals("Successfull")){
                    FirebaseMessaging.getInstance().subscribeToTopic("all");
                            OrderNotificationDAL notificationsSender=new OrderNotificationDAL("/topics/all","New Order","Customer Placed a new Order", context);
                            notificationsSender.SendNotifications();
                            context.startActivity( new Intent(context, CustomerDashboardUIPL.class));

                }

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

    @Override
    public void update(String customer_email, String name, String price, String size, String length, String pcolor, String proof,String pauO, String deliO, String text) {
        this.customer_email=customer_email;
        this.name=name;
        this.price=price;
        this.size=size;
        this.length=length;
        this.pcolor=pcolor;
        this.proof=proof;
        this.pauO=pauO;
        this.deliO=deliO;
        this.text=text;
        insert();
    }

}
