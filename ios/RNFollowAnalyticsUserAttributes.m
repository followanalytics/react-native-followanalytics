#import "RNFollowAnalyticsUserAttributes.h"
#import <React/RCTLog.h>

@implementation RNFollowAnalyticsUserAttributes

- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}
RCT_EXPORT_MODULE()
// User Attributes
RCT_EXPORT_METHOD(setFirstName:(nullable NSString *)firstName)
{
    [FollowAnalytics.userAttributes setFirstName:firstName];
}

RCT_EXPORT_METHOD(setLastName:(nullable NSString *)lastName)
{
    [FollowAnalytics.userAttributes setLastName:lastName];
}

RCT_EXPORT_METHOD(setEmail:(nullable NSString *)email)
{
    [FollowAnalytics.userAttributes setEmail:email];
}

RCT_EXPORT_METHOD(setDateOfBirth:(nullable NSString *)dateOfBirth)
{
    NSDateFormatter *dateFormat = [[NSDateFormatter alloc] init];
    [dateFormat setDateFormat:@"dd/MM/yyyy"];
    NSDate *date = [dateFormat dateFromString:dateOfBirth];
    [FollowAnalytics.userAttributes setDateOfBirth:date];
}

RCT_EXPORT_METHOD(setGender:(id)gender)
{
    [FollowAnalytics.userAttributes setGender:[gender integerValue]];
}

RCT_EXPORT_METHOD(setCountry:(nullable NSString*)country)
{
    [FollowAnalytics.userAttributes setCountry:country];
}

RCT_EXPORT_METHOD(setRegion:(nullable NSString*)region)
{
    [FollowAnalytics.userAttributes setRegion:region];
}

RCT_EXPORT_METHOD(setProfilePictureUrl:(nullable NSString*)profilePictureUrl)
{
    [FollowAnalytics.userAttributes setProfilePictureUrl:profilePictureUrl];
}

RCT_EXPORT_METHOD(setInteger:(NSInteger)value forKey:(nonnull NSString*)key)
{
    [FollowAnalytics.userAttributes setInteger:value forKey:key];
}

RCT_EXPORT_METHOD(setDouble:(double)value forKey:(nonnull NSString*)key)
{
    [FollowAnalytics.userAttributes setDouble:value forKey:key];
}

RCT_EXPORT_METHOD(setString:(nonnull NSString*)value forKey:(nonnull NSString*)key)
{
    [FollowAnalytics.userAttributes setString:value forKey:key];
}

RCT_EXPORT_METHOD(setBoolean:(bool)value forKey:(nonnull NSString*)key)
{
    [FollowAnalytics.userAttributes setBoolean:value forKey:key];
}

RCT_EXPORT_METHOD(setDate:(nonnull NSString *)value forKey:(nonnull NSString*)key)
{
    NSDateFormatter *dateFormat = [[NSDateFormatter alloc] init];
    [dateFormat setDateFormat:@"dd/MM/yyyy"];
    NSDate *date = [dateFormat dateFromString:value];
    [FollowAnalytics.userAttributes setDate:date forKey:key];
}

RCT_EXPORT_METHOD(setDateTime:(nonnull NSString *)value forKey:(nonnull NSString*)key)
{
    NSDateFormatter *dateFormat = [[NSDateFormatter alloc] init];
    [dateFormat setDateFormat:@"MM-dd-yyyy HH:mm:ss Z"];
    NSDate *date = [dateFormat dateFromString:value];
    [FollowAnalytics.userAttributes setDateTime:date forKey:key];
}

RCT_EXPORT_METHOD(clear:(nonnull NSString *)key)
{
    [FollowAnalytics.userAttributes clear:key];
}

RCT_EXPORT_METHOD(addToSet:(nonnull NSString *)key values:(nonnull NSSet *)values)
{
    [FollowAnalytics.userAttributes add:values toSet:key];
}

RCT_EXPORT_METHOD(removeFromSet:(nonnull NSString *)key values:(nonnull NSSet *)values)
{
    [FollowAnalytics.userAttributes remove:values toSet:key];
}

RCT_EXPORT_METHOD(clearSet:(nonnull NSString *)key)
{
    [FollowAnalytics.userAttributes clearSet:key];
}

@end
  
