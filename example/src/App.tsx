import React from 'react';
import { StyleSheet, View, Text } from 'react-native';
import { PackageManager } from 'react-native-bridge';

export default function App() {
  const func = async () => {
    const isPackageInstalled =
      await PackageManager.isPackageInstalled('https://');

    console.log('isPackageInstalled', isPackageInstalled);
  };
  React.useEffect(() => {
    func();
  });

  return (
    <View style={styles.container}>
      <Text>Test</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    width: 60,
    height: 60,
    marginVertical: 20,
  },
});
