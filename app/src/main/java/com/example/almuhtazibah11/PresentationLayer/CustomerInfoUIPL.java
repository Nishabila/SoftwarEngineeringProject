package com.example.almuhtazibah11.PresentationLayer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.almuhtazibah11.APplicationLayer.CustomerDetailsAdapterAL;
import com.example.almuhtazibah11.APplicationLayer.CustomerModel;
import com.example.almuhtazibah11.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class CustomerInfoUIPL extends AppCompatActivity {
    List<CustomerModel> customerList;
    RecyclerView recyclerView;
    CustomerDetailsAdapterAL viewAdapter;
  CustomerDetailsAdapterAL customerDetailsAdapterAL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_info_u_i_p_l);
        recyclerView=findViewById(R.id.lstcd3);

       customerDetailsAdapterAL=new CustomerDetailsAdapterAL(this,customerList);
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


       customerDetailsAdapterAL.showCustomerwdata(recyclerView);

    }
}