package com.example.almuhtazibah11.DAl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.example.almuhtazibah11.APplicationLayer.CustomCart;

import java.util.ArrayList;
import java.util.List;

public class CartLocalDAL extends SQLiteOpenHelper {

    //Database version
    private static final int DATABASE_VERSION = 1;
    //Database Name
    private static final String DATABASE_NAME = "employee_database";
    //Database Table name
    private static final String TABLE_NAME = "EMPLOYEE";
    //Table columns

    private static final String KEY_USERINFO_Id = "Id";
    private static final String KEY_USERINFO_NAMW = "name";
    private static final String KEY_USERINFO_price = "price";
    private static final String KEY_USERINFO_color = "color";
    //
    private static final String KEY_USERINFO_size= "size";
    private static final String KEY_USERINFO_length = "length";
    private static final String KEY_USERINFO_pddid = "productid";


    private SQLiteDatabase sqLiteDatabase;


    //creating table query
    private static final String CREATE_TABLE = "create table " + TABLE_NAME +"("
            +KEY_USERINFO_Id+ " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + KEY_USERINFO_pddid + " TEXT NOT NULL,"
            + KEY_USERINFO_NAMW + " TEXT NOT NULL,"
            +KEY_USERINFO_price + " TEXT NOT NULL,"
            + KEY_USERINFO_size + " TEXT NOT NULL,"
            + KEY_USERINFO_length + " TEXT NOT NULL,"
            +KEY_USERINFO_color+" TEXT NOT NULL);";
    //Constructor
    public CartLocalDAL(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    public void addCart(CustomCart cART){
        ContentValues contentValues = new ContentValues();
        contentValues.put( CartLocalDAL.KEY_USERINFO_Id,cART.getId());
        contentValues.put(CartLocalDAL.KEY_USERINFO_pddid, cART.getPdid());
        contentValues.put(CartLocalDAL.KEY_USERINFO_NAMW, cART.getName());
        contentValues.put(CartLocalDAL.KEY_USERINFO_price, cART.getPrice());
        contentValues.put(CartLocalDAL.KEY_USERINFO_size, cART.getSize());
        contentValues.put(CartLocalDAL.KEY_USERINFO_color, cART.getColor());
        contentValues.put(CartLocalDAL.KEY_USERINFO_length, cART.getLENGTH());

        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(CartLocalDAL.TABLE_NAME, null,contentValues);
    }

    public List<CustomCart> getCartList(){
        String sql = "select * from " + TABLE_NAME;
        sqLiteDatabase = this.getReadableDatabase();
        List<CustomCart> storeCart = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);
        if (cursor.moveToFirst()){
            do {
                int id = Integer.parseInt(cursor.getString(0));
                String pid = cursor.getString(1);
                String name = cursor.getString(2);
                String price = cursor.getString(3);
                String size = cursor.getString(4);
                String color = cursor.getString(5);
                String length = cursor.getString(6);
                storeCart.add(new CustomCart(id,pid,name,price,size,color,length));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return storeCart;
    }


    public void deleteEmployee(int id){
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(TABLE_NAME, KEY_USERINFO_Id + " = ? ", new String[]
                {String.valueOf(id)});
    }
    public  void deleteAll(){
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.execSQL("delete from "+ TABLE_NAME);
        sqLiteDatabase.close();
    }
}