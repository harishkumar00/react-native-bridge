package com.bridge

import com.bridge.api.ActivityManagerAPI
import com.bridge.api.PackageManagerAPI
import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.bridge.ReadableMap

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

  @ReactMethod
  fun setResultAndFinish(result: String, extras: ReadableMap) {
    val activityManagerAPI = ActivityManagerAPI()
    activityManagerAPI.setResultAndFinish(reactApplicationContext, result, extras)
  }

  @ReactMethod
  fun getPackageFingerprint(packageName: String, promise: Promise) {
    val packageManagerAPI = PackageManagerAPI()
    promise.resolve(packageManagerAPI.getPackageFingerprint(reactApplicationContext, packageName))
  }

  companion object {
    const val NAME = "Bridge"
  }
}
