#import <React/RCTBridgeModule.h>

@interface RCT_EXTERN_MODULE(Bridge, NSObject)

RCT_EXTERN_METHOD(isPackageInstalled:(NSString *)packageName withResolver:(RCTPromiseResolveBlock)resolve withRejecter:(RCTPromiseRejectBlock)reject)

+ (BOOL)requiresMainQueueSetup
{
  return NO;
}

@end
