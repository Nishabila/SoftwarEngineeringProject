package com.example.almuhtazibah11.PresentationLayer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.almuhtazibah11.APplicationLayer.CartAdapterAL;
import com.example.almuhtazibah11.APplicationLayer.CustomCart;
import com.example.almuhtazibah11.DAl.CartLocalDAL;
import com.example.almuhtazibah11.DAl.LoginDAL;
import com.example.almuhtazibah11.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;



public class ShoppingCartUIPL extends AppCompatActivity {
    String Productnames, productColors, productSizes, ProductLengths, productPrice;
    int total = 0;
    TextView itemnum, totaotk;
    Button checkOutbtn;
    RecyclerView recyclerView;
    List<CustomCart> cartModelClasses;
    CartLocalDAL databaseHelperClass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);
        itemnum = findViewById(R.id.totalItemCount);
        totaotk = findViewById(R.id.totaltkCount);
        checkOutbtn = findViewById(R.id.checkoutcart);
        databaseHelperClass = new CartLocalDAL(this);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.cart);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), ProductUIPL.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.cart:
                        return true;
                    case R.id.dashboard:
                        startActivity(new Intent(getApplicationContext(), DashboardUIPL.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.reviews10:
                        startActivity(new Intent(getApplicationContext(), DisplayReviewUIPL.class));
                        overridePendingTransition(0, 0);
                        return true;

                }
                return false;
            }
        });


        recyclerView = findViewById(R.id.listView1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        showDataAtListView();

        itemnum.setText(String.valueOf(cartModelClasses.size()));
        totaotk.setText(productPrice);
        checkOutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    if (LoginDAL.stateC) {
                        Intent i = new Intent(getApplicationContext(), PaymentUIPL.class);
                        i.putExtra("ProductName", Productnames);
                        i.putExtra("ProductColor", productColors);
                        i.putExtra("ProductSize", productSizes);
                        i.putExtra("ProductLength", ProductLengths);
                        i.putExtra("ProductPrice", productPrice);
                        databaseHelperClass.deleteAll();
                        startActivity(i);
                    } else
                        Toast.makeText(getApplicationContext(), "Please LOG IN First!!!", Toast.LENGTH_LONG).show();

            }

        });
    }

    private void showDataAtListView() {
        StringBuffer sb = new StringBuffer();
        StringBuffer sbcolor = new StringBuffer();
        StringBuffer sbsize = new StringBuffer();
        StringBuffer sblength = new StringBuffer();


       // CartLocalDAL databaseHelperClass = new CartLocalDAL(this);
        cartModelClasses = databaseHelperClass.getCartList();

        if (cartModelClasses.size() > 0) {
            CartAdapterAL cartadapterclass = new CartAdapterAL(cartModelClasses, ShoppingCartUIPL.this);
            recyclerView.setAdapter(cartadapterclass);

            for (int i = 0; i < cartModelClasses.size(); i++) {
                total += Integer.valueOf(cartModelClasses.get(i).getPrice());
                sb.append(cartModelClasses.get(i).getName());
                sb.append(",");
                sbcolor.append(cartModelClasses.get(i).getColor());
                sbcolor.append(",");
                sbsize.append(cartModelClasses.get(i).getSize());
                sbsize.append(",");
                sblength.append(cartModelClasses.get(i).getLENGTH());
                sblength.append(",");
            }
        } else {
            Toast.makeText(this, "There is no product in the cart", Toast.LENGTH_SHORT).show();
        }


        Productnames = sb.toString();
        productColors = sbcolor.toString();
        productSizes = sbsize.toString();
        ProductLengths = sblength.toString();

        productPrice = String.valueOf(total);
    }
}


