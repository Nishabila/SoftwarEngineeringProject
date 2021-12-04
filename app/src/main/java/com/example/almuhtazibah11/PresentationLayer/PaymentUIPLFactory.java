package com.example.almuhtazibah11.PresentationLayer;

import com.example.almuhtazibah11.APplicationLayer.BikashDecorator;
import com.example.almuhtazibah11.APplicationLayer.CashOnDeliveryDecorator;
import com.example.almuhtazibah11.APplicationLayer.CourrierDecorator;
import com.example.almuhtazibah11.APplicationLayer.OrderDecorator;
import com.example.almuhtazibah11.APplicationLayer.OrderProductConcrete;
import com.example.almuhtazibah11.APplicationLayer.creditDecorator;

public class PaymentUIPLFactory {

  public OrderDecorator getDecoratorCLs(int a,int b){
        if(a==1 && b==1){
            return new CashOnDeliveryDecorator(new BikashDecorator(new OrderProductConcrete()));
        }

     else  if (a == 1 && b == 2) {
          return new CourrierDecorator(new BikashDecorator(new OrderProductConcrete()));

      } else if (a == 2 && b == 1) {
          return  new CashOnDeliveryDecorator(new creditDecorator(new OrderProductConcrete()));

      } else {
          return new CourrierDecorator(new creditDecorator(new OrderProductConcrete()));

      }

  }
}
