
#if __has_include("RCTBridgeModule.h")
#import "RCTBridgeModule.h"
#else
#import <React/RCTBridgeModule.h>
#endif

#import <FollowAnalytics/FollowAnalytics.h>

@interface RNFollowAnalyticsInApp : NSObject <RCTBridgeModule>

@end
  
