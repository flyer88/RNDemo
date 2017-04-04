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

  constructor(props) {
    super(props);

  }

  render() {
    return (
      <View>
            <Text> { this.props.message }</Text>
            <Text>Hello IOS </Text>
      </View>
    )
  }

    componentDidMount()
    {
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
