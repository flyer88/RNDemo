'use strict';

import React from 'react';
import {
  AppRegistry,
  StyleSheet,
  Text,
  View,
  NativeModules,
} from 'react-native';

var RCTToastAndroid  = NativeModules.ToastCustomModule;

class HelloWorld extends React.Component {

  render() {
    return (
      <View>
            <Text>Hi Android</Text>
            <Text>Hi IOS</Text>
      </View>
    )
  }

    componentDidMount()
    {
     // CustomToast.showMessage();
        // var RCTToastAndroid = require('NativeModules').ToastCustomModule
     //   RCTToastAndroid.showMessage();
    //   debugger;
        RCTToastAndroid.showMessage('Awesome', (result) => {
        console.log("line 31",result);
      });
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
