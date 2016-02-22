package com.example.mowolfvillageon.fridgev1;

import com.firebase.client.Firebase;

public class StarterApplication extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
        // other setup code
    }
}
