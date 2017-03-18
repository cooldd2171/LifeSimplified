package com.example.shoie.lifesimplified;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by shoie on 3/11/2017.
 */

public class LifeSimplified extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
