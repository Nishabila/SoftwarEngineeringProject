package com.example.almuhtazibah11.APplicationLayer;


import static com.example.almuhtazibah11.PresentationLayer.PaymentUIPL.bikashphonenum;

public class BikashDecorator extends OrderDecorator {


    public BikashDecorator(Order temOrder) {
        super(temOrder);
    }

    @Override
    public String getOption() {
        return temOrder.getOption()+" Bikash & ";
    }

    @Override
    public String getDescription() {
        String sb=bikashphonenum;
        return temOrder.getDescription()+"Bikash Number is: "+sb;
    }

    @Override
    public void insertorder(String customer_email, String name, String price, String size, String length, String pcolor, String proof, String pauO, String deliO, String text) {

    }

}

