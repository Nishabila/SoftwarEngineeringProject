package com.example.almuhtazibah11.APplicationLayer;

import android.os.Handler;

import java.util.ArrayList;

import static com.example.almuhtazibah11.DAl.OrderProductsDAL.notifyOwners;


public class SubjectConcreteClass implements Subject {
    private String orderNotify;

    private static SubjectConcreteClass getInstance = null;

    private ArrayList<Observer> memberOfObservers;

    private SubjectConcreteClass() {
        memberOfObservers= new ArrayList<>();
        getNewDataFromRemote();
    }


    private void getNewDataFromRemote() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                setUserData(notifyOwners);
            }
        }, 10000);
    }

    //  a Singleton of the class
    public static SubjectConcreteClass getInstance() {
        if(getInstance == null) {
            getInstance = new SubjectConcreteClass();
        }
        return getInstance;
    }

    @Override
    public void registerObserver(Observer observer) {
        if(!memberOfObservers.contains(observer)) {
            memberOfObservers.add(observer);
        }
    }


//........For Notifying every Owners
    @Override
    public void notifyObservers() {
        for (Observer observer: memberOfObservers) {
            observer.onUserDataChanged(orderNotify);
        }
    }

    public void setUserData(String orderNotify) {
       this.orderNotify=orderNotify;

        notifyObservers();
    }
}
