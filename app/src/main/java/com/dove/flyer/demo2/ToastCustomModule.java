package com.dove.flyer.demo2;

import android.widget.Toast;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

/**
 * Created by punchh_sahir on 14/01/17.
 */

@ReactModule(name = "ToastCustomModule")
public class ToastCustomModule extends ReactContextBaseJavaModule {

    public ToastCustomModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "ToastCustomModule";
    }

    @ReactMethod
    public void showMessage(String message, Callback successCallback) {

        finish();
    /*    if(true)
        {
            successCallback.invoke("Message");
            Toast.makeText(getReactApplicationContext(), message, Toast.LENGTH_LONG).show();
        }else{
            errorCallback.invoke("Er Message");
        }*/
        String finalMsg = message +" Test "+" final message";

        Toast.makeText(getReactApplicationContext(), finalMsg, Toast.LENGTH_LONG).show();
        successCallback.invoke(finalMsg);

    }

    public void finish() {
        MainReactActivity activity = (MainReactActivity) getCurrentActivity();
        if (activity != null) {
            activity.myMethod("message");
        }
    }
}
