package com.example.almuhtazibah11.PresentationLayer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.almuhtazibah11.PresentationLayer.AddReviewUIPL;
import com.example.almuhtazibah11.DAl.LoginDAL;
import com.example.almuhtazibah11.PresentationLayer.DahboardUIPL;
import com.example.almuhtazibah11.PresentationLayer.DisplayReviewUIPL;
import com.example.almuhtazibah11.PresentationLayer.ProductUIPL;
import com.example.almuhtazibah11.PresentationLayer.ShoppingCartUIPL;
import com.example.almuhtazibah11.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import static com.example.almuhtazibah11.PresentationLayer.LoginUIPL.sp2;

public class CustomerDashboardUIPL extends AppCompatActivity {
    Button btnOrdr, btnAddReviewt,logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_dashboard);
        btnAddReviewt=findViewById(R.id.reviewadd);

        logout=findViewById(R.id.logoutCS);


        //............Bottom Navigation...........
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), ProductUIPL.class));
                        overridePendingTransition(0,0);
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

        btnAddReviewt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rint=new Intent(getApplicationContext(), AddReviewUIPL.class);
                startActivity(rint);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginDAL.stateC=false;
                startActivity(new Intent(getApplicationContext(), DahboardUIPL.class));
            }
        });

    }



}