# react-native-bridge

> This React Native package provides a bridge for accessing native APIs, enabling seamless integration between React Native and platform-specific features that aren't directly available in the React Native ecosystem. By leveraging this bridge, developers can invoke native functions from JavaScript, offering a more extensive range of capabilities for their apps.

## Installation

```javascript
npm install react-native-bridge # or use $ yarn add react-native-bridge
```

## Usage

### isPackageInstalled(packageName)
> To find if the app is installed on the device

### Android
If >= Android 11 (API level 30) and below to `AndroidManifest.xml`
```javascript
<manifest xmlns:android="http://schemas.android.com/apk/res/android">

  <queries>
    <package android:name="com.example.package" /> // Add the package that you want to query
  </queries>

</manifest>
```

```javascript
import { PackageManager } from 'react-native-bridge';
await PackageManager.isPackageInstalled("com.example.package") // true or false
```
### iOS
Add below to `Info.plist`
```javascript
<key>LSApplicationQueriesSchemes</key>
<array>
  <string>appScheme</string>
</array>
```

```javascript
import { PackageManager } from 'react-native-bridge';
await PackageManager.isPackageInstalled("appScheme://") // true or false
```

### getPackageFingerprint(packageName) (Only For Android)
If >= Android 11 (API level 30) and below to `AndroidManifest.xml`
```javascript
<manifest xmlns:android="http://schemas.android.com/apk/res/android">

  <queries>
    <package android:name="com.example.package" /> // Add the package that you want to get fingerprint
  </queries>

</manifest>
```
```javascript
import { PackageManager } from 'react-native-bridge';
await PackageManager.getPackageFingerprint("com.example.package")
// 2F:19:AD:EB:28:4E:B3:6F:7F:07:78:61:52:B9:A1:D1:4B:21:65:32:03:AD:0B:04:EB:BF:9C:73:AB:6D:76:25
```

### setResultAndFinish(result, extras) (Only For Android)
```javascript
import { ActivityManager } from 'react-native-bridge';
result = "ok" or "cancel"
extras = { string: number | string | boolean }
ActivityManager.setResultAndFinish(result, extras)
```



