package com.bridge.api

import android.content.pm.PackageManager
import android.content.pm.PackageManager.NameNotFoundException
import android.os.Build
import com.facebook.react.bridge.ReactContext
import java.io.ByteArrayInputStream
import java.security.MessageDigest
import java.security.cert.CertificateFactory
import java.security.cert.X509Certificate

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

  fun getPackageFingerprint(context: ReactContext, packageName: String): String? {
    try {
      val packageManager = context.packageManager
      val packageInfo =
        packageManager.getPackageInfo(packageName, PackageManager.GET_SIGNATURES)
      val signatures = packageInfo.signatures
      val input = ByteArrayInputStream(signatures[0].toByteArray())

      val certificateFactory = CertificateFactory.getInstance("X509")
      val certificate =
        certificateFactory.generateCertificate(input) as X509Certificate
      val md = MessageDigest.getInstance("SHA-256")
      val publicKey = md.digest(certificate.encoded)
      return publicKey.joinToString(":") { "%02X".format(it) }

    } catch (error: Exception) {
      return null
    }
  }
}
