#import "RNFollowAnalyticsInApp.h"
#import <React/RCTLog.h>

@implementation RNFollowAnalyticsInApp

- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}
RCT_EXPORT_MODULE()
// InApp
RCT_EXPORT_METHOD(pauseCampaignDisplay)
{
    [FollowAnalytics.inApp pauseCampaignDisplay];
}

RCT_EXPORT_METHOD(resumeCampaignDisplay)
{
    [FollowAnalytics.inApp resumeCampaignDisplay];
}

RCT_EXPORT_METHOD(getAll:(RCTResponseSenderBlock)callback)
{
    callback(@[[NSNull null], [FollowAnalytics.inApp getAll]]);
}

RCT_EXPORT_METHOD(get:(nonnull NSString *)campaignId callback:(RCTResponseSenderBlock)callback)
{
    callback(@[[NSNull null], [FollowAnalytics.inApp get:campaignId]]);
}

RCT_EXPORT_METHOD(markAsRead:(nonnull NSArray *)campaignIds)
{
    [FollowAnalytics.inApp markAsRead:campaignIds];
}

RCT_EXPORT_METHOD(markAsUnread:(nonnull NSArray *)campaignIds)
{
    [FollowAnalytics.inApp markAsUnread:campaignIds];
}

RCT_EXPORT_METHOD(delete:(nonnull NSArray *)campaignIds)
{
    [FollowAnalytics.inApp deleteIdentifiers:campaignIds];
}
@end
  
