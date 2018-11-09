package com.followanalytics.reactnative.sdk;

import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.followanalytics.FollowAnalytics;

public class RNFollowAnalyticsGDPR extends ReactContextBaseJavaModule  {
    private final ReactApplicationContext reactContext;

    public RNFollowAnalyticsGDPR(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "RNFollowAnalyticsGDPR";
    }

    @ReactMethod
    public void requestAccessToMyData() {
        try {
            FollowAnalytics.GDPR.requestToAccessMyData();
        } catch (Exception e) {
            Log.d("Error requesting access", "");
        }
    }

    @ReactMethod
    public void requestToDeleteMyData() {
        try {
            FollowAnalytics.GDPR.requestToDeleteMyData();
        } catch (Exception e) {
            Log.d("Error requesting access", "");
        }
    }
}
