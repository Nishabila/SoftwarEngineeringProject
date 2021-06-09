package com.example.almuhtazibah11.DAl;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.almuhtazibah11.APplicationLayer.OrderDetailsAdapterAL;
import com.example.almuhtazibah11.APplicationLayer.OrderDeteailModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ShowOrderDetailsDAL {

    private List<OrderDeteailModel> orderdetailsList;
    Context context;

    public ShowOrderDetailsDAL(Context context, List<OrderDeteailModel> orderdetailsList) {
        this.context = context;
        this.orderdetailsList = orderdetailsList;
    }


    public void  showOrderdata(RecyclerView recyclerView){
        String URL_Order_details = "https://almuhtazibah.000webhostapp.com/getOrder.php";

        orderdetailsList=new ArrayList<>();
        StringRequest stringRequest=new StringRequest(Request.Method.GET, URL_Order_details, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try{
                    JSONArray array=new JSONArray(response);
                    for (int i=0; i<array.length(); i++) {
                        JSONObject ob = array.getJSONObject(i);
                        orderdetailsList.add(new OrderDeteailModel(
                                ob.getInt("Order_id"),
                                ob.getString("PName"),
                                ob.getString("pprice"),
                                ob.getString("pcolor"),
                                ob.getString("plength"),
                                ob.getString("psize"),
                                ob.getString("proof_detail"),
                                ob.getString("customer_email"),
                                ob.getString("Delivery_method"),
                                ob.getString("Description")
                        ));
                    }

                    OrderDetailsAdapterAL viewAdapter=new OrderDetailsAdapterAL(context,orderdetailsList);

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
