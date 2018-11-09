
# FollowAnalytics React Native SDK

## Getting started

#### Requirements
- React Native >= 0.50.0
- Reac Native cli >
- Cocoapods (iOS)
- Gradle (Android)

### Mostly automatic installation

`$ npm install react-native-followanalytics --save`

`$ react-native link react-native-followanalytics`

### Manual installation

`$ npm install PATH_FOR_THE_SDK --save`
`$ react-native link react-native-followanalytics`


#### iOS

If you're using Cocoapods add the following to your application target on the `Podfile`:

	use_frameworks!
	pod 'FollowAnalytics', path: '../node_modules/react-native-followanalytics/ios/Frameworks'
	
Run `pod install` to add the required dependencies.

If you use it manually follow the following steps:

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-followanalytics` and add `RNFollowanalytics.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNFollowanalytics.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)

You'll still need to integrate the FollowAnalytics iOS SDK. Please follow the [Install using Cocoapods](http://dev.followanalytics.com/sdks/ios/documentation/#install-using-cocoapods) and [Initialize with your API key](http://dev.followanalytics.com/sdks/ios/documentation/#initialize-with-your-api-key) from the [FollowAnaltyics Dev Portal](http://dev.followanalytics.com/).


In your `AppDelegate.h` add the following lines:

	#import <FollowAnalytics/FollowAnalytics.h>

In your `AppDelegate.m` add the following lines inside the `- (BOOL)application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions` method

        FollowAnalyticsConfiguration* configuration = [FollowAnalyticsConfiguration
            configurationWith:^(FollowAnalyticsMutableConfiguration * _Nonnull c) {
                c.apiKey = @"YOUR_API_KEY_HERE";
                c.appGroup = @"YOUR_APP_GROUP_HERE";
                c.debug = true;
                c.isDataWalletEnabled = YES;
                c.onDataWalletPolicyChange = ^{
                    [self policyDidChange];
                };
            }];
        [FollowAnalytics startWithConfiguration:configuration
            startupOptions:launchOptions];
        [FAFollowApps storeMessagesPush:YES inApp:YES];
        [FABadge enable];
        [FAFollowApps enableGeoffencing];

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.followanalytics.reactnative.sdk.RNFollowAnalyticsPackage;` to the imports at the top of the file
  - Add `new RNFollowAnalyticsPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-followanalytics'
  	project(':react-native-followanalytics').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-followanalytics/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-followanalytics')
  	```

  - Add `new RNFollowanalyticsReactNativeSdkPackage()` to the `List<IReactPackage>` returned by the `Packages` method

You'll also need to integrate the FollowAnalytics Android SDK to the native part of the application. Please follow the [Install using Gradle](http://dev.followanalytics.com/sdks/android/documentation/#install-using-gradle) and [Initialize with your API key](http://dev.followanalytics.com/sdks/android/documentation/#initialize-with-your-api-key) from the [FollowAnaltyics Dev Portal](http://dev.followanalytics.com/).


## Available methods

The FollowAnalytics React Native SDK makes use of callbacks to get results from method calls, where it applies. Here+s a list of the available methods:

	// all methods using callbacks follow the pattern:
	
	functionName: function((error, result) => {
		if (error) {
			... treat error case here ...
		} else {
			... treat success case here ...
		}
	});

	getOptInAnalytics: function((error, result) => { ... }});
	setOptInAnalytics: function(optIn)
	isRegisteredForPushNotifications: function((error, result) => { ... }});
	getEnvironment: function(error, result) => { ... }});
	registerForPushNotifications(),
	unregisterFromPushNotifications()
	getUserId: function(error, result) => { ... }});
	setUserId: function(user_id);
	getDeviceId: function(error, result) => { ... }});
	
	logEvent: function(name, details)
	logError: function(name, details)

	Gender: {
		MALE: 1,
	   FEMALE: 2,
	   OTHER: 3
	}
 
	UserAttributes: {
		setFirstName(firstName);
    	setLastName(lastName);
    	setEmail(email);
    	setDateOfBirth(dateOfBirth) // takes a string, as React Native doesn't bridges Date types
    	setGender(FollowAnalytics.Gender.(MALE|FEMALE|OTHER);
    	setCountry(country);
    	setCity(city);
    	setRegion(region);
    	setProfilePictureUrl(profilePictureUrl);
    	setNumber(number);
    	setString(string);
    	setBoolean(true | false);
    	setDate(date); // takes a string
    	setDateTime(dateTime); // takes a string
    	clear(key);
    	addToSet(key, ...elements);
    	removeFromSet(key, ...elements);
    	clearSet(key);
	}
	
	Push: {
	    getAll(error, result) => { ... }});
	    get(id, (error, result) => { ... });
	    markAsRead(...ids);
	    markAsUnread(...ids);
	    delete(...ids);
	}
 
	InApp: {
		pauseCampaignDisplay();
	   resumeCampaignDisplay();
	   getAll((error, result) => { ... });
	   get(id, (error, result) => { ... });
	   markAsRead(...ids);
	   markAsUnread(...ids);
	   delete(...ids);
	}
 
	DataWallet: {
		getPolicy((error, result) => { ... });
		isRead((error, result) => { ... });
		setIsRead(value);
	}
	
	GDPR: {
		requestToAccessMyData();
		requestToDeleteMyData()
	}
 

## Usage

At the top of your javascript files add:

```javascript
import FollowAnalytics from "react-native-followanalytics";
```

You can now call the methods listed above using `FollowAnalytics.method_name(arguments)`. Some examples:
	
	FollowAnalytics.logEvent("Page view", "Homepage);
	FollowAnalytics.UserAttributes.setFirstName("Michel");
	FollowAnalytics.getDeviceId: function(error, result) => {
		if (error) {
			console.log("Error fetching deviceId");
			console.log(error);
		} else {
			console.log("Got me a deviceId, and it's: " + result.toString());
		}
	}
