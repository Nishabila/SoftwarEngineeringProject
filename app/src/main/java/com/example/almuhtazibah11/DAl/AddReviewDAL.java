package com.example.almuhtazibah11.DAl;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.almuhtazibah11.PresentationLayer.AddReviewUIPL;
import com.example.almuhtazibah11.APplicationLayer.Singleton_RequestQueueInsertData;
import com.example.almuhtazibah11.PresentationLayer.CustomerDashboardUIPL;

import java.util.HashMap;
import java.util.Map;

public class AddReviewDAL {
    public AddReviewDAL(Context context) {
        this.context = context;
    }

    Context context;
   public void insertReviewData(String email,String cmnt,String rating) {
        String insertReviewURL = "https://almuhtazibah.000webhostapp.com/addReview.php";
        String TAG = AddReviewUIPL.class.getSimpleName();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, insertReviewURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                Toast.makeText(context, response, Toast.LENGTH_SHORT).show();
                context.startActivity(new Intent(context, CustomerDashboardUIPL.class));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> parameters = new HashMap<String, String>();

                parameters.put("customer_email", email);
                parameters.put("comment", cmnt);
                parameters.put("review_value", rating);
                return parameters;
            }
        };

       Singleton_RequestQueueInsertData.getInstance(context).addToRequestQueue(stringRequest,TAG);
    }
}
