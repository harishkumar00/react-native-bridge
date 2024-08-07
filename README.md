# react-native-bridge

Bridge for native Api's

## Installation

```javascript
npm install react-native-bridge
```
```javascript
yarn add react-native-bridge
```

## Usage

### isPackageInstalled
> To find if the app is installed on the device
```javascript
import { PackageManager } from 'react-native-bridge';

// Android
PackageManager.isPackageInstalled("com.example.package") // true or false

// iOS
PackageManager.isPackageInstalled("scheme://") // true or false
```
