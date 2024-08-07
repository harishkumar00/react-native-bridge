package com.bridge

import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod

class BridgeModule(reactContext: ReactApplicationContext) :
  ReactContextBaseJavaModule(reactContext) {

  override fun getName(): String {
    return NAME
  }

  @ReactMethod
  fun isPackageInstalled(packageName: String, promise: Promise) {
    val packageManagerAPI = PackageManagerAPI()
    val isPackageInstalled =
      packageManagerAPI.isPackageInstalled(reactApplicationContext, packageName)
    promise.resolve(isPackageInstalled)
  }

  companion object {
    const val NAME = "Bridge"
  }
}
