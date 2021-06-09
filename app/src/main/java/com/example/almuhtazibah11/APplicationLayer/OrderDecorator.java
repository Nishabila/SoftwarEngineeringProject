package com.example.almuhtazibah11.APplicationLayer;

public abstract class OrderDecorator implements Order {

    protected Order temOrder;


    OrderDecorator(Order temOrder){
        this.temOrder=temOrder;
    }
    @Override
    public String getOption(){
        return temOrder.getOption();
    }

    @Override
    public String getDescription(){
        return temOrder.getDescription();
    }
}
