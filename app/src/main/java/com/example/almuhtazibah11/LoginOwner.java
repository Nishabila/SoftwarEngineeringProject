package com.example.almuhtazibah11;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.almuhtazibah11.PresentationLayer.DahboardUIPL;
import com.example.almuhtazibah11.PresentationLayer.DisplayReviewUIPL;
import com.example.almuhtazibah11.PresentationLayer.ProductUIPL;
import com.example.almuhtazibah11.PresentationLayer.ShoppingCartUIPL;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class LoginOwner extends AppCompatActivity {
    EditText username;
    EditText password;
    Button loginbtn;
    String stUser, stPass;
    String ownerpass;
    TextView textView;
    public static SharedPreferences sp;

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
                        startActivity(new Intent(getApplicationContext(), DahboardUIPL.class));
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

        sp = getSharedPreferences("login", MODE_PRIVATE);
        if (sp.getBoolean("logged", false)) {
            goToMainActivity();
        }

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (username.getText().toString().equals("")) {
                    Toast.makeText(LoginOwner.this, "Enter Email Address", Toast.LENGTH_SHORT).show();

                } else if (password.getText().toString().equals("")) {
                    Toast.makeText(LoginOwner.this, "Enter Valid Password", Toast.LENGTH_SHORT).show();

                } else {

                    stUser = username.getText().toString().trim();
                    stPass = password.getText().toString().trim();
                    if (stUser.equalsIgnoreCase("admin@gmail.com") && stPass.equalsIgnoreCase("admin")) {
                        username.setText("");
                        password.setText("");
                        ownerpass = "passed";
                        goToMainActivity();
                        Toast.makeText(getApplicationContext(), "Welcome as Owner", Toast.LENGTH_SHORT).show();

                    } else {
                        textView.setText("Please contact 018******* to know Owner Email Address & Password");
                        Toast.makeText(getApplicationContext(), "Invalid Owner", Toast.LENGTH_SHORT).show();

                    }
                    sp.edit().putBoolean("logged", true).apply();
                }
            }
        });

    }


    public void goToMainActivity() {
        Intent i = new Intent(this, OwnerDashboard.class);
        startActivity(i);
        finish();
    }
}