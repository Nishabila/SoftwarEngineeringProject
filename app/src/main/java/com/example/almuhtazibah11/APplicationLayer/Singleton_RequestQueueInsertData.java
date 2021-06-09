package com.example.almuhtazibah11.APplicationLayer;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class Singleton_RequestQueueInsertData {


    private static Singleton_RequestQueueInsertData mAppSingleton1Instance = null;
    private RequestQueue mRequestQueue;
    private static Context mContext;

    private Singleton_RequestQueueInsertData(Context context) {
        mContext = context;
        mRequestQueue = getRequestQueue();
    }

    public static synchronized Singleton_RequestQueueInsertData getInstance(Context context) {
        if (mAppSingleton1Instance == null) {
            mAppSingleton1Instance = new Singleton_RequestQueueInsertData(context);
        }
        return mAppSingleton1Instance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            mRequestQueue = Volley.newRequestQueue(mContext.getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req, String tag) {
        req.setTag(tag);
        getRequestQueue().add(req);
    }


    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }



}
