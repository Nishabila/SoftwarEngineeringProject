package com.example.almuhtazibah11.PresentationLayer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.almuhtazibah11.R;
import com.example.almuhtazibah11.APplicationLayer.SignUpAL;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SignUpUIPL extends AppCompatActivity {
    EditText name,email,phone,password;
    Button signUp;
    boolean b;
    String signpassSt,signEmailSt,textvalidate,signNameSt,signPhoneSt;
   SignUpAL signUpAL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_u_i_p_l);


        signUp= findViewById(R.id.sign_up_button);
        name = findViewById(R.id.ed_SignUPfullname);
        email = findViewById(R.id.ed_SignUPemail);
        phone = findViewById(R.id.ed_SignUPPhone);
        password = findViewById(R.id.ed_SignUPpass);

       signUpAL=new SignUpAL(this);
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

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(name.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Enter Full Name", Toast.LENGTH_SHORT).show();
                }
                else if(email.getText().toString().equals("")){
                    Toast.makeText(SignUpUIPL.this, "Enter Email Address", Toast.LENGTH_SHORT).show();

                }
                else if(phone.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "EnterMobile Number", Toast.LENGTH_SHORT).show();

                }

                else if(password.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Enter Valid Password", Toast.LENGTH_SHORT).show();

                }

                else {
                    signNameSt= name.getText().toString().trim();
                    signEmailSt= email.getText().toString().trim();
                    signPhoneSt=phone.getText().toString().trim();
                    signpassSt=password.getText().toString().trim();
                 signUpAL.insert(signNameSt, signEmailSt,signPhoneSt,signpassSt);
                 finish();
                    name.setText("");
                    email.setText("");
                    phone.setText("");
                    password.setText("");

                }

            }
        });

       //finish();
    }



}