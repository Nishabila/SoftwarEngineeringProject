package com.example.almuhtazibah11.PresentationLayer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.almuhtazibah11.APplicationLayer.Order;
import com.example.almuhtazibah11.APplicationLayer.OrderProductAL;
import com.example.almuhtazibah11.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class PaymentUIPL extends AppCompatActivity implements View.OnClickListener {
    EditText bikashPhone, cardName, CardNUm, cardUser, cardExpire, cashAddress, courrierAddress,edproof,edusernm;
    Button bks, credit, orderbtn, cash, courrier, confirmbtn;
    TextView textView1, textView2;
    int x, y;
    String option, text,customer_email,proof,name,price,pcolor,size,length,OrderID,pauO,deliO;
    public static String bikashphonenum,cardnamestring,cardnumString,cardUserString,cardExpString,cashaddressString,coureierAddsString;
    Order pp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        bikashPhone = findViewById(R.id.ed_BikashPhone);
        cardName = findViewById(R.id.ed_CreditcardName);
        CardNUm = findViewById(R.id.ed_CreditcardNumber);
        cardUser = findViewById(R.id.ed_CreditcardUserName);
        cardExpire = findViewById(R.id.ed_CreditcardExpirationdate);
        cashAddress = findViewById(R.id.ed_CashOnAddress);
        courrierAddress = findViewById(R.id.ed_CourierAddress);
        edproof=findViewById(R.id.ed_payproof);
        edusernm=findViewById(R.id.ed_CsuserN);

        bks = findViewById(R.id.bikashbtn);
        credit = findViewById(R.id.CreditCard);
        confirmbtn = findViewById(R.id.paYconfirmbtn);
        orderbtn = findViewById(R.id.paYorderbtn);
        cash = findViewById(R.id.cashonhbtn);
        courrier = findViewById(R.id.courrierhbtn);

        bks.setOnClickListener(this);
        credit.setOnClickListener(this);
        confirmbtn.setOnClickListener(this);
        cash.setOnClickListener(this);
        courrier.setOnClickListener(this);
        orderbtn.setOnClickListener(this);

        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel=new NotificationChannel("My Notification","My Notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager=getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
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


        bikashPhone.setVisibility(View.GONE);
        cardName.setVisibility(View.GONE);
        CardNUm.setVisibility(View.GONE);
        cardUser.setVisibility(View.GONE);
        cardExpire.setVisibility(View.GONE);
        cashAddress.setVisibility(View.GONE);
        courrierAddress.setVisibility(View.GONE);
        edproof.setVisibility(View.GONE);
        edusernm.setVisibility(View.GONE);

        textView1 = findViewById(R.id.tex1);
        textView2 = findViewById(R.id.tx2);

        name=getIntent().getStringExtra("ProductName");
        price=getIntent().getStringExtra("ProductPrice");
        pcolor=getIntent().getStringExtra("ProductColor");
        size=getIntent().getStringExtra("ProductSize");
        length=getIntent().getStringExtra("ProductLength");


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bikashbtn) {
            bikashPhone.setVisibility(View.VISIBLE);
            credit.setEnabled(false);
            pauO="Bikash";
            x = 1;
        }
        if (v.getId() == R.id.CreditCard) {
            cardName.setVisibility(View.VISIBLE);
            CardNUm.setVisibility(View.VISIBLE);
            cardUser.setVisibility(View.VISIBLE);
            cardExpire.setVisibility(View.VISIBLE);
            pauO="Credit Card";
            bks.setEnabled(false);
            x = 2;
        }
        if (v.getId() == R.id.cashonhbtn) {
            cashAddress.setVisibility(View.VISIBLE);
            courrier.setEnabled(false);
            deliO="CashOn";
            y = 1;
        }
        if (v.getId() == R.id.courrierhbtn) {
            courrierAddress.setVisibility(View.VISIBLE);
            cash.setEnabled(false);
            deliO="Courrier";
            y = 2;
        }


        if (v.getId() == R.id.paYconfirmbtn) {

            bikashphonenum = bikashPhone.getText().toString();
            cardnamestring = cardName.getText().toString();
            cardnumString = CardNUm.getText().toString();
            cardUserString = cardUser.getText().toString();
            cardExpString = cardExpire.getText().toString();
            cashaddressString = cashAddress.getText().toString();
            coureierAddsString = courrierAddress.getText().toString();
        PaymentUIPLFactory paymentUIPLFactory=new PaymentUIPLFactory();
        pp=paymentUIPLFactory.getDecoratorCLs(x,y);
        option = pp.getOption();
        text = pp.getDescription();
            textView1.setText(option);
            textView2.setText(text);
            edusernm.setVisibility(View.VISIBLE);
            edproof.setVisibility(View.VISIBLE);

        }
        if (v.getId() == R.id.paYorderbtn) {
            customer_email=edusernm.getText().toString();
            proof=edproof.getText().toString();
            edproof.setText("");
            edusernm.setText("");
            confirm();
        }
    }


    private void confirm() {
        androidx.appcompat.app.AlertDialog.Builder alertDialogBuilde = new androidx.appcompat.app.AlertDialog.Builder(this);
        alertDialogBuilde.setMessage("Are you sure you want to Confirm Order?");

        alertDialogBuilde.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                        if(!customer_email.isEmpty()&& !proof.isEmpty()){
                           OrderProductAL pp=new OrderProductAL(PaymentUIPL.this);
                            pp.insertorder(customer_email, name,price,size,length,pcolor,proof,pauO,deliO,text);

                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "Please Enter All data", Toast.LENGTH_SHORT).show();

                        }

                    }
                });

        alertDialogBuilde.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                    }
                });

        androidx.appcompat.app.AlertDialog alertDialog = alertDialogBuilde.create();
        alertDialog.show();
    }


}