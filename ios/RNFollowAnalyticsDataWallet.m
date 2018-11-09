#import "RNFollowAnalyticsDataWallet.h"
#import <React/RCTLog.h>

@implementation RNFollowAnalyticsDataWallet

- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}
RCT_EXPORT_MODULE()
// Data Wallet
RCT_EXPORT_METHOD(getPolicy:(RCTResponseSenderBlock)callback)
{
    callback(@[[NSNull null], [FollowAnalytics.dataWallet getPolicy]]);
}

RCT_EXPORT_METHOD(isRead:(RCTResponseSenderBlock)callback)
{
    callback(@[[NSNull null], [NSNumber numberWithBool:[FollowAnalytics.dataWallet isRead]]]);
}

RCT_EXPORT_METHOD(setIsRead:(BOOL)isRead)
{
    [FollowAnalytics.dataWallet setIsRead:isRead];
}
@end
  
