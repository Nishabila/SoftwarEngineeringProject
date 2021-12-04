package com.example.almuhtazibah11.APplicationLayer;

import android.content.Context;

import com.example.almuhtazibah11.DAl.OrderProductsDAL;

import java.util.ArrayList;
import java.util.List;

public class OrderProductAL implements Order,Subject {
    private List<Observer> observerList;
    private String customer_email, name,price,size,length,pcolor,proof,pauO,deliO,text ;
    Context context;

    public OrderProductAL(Context context) {
        observerList=new ArrayList<Observer>();
        this.context = context;
    }
    @Override
    public String getOption() {
        return null;
    }
    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }
    @Override
    public void removeObserver(Observer observer) {
        int i=observerList.indexOf(observer);
        if(i>=0){
            observerList.remove(i);
        }
    }
    @Override
    public void notifyObservers() {
        for(Observer pdObservers:observerList){
            pdObservers.update( customer_email, name,price,size,  length,pcolor,proof,pauO,deliO,text); ;
        }

    }
    public void insertorder(String customer_email, String name, String price, String size, String length, String pcolor, String proof, String pauO, String deliO, String text)

    {
        OrderProductsDAL orderProductsDAL=new OrderProductsDAL(context,this);
        this.customer_email=customer_email;
        this.name=name;
        this.price=price;
        this.size=size;
        this.length=length;
        this.pcolor=pcolor;
        this.proof=proof;
        this.pauO=pauO;
        this.deliO=deliO;
        this.text=text;
        notifyObservers();
        
    }

}
