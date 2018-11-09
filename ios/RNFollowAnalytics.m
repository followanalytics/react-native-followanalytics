
#import "RNFollowAnalytics.h"
#import <React/RCTLog.h>

@implementation RNFollowAnalytics

- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}
RCT_EXPORT_MODULE()

RCT_EXPORT_METHOD(logEvent:(NSString *)name details:(id)details)
{
    [FollowAnalytics logEvent:name details:details];
}

RCT_EXPORT_METHOD(logError:(NSString *)name details:(id)details)
{
    [FollowAnalytics logError:name details:details];
}

RCT_EXPORT_METHOD(registerForPushNotifications)
{
    // No longer available since 6.0.0
    //[FollowAnalytics registerForPushNotifications];
}

RCT_EXPORT_METHOD(requestNotificationCenterDefaultAuthorisation)
{
    [FollowAnalytics requestNotificationCenterDefaultAuthorisation];
}

RCT_EXPORT_METHOD(unregisterFromPushNotifications)
{
    NSLog(@"Unavailable for iOS. Please use the Settings panel for the application.");
}

RCT_EXPORT_METHOD(registerPushNotificationWithToken:(id)token)
{
    NSLog(@"Unavailable for iOS.");
}

RCT_EXPORT_METHOD(getOptInAnalytics)
{
    [FollowAnalytics getOptInAnalytics];
}

RCT_EXPORT_METHOD(setOptInAnalytics:(BOOL)optInAnalytics)
{
    [FollowAnalytics setOptInAnalytics:optInAnalytics];
}

RCT_EXPORT_METHOD(getDeviceId:(RCTResponseSenderBlock)callback)
{
    RCTLogInfo(@"Device ID %@", [FollowAnalytics getDeviceId]);
    callback(@[[NSNull null], [NSString stringWithFormat:@"%@", [FollowAnalytics getDeviceId]]]);
}

RCT_EXPORT_METHOD(isRegisteredForPushNotifications:(RCTResponseSenderBlock)callback)
{
    dispatch_async(dispatch_get_main_queue(), ^{
        UIUserNotificationType notificationType =
        [[UIApplication sharedApplication] currentUserNotificationSettings].types;
        BOOL isRegistered = (notificationType == UIUserNotificationTypeNone);
        RCTLogInfo(@"Registered for Push Notifications? %d", isRegistered);
        callback(@[[NSNull null], [NSNumber numberWithBool:isRegistered]]);
    });
}

RCT_EXPORT_METHOD(getUserId:(RCTResponseSenderBlock)callback)
{
    NSString *userId = [FollowAnalytics getUserId];
    callback(@[[NSNull null], (userId ? userId : [NSNull null])]);
}

RCT_EXPORT_METHOD(setUserId:(NSString *)userId)
{
    [FollowAnalytics setUserId:userId];
}

@end

