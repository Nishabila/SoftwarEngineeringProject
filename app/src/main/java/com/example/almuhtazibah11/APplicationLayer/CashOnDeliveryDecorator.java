package com.example.almuhtazibah11.APplicationLayer;


import static com.example.almuhtazibah11.PresentationLayer.PaymentUIPL.cashaddressString;

public class CashOnDeliveryDecorator extends OrderDecorator {

    public CashOnDeliveryDecorator(Order temOrder) {

        super(temOrder);
    }


    public String getOption() {
        return temOrder.getOption() + " Cash on Delivery";
    }

    @Override
    public String getDescription() {
        String sc=cashaddressString;

        return temOrder.getDescription() + " Delivery Address:"+sc;
    }

    @Override
    public void insertorder(String customer_email, String name, String price, String size, String length, String pcolor, String proof, String pauO, String deliO, String text) {

    }

}