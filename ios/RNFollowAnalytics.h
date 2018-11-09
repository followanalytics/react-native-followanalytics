
#if __has_include("RCTBridgeModule.h")
#import "RCTBridgeModule.h"
#else
#import <React/RCTBridgeModule.h>
#endif

#import <FollowAnalytics/FollowAnalytics.h>

@interface RNFollowAnalytics : NSObject <RCTBridgeModule>

@end

