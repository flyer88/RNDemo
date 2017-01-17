'use strict';

import React from 'react';
import {
  AppRegistry,
  StyleSheet,
  Text,
  View,
  NativeModules
} from 'react-native';

import  CustomToast from './src/PunchhToastAndroid';


class HelloWorld extends React.Component {

  render() {
    return (
      <View>
      <Text style={styles.hello}>Hello, World Android</Text>
      </View>
    )
  }

    componentDidMount()
    {
       CustomToast.showMessage();

    }

}
var styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
  },
  hello: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
});

AppRegistry.registerComponent('HelloWorld', () => HelloWorld);
