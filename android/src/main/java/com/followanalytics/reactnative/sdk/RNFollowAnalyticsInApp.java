package com.followanalytics.reactnative.sdk;

import android.util.Log;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.followanalytics.FollowAnalytics;

public class RNFollowAnalyticsInApp extends ReactContextBaseJavaModule {
    private final ReactApplicationContext reactContext;

    public RNFollowAnalyticsInApp(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "RNFollowAnalyticsInApp";
    }

    @ReactMethod
    public void pauseCampaignDisplay() {
        try {
            FollowAnalytics.InApp.pauseCampaignDisplay();
        } catch (Exception e) {
            Log.d("Error pausing campaigns", e.getMessage());
        }
    }

    @ReactMethod
    public void resumeCampaignDisplay() {
        try {
            FollowAnalytics.InApp.resumeCampaignDisplay();
        } catch (Exception e) {
            Log.d("Error resuming campaign", e.getMessage());
        }
    }

    @ReactMethod
    public void getAll(Callback callback) {
        try {
            callback.invoke(null, FollowAnalytics.InApp.getAll());
        } catch (Exception e) {
            Log.d("Unable to get Campaigns", e.getMessage());
        }
    }

    @ReactMethod
    public void get(String campaignId, Callback callback) {
        try {
            callback.invoke(null, FollowAnalytics.InApp.get(campaignId));
        } catch (Exception e) {
            Log.d("Unable to get Campaigns", e.getMessage());
        }
    }

    @ReactMethod
    public void markAsRead(String[] campaignIds, Callback callback) {
        try {
            FollowAnalytics.InApp.markAsRead(campaignIds);
        } catch (Exception e) {
            Log.d("Unable to get Campaigns", e.getMessage());
        }
    }

    @ReactMethod
    public void markAsUnread(String[] campaignIds, Callback callback) {
        try {
            FollowAnalytics.InApp.markAsUnread(campaignIds);
        } catch (Exception e) {
            Log.d("Unable to mark unread", e.getMessage());
        }
    }

    @ReactMethod
    public void delete(String[] campaignIds, Callback callback) {
        try {
            FollowAnalytics.InApp.delete(campaignIds);
        } catch (Exception e) {
            Log.d("Unable to delete", e.getMessage());
        }
    }


}
