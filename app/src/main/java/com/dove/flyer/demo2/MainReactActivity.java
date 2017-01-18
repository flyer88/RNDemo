package com.dove.flyer.demo2;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;

import com.facebook.react.ReactActivity;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.shell.MainReactPackage;

import javax.annotation.Nullable;


public class MainReactActivity extends ReactActivity {
    private ReactRootView mReactRootView;
    private ReactInstanceManager mReactInstanceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mReactRootView = new ReactRootView(MainReactActivity.this);
        mReactInstanceManager = ReactInstanceManager.builder()
                .setApplication(getApplication())
                .setBundleAssetName("index.android.bundle")
                .setJSMainModuleName("index.android")
                .addPackage(new MainReactPackage())
               // .addPackage(new AnExampleReactPackage())
                .setUseDeveloperSupport(BuildConfig.DEBUG)
                .setInitialLifecycleState(LifecycleState.RESUMED)
                .setCurrentActivity(MainReactActivity.this)
                .build();
        mReactRootView.startReactApplication(mReactInstanceManager, "HelloWorld", null);
        setContentView(mReactRootView);
    }



    @Nullable
    @Override
    protected String getMainComponentName() {
        return super.getMainComponentName();
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

    public void senDataToReactNative() {
        try {
            WritableMap event = Arguments.createMap();
            event.putString("message", "MyMessage");
            //event.putArray();
            //ReactContext reactContext = (ReactContext) getContext();
            //reactContext.getJSModule(RCTEventEmitter.class).receiveEvent(getId("topChange", event);
        } catch (Exception ex) {

        }
    }

    public void myMethod(String message) {
        // Here we show a toast message
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        Log.e("sahir","sahir");
    }
}