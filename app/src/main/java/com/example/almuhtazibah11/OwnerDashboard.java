package com.example.almuhtazibah11;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.almuhtazibah11.APplicationLayer.Observer;
import com.example.almuhtazibah11.APplicationLayer.Subject;
import com.example.almuhtazibah11.APplicationLayer.SubjectConcreteClass;
import com.example.almuhtazibah11.PresentationLayer.AddProductUIPL;
import com.example.almuhtazibah11.PresentationLayer.CustomerInfoUIPL;
import com.example.almuhtazibah11.PresentationLayer.DahboardUIPL;
import com.example.almuhtazibah11.PresentationLayer.DisplayReviewUIPL;
import com.example.almuhtazibah11.PresentationLayer.MoneyTransecUIPL;
import com.example.almuhtazibah11.PresentationLayer.OrderDetail2acUIPL;
import com.example.almuhtazibah11.PresentationLayer.ProductUIPL;
import com.example.almuhtazibah11.PresentationLayer.ShoppingCartUIPL;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import static com.example.almuhtazibah11.LoginOwner.sp;

public class OwnerDashboard extends AppCompatActivity implements Observer {
    Button btnUP, btnOrD,btntr,btnCD,logout,btnaddp;

    private Subject subject;
    private TextView mTextViewNotification;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_dashboard);

        mTextViewNotification = (TextView) findViewById(R.id.tv_order);

        subject = SubjectConcreteClass.getInstance();
        subject.registerObserver(this);

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
                startActivity(new Intent(OwnerDashboard.this, MoneyTransecUIPL.class));
            }
        });

     btnaddp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), AddProductUIPL.class));
            }
        });
        btnUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /*Intent iup=new Intent(, UpdateProductsUIPL.class);
               startActivity(iup);*/
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
                goToMainActivity();
                sp.edit().putBoolean("logged",false).apply();
            }
        });
    }
    public void goToMainActivity(){
        Intent i = new Intent(this, DahboardUIPL.class);
        startActivity(i);

    }


    @Override
    public void onUserDataChanged(String orderNotify) {

        mTextViewNotification.setText("New Order Added!!\n new Order Id is "+ orderNotify );


    }
}