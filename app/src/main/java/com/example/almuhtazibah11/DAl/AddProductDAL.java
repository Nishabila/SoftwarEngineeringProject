package com.example.almuhtazibah11.DAl;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.almuhtazibah11.R;

import java.util.HashMap;
import java.util.Map;

public class AddProductDAL {
    public AddProductDAL(Context context) {
        this.context = context;
    }

    Context context;
    public void uploaddatatodb(String  string_name,String string_color,String string_price,String  string_description,String encodeImageString) {
        String insert_product_url="https://almuhtazibah.000webhostapp.com/insert_product.php";
        StringRequest request=new StringRequest(Request.Method.POST, insert_product_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response)
            {


                Toast.makeText(context,response.toString(),Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context,error.toString(),Toast.LENGTH_LONG).show();
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError
            {
                Map<String,String> map=new HashMap<String, String>();
                map.put("product_name",string_name);
                map.put("product_color",string_color);
                map.put("product_price",string_price);
                map.put("product_description",string_description);
                map.put("Product_photo",encodeImageString);
                return map;
            }
        };


        RequestQueue queue= Volley.newRequestQueue(context);
        queue.add(request);
    }
}

