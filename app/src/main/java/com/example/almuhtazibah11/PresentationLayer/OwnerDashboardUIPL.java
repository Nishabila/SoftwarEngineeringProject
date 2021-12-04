package com.example.almuhtazibah11.PresentationLayer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.almuhtazibah11.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;



public class OwnerDashboardUIPL extends AppCompatActivity  {
    Button btnUP, btnOrD,btntr,btnCD,logout,btnaddp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_dashboard);

        btnCD=findViewById(R.id.CSDetails);
        btnaddp=findViewById(R.id.pruductAdd);
        btnOrD=findViewById(R.id.ordrNt);
        btntr=findViewById(R.id.mnTranST);
        btnUP=findViewById(R.id.pruductUp);
        logout=findViewById(R.id.logoutONR);

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
        btntr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OwnerDashboardUIPL.this, MoneyTransecUIPL.class));
            }
        });

     btnaddp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), AddProductUIPL.class));
            }
        });

        btnOrD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             Intent iOD=new Intent(getApplicationContext(), OrderDetail2acUIPL.class);
                startActivity(iOD);
            }
        });
        btnCD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Intent iCD=new Intent(getApplicationContext(), CustomerInfoUIPL.class);
               startActivity(iCD);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginOwnerUIPL.stateO=false;
                startActivity(new Intent(getApplicationContext(),DahboardUIPL.class));
            }
        });
    }

}