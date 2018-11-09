package com.followanalytics.reactnative.sdk;

import android.util.Log;

import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.followanalytics.FollowAnalytics;

public class RNFollowAnalyticsDataWallet extends ReactContextBaseJavaModule {
    private final ReactApplicationContext reactContext;

    public RNFollowAnalyticsDataWallet(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "RNFollowAnalyticsDataWallet";
    }

    @ReactMethod
    public void getPolicy(Callback callback) {
        callback.invoke(null, FollowAnalytics.DataWallet.getPolicy());
    }

    @ReactMethod
    public void isRead(Callback callback) {
        callback.invoke(null, FollowAnalytics.DataWallet.isRead());
    }

    @ReactMethod
    public void setIsRead(Boolean isRead) {
        try {
            FollowAnalytics.DataWallet.setIsRead(isRead);
        } catch (Exception e) {
            Log.d("Unable to set isRead to", isRead.toString());
        }
    }

}
