package com.example.almuhtazibah11.DAl;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;
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

import java.util.ArrayList;
import java.util.List;


public class ProductsDetailDAL  {

   Context ctx;
   List<Product> productList;
   ProductAdapterAL productAdapterAL;
    public ProductsDetailDAL(Context ctx, List<Product>productList) {
        this.ctx = ctx;
       this.productList=productList;
    }

    public void retrieve_product_data(RecyclerView rview1) {
        productList = new ArrayList<>();
        String URL_PRODUCTS = "http://almuhtazibah.000webhostapp.com/Get_product.php";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_PRODUCTS,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray array = new JSONArray(response);
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject product = array.getJSONObject(i);
                                productList.add(new Product(
                                        product.getInt("product_id"),
                                        product.getString("product_name"),
                                        product.getString("product_price"),
                                        product.getString("Product_photo")

                                ));
                            }
                            productAdapterAL= new ProductAdapterAL( ctx,productList);
                            rview1.setLayoutManager(new LinearLayoutManager(ctx));
                            rview1.setAdapter(productAdapterAL);


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
