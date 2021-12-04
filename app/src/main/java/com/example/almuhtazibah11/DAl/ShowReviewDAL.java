package com.example.almuhtazibah11.DAl;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.almuhtazibah11.APplicationLayer.ProductAdapterAL;
import com.example.almuhtazibah11.APplicationLayer.ReviewAdapterAL;
import com.example.almuhtazibah11.APplicationLayer.ReviewAL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ShowReviewDAL {
    Context context;
    List<ReviewAL> reviewList;
    ReviewAdapterAL reviewAdapterAL;
    public ShowReviewDAL(Context context, List<ReviewAL> reviewList) {
        this.context = context;
        this.reviewList = reviewList;
    }


    public void  showReviewdata(RecyclerView recyclerView){
        reviewList=new ArrayList<>();
         final String URL_Review_details = "http://almuhtazibah.000webhostapp.com/getReview.php";

        StringRequest stringRequest=new StringRequest(Request.Method.GET, URL_Review_details, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try{
                    JSONArray array=new JSONArray(response);
                    for (int i=0; i<array.length(); i++) {
                        JSONObject ob = array.getJSONObject(i);
                        reviewList.add(new ReviewAL(
                                ob.getInt("Review_id"),
                                ob.getString("customer_email"),
                                ob.getString("review_value"),
                                ob.getString("comment")
                        ));
                    }

                 reviewAdapterAL=new ReviewAdapterAL(context,reviewList);

                   recyclerView.setLayoutManager(new LinearLayoutManager(context));
                    recyclerView.setAdapter(reviewAdapterAL);
                    
                } catch (JSONException e) {
                    e.printStackTrace();

                }
            }
        },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        Volley.newRequestQueue(context).add(stringRequest);

    }


}
