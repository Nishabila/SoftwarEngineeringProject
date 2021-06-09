package com.example.almuhtazibah11.PresentationLayer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.almuhtazibah11.APplicationLayer.ReviewAdapterAL;
import com.example.almuhtazibah11.APplicationLayer.ReviewModel;
import com.example.almuhtazibah11.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class DisplayReviewUIPL extends AppCompatActivity {
    List<ReviewModel> reviewList;
    RecyclerView recyclerView;
    ReviewAdapterAL viewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_review);
        recyclerView=findViewById(R.id.reviewrecl3);


    viewAdapter=new ReviewAdapterAL(this,reviewList);

        //............Bottom Navigation...........

        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.reviews10);
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
                        return true;

                }
                return false;
            }
        });


        viewAdapter.showReviewdata(recyclerView);
    }
}