package com.example.almuhtazibah11.APplicationLayer;

import static com.example.almuhtazibah11.PresentationLayer.PaymentUIPL.cardExpString;
import static com.example.almuhtazibah11.PresentationLayer.PaymentUIPL.cardUserString;
import static com.example.almuhtazibah11.PresentationLayer.PaymentUIPL.cardnamestring;
import static com.example.almuhtazibah11.PresentationLayer.PaymentUIPL.cardnumString;

public class creditDecorator extends OrderDecorator {

    public creditDecorator(Order temOrder) {
        super(temOrder);
    }

    @Override
    public String getOption(){
        return temOrder.getOption()+" Credit Card &";
    }

    @Override
    public String getDescription(){
        String s1=cardnamestring;
        String s2=cardnumString;
        String s3=cardUserString;
        String s4=cardExpString;
        return temOrder.getDescription()+" Card Details Are:   Card Name:"+ s1+"  Card Number: "+s2+"  Card User Name: "+s3+"  Card Expiration Date: "+s4;
    }

    @Override
    public void insertorder(String customer_email, String name, String price, String size, String length, String pcolor, String proof, String pauO, String deliO, String text) {

    }
}