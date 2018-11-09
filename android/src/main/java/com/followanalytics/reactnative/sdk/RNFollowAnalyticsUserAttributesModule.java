package com.followanalytics.reactnative.sdk;

import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.followanalytics.FollowAnalytics;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RNFollowAnalyticsUserAttributesModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;
    private final SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MMM-yyyy");
    private final SimpleDateFormat datetimeFormatter = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss Z");

    public RNFollowAnalyticsUserAttributesModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "RNFollowAnalyticsUserAttributes";
    }

    @ReactMethod
    public void setFirstName(String firstName) {
        FollowAnalytics.UserAttributes.setFirstName(firstName);
    }

    @ReactMethod
    public void setLastName(String lastName) {
        FollowAnalytics.UserAttributes.setLastName(lastName);
    }

    @ReactMethod
    public void setEmail(String email) {
        FollowAnalytics.UserAttributes.setEmail(email);
    }

    @ReactMethod
    public void setDateOfBirth(String birthDate) {
        try {
            Date bDate = this.dateFormatter.parse(birthDate);
            FollowAnalytics.UserAttributes.setDateOfBirth(bDate);
        } catch (ParseException e) {
            Log.d("Error parsing ", e.getMessage());
        }

    }

    @ReactMethod
    public void setGender(Integer gender) {
        FollowAnalytics.UserAttributes.setGender(gender);
    }

    @ReactMethod
    public void setCountry(String country) {
        FollowAnalytics.UserAttributes.setCountry(country);
    }

    @ReactMethod
    public void setRegion(String region) {
        FollowAnalytics.UserAttributes.setRegion(region);
    }

    @ReactMethod
    public void setProfilePictureUrl(String profilePictureUrl) {
        FollowAnalytics.UserAttributes.setProfilePictureUrl(profilePictureUrl);
    }

    @ReactMethod
    public void setInteger(String key, Integer value) {
        try {
            FollowAnalytics.UserAttributes.setNumber(key, value);
        } catch (Exception e) {
            Log.d("Error setting " + key + " value: ", value.toString());
        }
    }

    @ReactMethod
    public void setDouble(String key, Double value) {
        try {
            FollowAnalytics.UserAttributes.setNumber(key, value);
        } catch (Exception e) {
            Log.d("Error setting " + key + " value: ", value.toString());
        }
    }

    @ReactMethod
    public void setString(String key, String value) {
        try {
            FollowAnalytics.UserAttributes.setString(key, value);
        } catch (Exception e) {
            Log.d("Error setting " + key + " value: ", value.toString());
        }
    }

    @ReactMethod
    public void setBoolean(String key, Boolean value) {
        try {
            FollowAnalytics.UserAttributes.setBoolean(key, value);
        } catch (Exception e) {
            Log.d("Error setting " + key + " value: ", value.toString());
        }
    }

    @ReactMethod
    public void setDate(String key, String value) {
        try {
            Date date = this.dateFormatter.parse(value);
            FollowAnalytics.UserAttributes.setDate(key, date);
        } catch (Exception e) {
            Log.d("Error setting " + key + " value: ", value.toString());
        }
    }

    @ReactMethod
    public void setDateTime(String key, String value) {
        try {
            Date bDate = this.datetimeFormatter.parse(value);
            FollowAnalytics.UserAttributes.setDateTime(key, bDate);
        } catch (Exception e) {
            Log.d("Error setting " + key + " value: ", value.toString());
        }
    }

    @ReactMethod
    public void clear(String key) {
        try {
            FollowAnalytics.UserAttributes.clear(key);
        } catch (Exception e) {
            Log.d("Error clearing ", key);
        }
    }

    @ReactMethod
    public void addToSet(String key, String value) {
        try {
            FollowAnalytics.UserAttributes.addToSet(key, value);
        } catch (Exception e) {
            Log.d("Error adding to " + key, value);
        }
    }

    @ReactMethod
    public void removeFromSet(String key, String value) {
        try {
            FollowAnalytics.UserAttributes.removeFromSet(key, value);
        } catch (Exception e) {
            Log.d("Error removing from " + key, value);
        }
    }

    @ReactMethod
    public void clearSet(String key) {
        try {
            FollowAnalytics.UserAttributes.clearSet(key);
        } catch (Exception e) {
            Log.d("Error clearing ", key);
        }
    }

}
