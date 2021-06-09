package com.example.almuhtazibah11.APplicationLayer;


import static com.example.almuhtazibah11.PresentationLayer.PaymentUIPL.coureierAddsString;

public class CourrierDecorator extends OrderDecorator {

   public CourrierDecorator(Order temOrder) {
        super(temOrder);
    }
    @Override
    public String getOption(){
        return temOrder.getOption()+" Courrier";
    }

    @Override
    public String getDescription(){
        String sco=coureierAddsString;
        return temOrder.getDescription()+"  Address: "+sco;
    }

    @Override
    public void insertorder(String customer_email, String name, String price, String size, String length, String pcolor, String proof, String pauO, String deliO, String text) {

    }
}