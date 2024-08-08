import { StyleSheet, View, TouchableOpacity, Text } from 'react-native';
import { PackageManager, ActivityManager } from 'react-native-bridge';

const Button = ({
  title,
  style = {},
  textStyle = {},
  onPress,
}: {
  title: string;
  style: any;
  textStyle: any;
  onPress: () => void;
}) => {
  return (
    <TouchableOpacity style={style} onPress={onPress}>
      <Text style={textStyle}>{title}</Text>
    </TouchableOpacity>
  );
};

export default function App() {
  return (
    <View style={styles.container}>
      <Button
        textStyle={styles.textStyle}
        style={styles.button}
        title="Get Fingerprint"
        onPress={() => {
          PackageManager.getPackageFingerprint(
            'rocks.keyless.app.android.sapphire'
          ).then(console.log);
        }}
      />
      <Button
        textStyle={styles.textStyle}
        style={styles.button}
        title="Finish Activity"
        onPress={() => {
          ActivityManager.setResultAndFinish('ok', { success: true });
        }}
      />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  button: {
    backgroundColor: 'black',
    width: 250,
    height: 50,
    borderRadius: 20,
    justifyContent: 'center',
    alignItems: 'center',
    marginVertical: 10,
  },
  textStyle: {
    color: 'white',
    fontSize: 18,
    fontWeight: '500',
  },
});
