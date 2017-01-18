package com.dove.flyer.demo2;

import android.widget.Toast;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

/**
 * Created by punchh_sahir on 14/01/17.
 */

public class ToastCustomModule extends ReactContextBaseJavaModule {

    public ToastCustomModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "CustomToast";
    }

    @ReactMethod
    public void showMessage() {
        finish();
        Toast.makeText(getReactApplicationContext(), "message", Toast.LENGTH_LONG).show();
    }

    public void finish() {
        MainReactActivity activity = (MainReactActivity) getCurrentActivity();
        if (activity != null) {
            activity.myMethod("message");
        }
    }


}
