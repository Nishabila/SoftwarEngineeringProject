package com.example.almuhtazibah11.PresentationLayer;

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

import com.example.almuhtazibah11.APplicationLayer.LoginAL;
import com.example.almuhtazibah11.CustomerDashboard;
import com.example.almuhtazibah11.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class LoginUIPL extends AppCompatActivity {

    private static String TAG = LoginUIPL.class.getSimpleName();
    EditText username;
    EditText password;
    Button loginbtn;
    String stUser, stPass;
    TextView textView;
    public   static SharedPreferences sp2;
    LoginAL loginAL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_customer);
        username = findViewById(R.id.ed_emailAddresscs);
        password = findViewById(R.id.ed_passlgcs);
        loginbtn = findViewById(R.id.logincs);
        textView = findViewById(R.id.customer_log_inTextcs);
      loginAL=new LoginAL(this);
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
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
        sp2 = getSharedPreferences("login",MODE_PRIVATE);
        if(sp2.getBoolean("logged",false)){
            goToDashBoard();
        }

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (username.getText().toString().equals("")) {
                    Toast.makeText(LoginUIPL.this, "Enter Email Address", Toast.LENGTH_SHORT).show();

                } else if (password.getText().toString().equals("")) {
                    Toast.makeText(LoginUIPL.this, "Enter Valid Password", Toast.LENGTH_SHORT).show();

                } else {

                    stUser = username.getText().toString().trim();
                    stPass = password.getText().toString().trim();
                  loginAL.login(stUser,stPass);
                    username.setText("");
                    password.setText("");
                }
            }
        });

    }



    public void goToDashBoard(){
        Intent i = new Intent(this, CustomerDashboard.class);
        startActivity(i);
        finish();
    }
}