
Pod::Spec.new do |s|
  s.name         = "RNFollowAnalytics"
  s.version      = "1.0.0"
  s.summary      = "RNFollowAnalytics"
  s.description  = <<-DESC
                  RNFollowAnalytics
                   DESC
  s.homepage     = ""
  s.license      = "MIT"
  # s.license      = { :type => "MIT", :file => "FILE_LICENSE" }
  s.author             = { "author" => "josecarlos@followanalytics.com" }
  s.platform     = :ios, "7.0"
  s.source       = { :git => "https://github.com/author/RNFollowanalytics.git", :tag => "master" }
  s.source_files  = "RNFollowanalytics/**/*.{h,m}"
  s.requires_arc = true


  s.dependency "React"
  #s.dependency "others"

end

