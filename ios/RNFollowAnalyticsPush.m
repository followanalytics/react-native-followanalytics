//
//  RNFollowAnalyticsPush.m
//  RNFollowanalytics
//
//  Created by Jose Carlos Joaquim on 22/08/2018.
//  Copyright © 2018 Facebook. All rights reserved.
//

#import "RNFollowAnalyticsPush.h"
#import <React/RCTLog.h>

@implementation RNFollowAnalyticsPush

- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}
RCT_EXPORT_MODULE()
// Push

RCT_EXPORT_METHOD(getAll:(RCTResponseSenderBlock)callback)
{
    callback(@[[NSNull null], [FollowAnalytics.push getAll]]);
}

RCT_EXPORT_METHOD(get:(nonnull NSString *)pushId callback:(RCTResponseSenderBlock)callback)
{
    callback(@[[NSNull null], [FollowAnalytics.push get:pushId]]);
}

RCT_EXPORT_METHOD(markAsRead:(nonnull NSArray *)pushIds)
{
    [FollowAnalytics.push markAsRead:pushIds];
}

RCT_EXPORT_METHOD(markAsUnread:(nonnull NSArray *)pushIds)
{
    [FollowAnalytics.push markAsUnread:pushIds];
}

RCT_EXPORT_METHOD(delete:(nonnull NSArray *)pushIds)
{
    [FollowAnalytics.inApp deleteIdentifiers:pushIds];
}
@end
