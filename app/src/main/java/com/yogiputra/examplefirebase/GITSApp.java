package com.yogiputra.examplefirebase;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by yogi on 27/04/16.
 */
public class GITSApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
