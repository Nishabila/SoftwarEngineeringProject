package com.example.almuhtazibah11.APplicationLayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.almuhtazibah11.PresentationLayer.ProductUIPL;
import com.example.almuhtazibah11.R;

public class Home extends AppCompatActivity {
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashfile);
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Home.this, ProductUIPL.class);
                startActivity(intent);
                finish();
            }
        }, 2000);

    }

}