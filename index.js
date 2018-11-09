
import { NativeModules } from 'react-native';

let FollowAnalytics = NativeModules.RNFollowAnalytics;
const FollowAnalyticsUserAttributes = NativeModules.RNFollowAnalyticsUserAttributes;
const FollowAnalyticsInApp = NativeModules.RNFollowAnalyticsInApp;
const FollowAnalyticsPush = NativeModules.RNFollowAnalyticsPush;
const FollowAnalyticsDataWallet = NativeModules.RNFollowAnalyticsDataWallet;
const FollowAnalyticsGDPR = NativeModules.RNFollowAnalyticsGDPR;

FollowAnalytics.UserAttributes = FollowAnalyticsUserAttributes;
FollowAnalytics.InApp = FollowAnalyticsInApp;
FollowAnalytics.Push = FollowAnalyticsPush;
FollowAnalytics.DataWallet = FollowAnalyticsDataWallet;
FollowAnalytics.DataWalletGDPR = FollowAnalyticsGDPR;

FollowAnalytics.Gender = {
  MALE: 1,
  FEMALE: 2,
  OTHER: 3
};

export default FollowAnalytics;
