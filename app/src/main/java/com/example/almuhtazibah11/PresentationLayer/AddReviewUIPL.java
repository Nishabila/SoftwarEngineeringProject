package com.example.almuhtazibah11.PresentationLayer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.almuhtazibah11.APplicationLayer.AddReviewBL;
import com.example.almuhtazibah11.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AddReviewUIPL extends AppCompatActivity {
    EditText rstatusName,rcomment;
    Button savebtn;
    RatingBar rateReview;
    String rating;
    String email,cmnt;
   AddReviewBL addReviewBL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        rateReview = (RatingBar) findViewById(R.id.reviewRatingBarS);

        rstatusName=findViewById(R.id.ed_emailAddressRVcs);
        rcomment=findViewById(R.id.reviewcomment);

        savebtn=findViewById(R.id.reviewsetCRS);
        addReviewBL=new AddReviewBL(this);
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
                        startActivity(new Intent(getApplicationContext(), DashboardUIPL.class));
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

        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 email=rstatusName.getText().toString();
                cmnt= rcomment.getText().toString();
                rating = String.valueOf(rateReview.getRating());
               addReviewBL.addreview(email,cmnt, rating);
                Toast.makeText(getApplicationContext(), "Thank You for"  + rating +"star ratings", Toast.LENGTH_LONG).show();
                rstatusName.setText("");
                rcomment.setText("");
            }
        });
    }
}