package com.example.almuhtazibah11.DAl;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.almuhtazibah11.APplicationLayer.Product;
import com.example.almuhtazibah11.APplicationLayer.ProductAdapterAL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;


public class ProductsDetailDAL  {
    private static final String URL_PRODUCTS = "http://almuhtazibah.000webhostapp.com/Get_product.php";
   Context ctx;
   List<Product> list;
    public ProductsDetailDAL(Context ctx, List<Product>list) {
        this.ctx = ctx;
        this.list = list;
    }




    public void loadProducts( RecyclerView recyclerView) {


        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_PRODUCTS,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray array = new JSONArray(response);
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject product = array.getJSONObject(i);
                                list.add(new Product(
                                        product.getInt("product_id"),
                                        product.getString("product_name"),
//                                        product.getString("product_color"),
                                        product.getString("product_price"),
//                                        product.getString("product_description"),
                                        product.getString("Product_photo")

                                ));
                            }
                            ProductAdapterAL adapter = new ProductAdapterAL( ctx, list);
                           recyclerView.setAdapter(adapter);
                           // adapter.setOnItemClickListener(MainActivity.this::onItemClick);
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
        Volley.newRequestQueue(ctx).add(stringRequest);

    }


}
