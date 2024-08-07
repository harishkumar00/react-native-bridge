@objc(Bridge)
class Bridge: NSObject {
    
    @objc(isPackageInstalled:withResolver:withRejecter:)
    func isPackageInstalled(packageName: String, resolve:RCTPromiseResolveBlock,reject:RCTPromiseRejectBlock) -> Void {
        if let url = URL(string: packageName), UIApplication.shared.canOpenURL(url) {
          resolve(true)
        } else {
          resolve(false)
        }
    }
}
