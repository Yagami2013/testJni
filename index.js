import React, { Component } from 'react';
import { Text, View,AppRegistry,Button} from 'react-native';
import { NBSAppAgent } from 'react-native-tingyunapp'
const newlensClient = new NBSAppAgent();

export default class HelloWorldApp extends Component {
  render() {
    return (
        <View style={{ flex: 1, justifyContent: "center", alignItems: "center" }}>
          <Button title="test tingyun" onPress={()=>{
            try{
                abc;
            }catch(error){
                newlensClient.reportError("123",error,{"key":"123"});
            }

          }}/>
        </View>
    );
  }
}
AppRegistry.registerComponent('testJni-master', () => HelloWorldApp );