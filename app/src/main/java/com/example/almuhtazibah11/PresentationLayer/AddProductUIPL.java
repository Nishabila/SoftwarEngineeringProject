package com.example.almuhtazibah11.PresentationLayer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.almuhtazibah11.APplicationLayer.ADDProductAL;
import com.example.almuhtazibah11.APplicationLayer.Product;
import com.example.almuhtazibah11.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.textfield.TextInputEditText;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class AddProductUIPL extends AppCompatActivity {
    TextInputEditText name,color,price,description;
    Button save,upload_img;
    ImageView img;
    Bitmap bitmap;
    String encodeImageString;
    String string_name, string_color,string_price, string_description;

    ADDProductAL addProductAL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_product);

        img=(ImageView)findViewById(R.id.product_image);
        upload_img=(Button)findViewById(R.id.upload_img);
        save=(Button)findViewById(R.id.save);
        name= (TextInputEditText) findViewById(R.id.product_name);
        color= (TextInputEditText) findViewById(R.id.color);
        price= (TextInputEditText) findViewById(R.id.price);
        description= (TextInputEditText) findViewById(R.id.description);
        addProductAL=new ADDProductAL(this);


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



        upload_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dexter.withActivity(AddProductUIPL.this)
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse response)
                            {
                                Intent intent=new Intent(Intent.ACTION_PICK);
                                intent.setType("image/*");
                                startActivityForResult(Intent.createChooser(intent,"Browse Image"),1);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse response) {

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                                token.continuePermissionRequest();
                            }
                        }).check();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 string_name=name.getText().toString().trim();
                 string_color=color.getText().toString().trim();
                 string_price=price.getText().toString().trim();
                string_description=description.getText().toString().trim();
                addProductAL.addproduct(string_name,string_color,string_price,string_description,encodeImageString);
                name.setText("");
                color.setText("");
                price.setText("");
                description.setText("");

                img.setImageResource(R.drawable.ic_launcher_foreground);
                startActivity(new Intent(getApplicationContext(), Product.class));
                finish();
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        if(requestCode==1 && resultCode==RESULT_OK)
        {
            Uri filepath=data.getData();
            try
            {
                InputStream inputStream=getContentResolver().openInputStream(filepath);
                bitmap= BitmapFactory.decodeStream(inputStream);
                img.setImageBitmap(bitmap);
                //encodeBitmapImage(bitmap);
                ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
                byte[] bytesofimage=byteArrayOutputStream.toByteArray();
                encodeImageString=android.util.Base64.encodeToString(bytesofimage, Base64.DEFAULT);
            }catch (Exception ex)
            {

            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }



}