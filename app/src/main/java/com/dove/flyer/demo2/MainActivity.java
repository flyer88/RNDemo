package com.dove.flyer.demo2;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;

import com.facebook.react.LifecycleState;
import com.facebook.react.ReactActivity;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.react.uimanager.events.RCTEventEmitter;

import static java.security.AccessController.getContext;


public class MainActivity extends ReactActivity implements DefaultHardwareBackBtnHandler {
    private ReactRootView mReactRootView;
    private ReactInstanceManager mReactInstanceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mReactRootView = new ReactRootView(this);
        mReactInstanceManager = ReactInstanceManager.builder()
                .setApplication(getApplication())
                .setBundleAssetName("index.android.bundle")
                .setJSMainModuleName("index.android")
                .addPackage(new MainReactPackage())
                .setUseDeveloperSupport(BuildConfig.DEBUG)
                .setInitialLifecycleState(LifecycleState.RESUMED)
                .setCurrentActivity(MainActivity.this)

                //.setUseOldBridge(true) // uncomment this line if your app crashes
                .build();
        mReactRootView.startReactApplication(mReactInstanceManager, "HelloWorld", null);

        setContentView(mReactRootView);
    }

    @Override
    public void invokeDefaultOnBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onBackPressed() {
        if (mReactInstanceManager != null) {
            mReactInstanceManager.onBackPressed();
            Log.e("mReactInstanceManager", "Line 45");
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_MENU && mReactInstanceManager != null) {
            mReactInstanceManager.showDevOptionsDialog();
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }

 /*   public void senDataToReactNative() {
        try {
            WritableMap event = Arguments.createMap();
            event.putString("message", "MyMessage");
            //event.putArray();
            //ReactContext reactContext = (ReactContext) getContext();
            //reactContext.getJSModule(RCTEventEmitter.class).receiveEvent(getId("topChange", event);

        } catch (Exception ex) {

        }
    }*/

    public void myMethod(String message) {
        // Here we show a toast message
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        Log.e("sahir","sahir");
    }
}
