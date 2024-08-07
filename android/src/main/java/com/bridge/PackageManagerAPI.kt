package com.bridge

import android.content.pm.PackageManager
import android.content.pm.PackageManager.NameNotFoundException
import android.os.Build
import com.facebook.react.bridge.ReactContext

class PackageManagerAPI {

  fun isPackageInstalled(context: ReactContext, packageName: String): Boolean {

    try {
      val packageManager = context.packageManager

      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        packageManager.getPackageInfo(packageName, PackageManager.PackageInfoFlags.of(0))
      } else {
        packageManager.getPackageInfo(packageName, 0)
      }
      return true
    } catch (error: NameNotFoundException) {
      return false
    }
  }
}
