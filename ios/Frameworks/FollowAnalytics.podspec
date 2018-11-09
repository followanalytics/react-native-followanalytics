Pod::Spec.new do |s|
  s.name          = "FollowAnalytics"
  s.version       = "6.0.0"
  s.summary       = "FollowAnalytics SDK for analytics on iOS."
  s.description   = "Transform your mobile presence into mobile profits by optimizing your mobile apps to acquire new customers and grow revenue."
  s.homepage      = "http://www.followanalytics.com/"
  s.license       = { :type => "commercial", :text => "See http://followanalytics.com" }
  s.author        = "FollowAnalytics"
  s.platform      = :ios
  s.ios.deployment_target = '8.0'
  s.ios.vendored_frameworks = "FollowAnalytics.framework"
  s.frameworks    = "FollowAnalytics", "Security"
  s.requires_arc  = true
  s.source = { path: '.' }
end
