package com.example.almuhtazibah11.PresentationLayer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.almuhtazibah11.APplicationLayer.CustomCart;
import com.example.almuhtazibah11.DAl.CartLocalDAL;
import com.example.almuhtazibah11.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CustomizeProductUIPL extends AppCompatActivity {
    EditText edSize,edLength,edColor;
    Button cart;
    TextView textId,testname,textPrice;
    TextView lblmsg;
    String stColor,stLength,stSize,pname,pprice,pDid;
    int pid;

    String[] colorname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize_product);


        edSize=findViewById(R.id.ed_CpSize);
        edLength=findViewById(R.id.ed_CpLength);
        edColor=findViewById(R.id.ed_CpColor);
        textId=findViewById(R.id.cpid);
        testname=findViewById(R.id.cpname);
        textPrice=findViewById(R.id.cpPrice);
        lblmsg=findViewById(R.id.lblmsge);
        pDid=getIntent().getStringExtra("ids");
        pid=Integer.valueOf(pDid);
        pname=getIntent().getStringExtra("pnames");
        pprice=getIntent().getStringExtra("pprices");
        textId.setText(pDid);
        testname.setText(pname);
        textPrice.setText(pprice);
        cart=findViewById(R.id.btncart);
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
                        startActivity(new Intent(getApplicationContext(),DisplayReviewUIPL.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });


        Spinner spin = (Spinner) findViewById(R.id.spinner);
        Resources res= getResources();
        colorname=res.getStringArray(R.array.COLORNAME);
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,colorname);
        spin.setAdapter(aa);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //Toast.makeText(getApplicationContext(), ctgtananame[i], Toast.LENGTH_LONG).show();
                String DD = colorname[position];
                edColor.setText(DD);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                validate();
            }
        });


    }

    private void validate() {
        stColor = edColor.getText().toString();
        stLength = edLength.getText().toString();
        stSize = edSize.getText().toString();

        if (stColor.length() <=0 || stLength.length() <=0 || stSize.length() <=0){
            Toast.makeText(CustomizeProductUIPL.this, "Enter All Data", Toast.LENGTH_SHORT).show();
        }else {
            CartLocalDAL databaseHelperClass = new CartLocalDAL(CustomizeProductUIPL.this);
          CustomCart cartModelClass = new CustomCart(pDid,pname,pprice,stSize,stColor,stLength);
            databaseHelperClass.addCart(cartModelClass);
            textId.setText("");
            testname.setText("");
            textPrice.setText("");
            edSize.setText("");
            edLength.setText("");
            edColor.setText("");
            Toast.makeText(getApplicationContext(), "Add Cart Successfully", Toast.LENGTH_SHORT).show();
            finish();
            startActivity(getIntent());
        }
    }

}