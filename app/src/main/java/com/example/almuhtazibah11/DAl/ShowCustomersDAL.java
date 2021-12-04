package com.example.almuhtazibah11.DAl;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.almuhtazibah11.APplicationLayer.CustomerModel;
import com.example.almuhtazibah11.APplicationLayer.CustomerDetailsAdapterAL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ShowCustomersDAL {
   Context context;
     List<CustomerModel> customerList;
    CustomerDetailsAdapterAL viewAdapter;

    public ShowCustomersDAL (Context context, List<CustomerModel> customerList) {
        this.context = context;
        this.customerList = customerList;
    }


    public void loadCustomerdata(RecyclerView recyclerView){
        customerList=new ArrayList<>();
       final String URL_Customer_details = "https://almuhtazibah.000webhostapp.com/customer_details.php";
        StringRequest stringRequest=new StringRequest(Request.Method.GET, URL_Customer_details, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try{
                    JSONArray array=new JSONArray(response);
                    for (int i=0; i<array.length(); i++) {
                        JSONObject ob = array.getJSONObject(i);
                        customerList.add(new CustomerModel(
                                ob.getInt("User_id"),
                                ob.getString("Full_name"),
                                ob.getString("customer_email"),
                                ob.getString("Mobile_no")
                        ));
                    }
                    viewAdapter=new CustomerDetailsAdapterAL(context,customerList);

                    recyclerView.setLayoutManager(new LinearLayoutManager(context));
                    recyclerView.setAdapter(viewAdapter);
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
