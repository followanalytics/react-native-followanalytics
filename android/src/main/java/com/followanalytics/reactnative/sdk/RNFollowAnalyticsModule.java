
package com.followanalytics.reactnative.sdk;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.followanalytics.FollowAnalytics;

public class RNFollowAnalyticsModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNFollowAnalyticsModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNFollowAnalytics";
  }

  @ReactMethod
  public void logEvent(String name, String details) {
    FollowAnalytics.logEvent(name, details);
  }

  @ReactMethod
  public void logError(String name, String details) {
    FollowAnalytics.logEvent(name, details);
  }

  @ReactMethod
  public void getDeviceId(Callback callback) {
    callback.invoke(null, FollowAnalytics.getDeviceId());
  }

  @ReactMethod
  public void registerForPushNotifications() {
    // Not available
  }

  @ReactMethod
  public void registerForPushNotificationsWithToken(String token) {
    // not available
  }

  @ReactMethod
  public void isRegisteredForPushNotifications(Callback callback) {
    callback.invoke(null, FollowAnalytics.isRegisteredForPushNotifications());
  }

  @ReactMethod
  public void getUserId(Callback callback) {
    callback.invoke(null, FollowAnalytics.getUserId());
  }

  @ReactMethod
  public void setUserId(String userId) {
    if (userId == "") {
      userId = null;
    }
    FollowAnalytics.setUserId(userId);
  }

  @ReactMethod
  public void setOptInAnalytics(Boolean optInState) {
    FollowAnalytics.setOptInAnalytics(optInState);
  }

  @ReactMethod
  public void getOptInAnalytics(Callback callback) {
    callback.invoke(null, FollowAnalytics.getOptInAnalytics());
  }

}