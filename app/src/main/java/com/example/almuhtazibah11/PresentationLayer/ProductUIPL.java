package com.example.almuhtazibah11.PresentationLayer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.almuhtazibah11.APplicationLayer.Product;
import com.example.almuhtazibah11.APplicationLayer.ProductAdapterAL;
import com.example.almuhtazibah11.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class ProductUIPL extends AppCompatActivity {
    RecyclerView rview1;
   ProductAdapterAL productAdapter;
    List<Product> productList;

    public static final String EXTRA_URL = "imageUrl";
    public static final String EXTRA_PName = "Name";
    public static final String EXTRA_Pprice = "price";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rview1 = findViewById(R.id.rview1);
        rview1.setHasFixedSize(true);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        rview1.setLayoutManager(staggeredGridLayoutManager);

        productList=new ArrayList<>();
      productAdapter = new ProductAdapterAL( this,  productList);

        //............Bottom Navigation...........
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.home:
                        return true;
                    case R.id.cart:
                       startActivity(new Intent(getApplicationContext(), ShoppingCartUIPL.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.dashboard:
                        startActivity(new Intent(getApplicationContext(), DahboardUIPL.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.reviews10:
                        startActivity(new Intent(getApplicationContext(), DisplayReviewUIPL.class));
                        overridePendingTransition(0,0);
                        return true;

                }
                return false;
            }
        });
      productAdapter.loadproducts(rview1);
    }

}