package com.dove.flyer.demo2;

import android.widget.Toast;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

/**
 * Created by punchh_sahir on 14/01/17.
 */

@ReactModule(name = "ToastPunchh")
public class ToastPunchh extends ReactContextBaseJavaModule {

    public ToastPunchh(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "ToastPunchh";
    }

    @ReactMethod
    public void showMessage() {
        Toast.makeText(getReactApplicationContext(), "message", Toast.LENGTH_LONG).show();
    }
}
