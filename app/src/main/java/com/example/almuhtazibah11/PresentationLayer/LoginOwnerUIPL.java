package com.example.almuhtazibah11.PresentationLayer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.almuhtazibah11.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class LoginOwnerUIPL extends AppCompatActivity {
    EditText username, password;;
    Button loginbtn;
    String stUser, stPass,ownerpass;
    TextView textView;
    public static Boolean stateO=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_owner);
        username = findViewById(R.id.ed_emailAddressos);
        password = findViewById(R.id.ed_passlgos);
        loginbtn = findViewById(R.id.loginos);
        textView = findViewById(R.id.ownetTextos);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), ProductUIPL.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.cart:
                        startActivity(new Intent(getApplicationContext(), ShoppingCartUIPL.class));
                        overridePendingTransition(0, 0);
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


        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().equals("") || password.getText().toString().equals("")) {
                    Toast.makeText(LoginOwnerUIPL.this, "Enter All Field Correctly", Toast.LENGTH_SHORT).show();
                }  else {
                    if (username.getText().toString().trim().equalsIgnoreCase("admin@gmail.com") && password.getText().toString().trim().equalsIgnoreCase("admin")) {
                        username.setText("");
                        password.setText("");
                        startActivity(new Intent(getApplicationContext(), OwnerDashboardUIPL.class));
                        stateO=true;
                        Toast.makeText(getApplicationContext(), "Welcome as Owner", Toast.LENGTH_SHORT).show();
                        finish();

                    } else {
                        textView.setText("Please contact 018******* to know Owner Email Address & Password");
                        Toast.makeText(getApplicationContext(), "Invalid Owner", Toast.LENGTH_SHORT).show();

                    }

                }
            }
        });

    }


}