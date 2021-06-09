package com.example.almuhtazibah11.DAl;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.almuhtazibah11.APplicationLayer.Money_transaction_adapterAL;
import com.example.almuhtazibah11.APplicationLayer.Money_transaction_model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ShowTransactionDAL {
    private static final String URL_PRODUCTS = "https://almuhtazibah.000webhostapp.com/view_money_transaction.php";


    private Context context;

    public ShowTransactionDAL(Context context, List<Money_transaction_model> money_transaction_model_list) {
        this.context = context;
        this.money_transaction_model_list = money_transaction_model_list;
    }

    private List<Money_transaction_model> money_transaction_model_list;

    public void showTransectionDetail(RecyclerView recyclerView) {
       money_transaction_model_list=new ArrayList<>();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_PRODUCTS,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            //converting the string to json array object
                            JSONArray array = new JSONArray(response);

                            //traversing through all the object
                            for (int i = 0; i < array.length(); i++) {

                                //getting product object from json array
                                JSONObject money_transaction = array.getJSONObject(i);

                                //adding the product to product list
                                money_transaction_model_list.add(new Money_transaction_model(
                                        money_transaction.getInt("Order_id"),
                                        money_transaction.getInt("User_id"),
                                        money_transaction.getString("PName"),
                                        money_transaction.getString("pprice"),
                                        money_transaction.getString("paid")

                                ));
                            }

                            //creating adapter object and setting it to recyclerview
                            Money_transaction_adapterAL adapter = new Money_transaction_adapterAL(context, money_transaction_model_list);
                            recyclerView.setAdapter(adapter);
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

        //adding our stringrequest to queue
        Volley.newRequestQueue(context).add(stringRequest);
    }


}
