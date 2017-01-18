package com.dove.flyer.demo2;

import android.app.Activity;
import android.widget.Toast;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

/**
 * Created by punchh_sahir on 14/01/17.
 */

public class ToastPunchh extends ReactContextBaseJavaModule {

    public ToastPunchh(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "ToastAndroid";
    }

    @ReactMethod
    public void showMessage() {
        Toast.makeText(getReactApplicationContext(), "message", Toast.LENGTH_LONG).show();
    }

    public void finish() {
        MainActivity activity =  (MainActivity) getCurrentActivity();
        activity.myMethod("message");
        if (activity != null) {
            activity.finish();
        }
    }


}
