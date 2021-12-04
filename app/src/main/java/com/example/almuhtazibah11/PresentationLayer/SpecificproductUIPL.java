package com.example.almuhtazibah11.PresentationLayer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.almuhtazibah11.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.squareup.picasso.Picasso;

import static com.example.almuhtazibah11.PresentationLayer.ProductUIPL.EXTRA_PName;
import static com.example.almuhtazibah11.PresentationLayer.ProductUIPL.EXTRA_Pprice;
import static com.example.almuhtazibah11.PresentationLayer.ProductUIPL.EXTRA_URL;

public class SpecificproductUIPL extends AppCompatActivity {
    private static String TAG = SpecificproductUIPL.class.getSimpleName();
    ImageView productImg;
    TextView textProductName, productprice,productcolor,productDescription;
    Button hereButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specificproduct);
        productImg=findViewById(R.id.specificImg);

        textProductName =findViewById(R.id.pName);
        productprice=findViewById(R.id.pPrice);
        productcolor=findViewById(R.id.pColor);
        productDescription=findViewById(R.id.pdescription);
        hereButton=findViewById(R.id.addcartbtn2);


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
        order_customize();
    }

    private void order_customize() {
        Intent intent = getIntent();
        int id_auto = intent.getExtras().getInt("id");
        String id_st=String.valueOf(id_auto);
        String imageUrl = intent.getStringExtra(EXTRA_URL);
        String pName = intent.getStringExtra(EXTRA_PName);
        String price = intent.getStringExtra(EXTRA_Pprice);
        Picasso.get().load(imageUrl).into(productImg);
        textProductName.setText(pName);
        productprice.setText(price);
        hereButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(SpecificproductUIPL.this, CustomizeProductUIPL.class);
                i.putExtra("ids",id_st);
                i.putExtra("pnames", pName);
                i.putExtra("pprices", price);
                i.putExtra("pimgs", imageUrl);
                startActivity(i);

            }
        });


    }



}