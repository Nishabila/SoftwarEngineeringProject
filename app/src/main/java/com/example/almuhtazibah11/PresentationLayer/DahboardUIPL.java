package com.example.almuhtazibah11.PresentationLayer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.almuhtazibah11.LoginOwner;
import com.example.almuhtazibah11.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DahboardUIPL extends AppCompatActivity {
    Button owner,customer,signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dahboard);
        owner = findViewById(R.id.owner_log_in);
        customer = findViewById(R.id.customer_log_in);
        signup=findViewById(R.id.signUpGobtn);


        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.dashboard);
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
                        return true;
                    case R.id.reviews10:
                        startActivity(new Intent(getApplicationContext(), DisplayReviewUIPL.class));
                        overridePendingTransition(0,0);
                        return true;

                }
                return false;
            }
        });



        owner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent io = new Intent(getApplicationContext(), LoginOwner.class);
                io.putExtra("ownerPassd","Owner");
                startActivity(io);
            }
        });

        customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ic = new Intent(getApplicationContext(), LoginUIPL.class);
                startActivity(ic);
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent is = new Intent(getApplicationContext(), SignUpUIPL.class);
                startActivity(is);
            }
        });
    }
}