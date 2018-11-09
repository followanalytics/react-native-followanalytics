package com.followanalytics.reactnative.sdk;

import android.util.Log;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.followanalytics.FollowAnalytics;

public class RNFollowAnalyticsPush extends ReactContextBaseJavaModule {
    private final ReactApplicationContext reactContext;

    public RNFollowAnalyticsPush(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "RNFollowAnalyticsPush";
    }

    @ReactMethod
    public void getAll(Callback callback) {
        try {
            callback.invoke(null, FollowAnalytics.Push.getAll());
        } catch (Exception e) {
            Log.d("Unable to get Push", e.getMessage());
        }
    }

    @ReactMethod
    public void get(String pushId, Callback callback) {
        try {
            callback.invoke(null, FollowAnalytics.Push.get(pushId));
        } catch (Exception e) {
            Log.d("Unable to get Push", e.getMessage());
        }
    }

    @ReactMethod
    public void markAsRead(String[] pushIds, Callback callback) {
        try {
            FollowAnalytics.Push.markAsRead(pushIds);
        } catch (Exception e) {
            Log.d("Unable to get Push", e.getMessage());
        }
    }

    @ReactMethod
    public void markAsUnread(String[] pushIds, Callback callback) {
        try {
            FollowAnalytics.Push.markAsUnread(pushIds);
        } catch (Exception e) {
            Log.d("Unable to mark unread", e.getMessage());
        }
    }

    @ReactMethod
    public void delete(String[] pushIds, Callback callback) {
        try {
            FollowAnalytics.Push.delete(pushIds);
        } catch (Exception e) {
            Log.d("Unable to delete", e.getMessage());
        }
    }


}
