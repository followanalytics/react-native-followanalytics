#import "RNFollowAnalyticsGDPR.h"
#import <React/RCTLog.h>

@implementation RNFollowAnalyticsGDPR

- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}
RCT_EXPORT_MODULE()
// GDPR
RCT_EXPORT_METHOD(requestToAccessMyData)
{
    [FollowAnalytics.GDPR requestToAccessMyData];
}

RCT_EXPORT_METHOD(requestToDeleteMyData)
{
    [FollowAnalytics.GDPR requestToDeleteMyData];
}

@end
  
