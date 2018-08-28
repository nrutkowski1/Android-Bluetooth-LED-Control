# Android Bluetooth LED Control
An android app to control a WS2812b RGB LED strip with 300 pixels

There are still some sublte navigation issues within the app that exists. A future update will be made which addresses these issues ands provides greater functionality to the app. As of now, the app functions as intended. 

Arduino code will be uploaded once completed

The app is a series of tabs each of which can be customized by the user. The functionality of each button can be changed within the Arduino code. 

## *UPDATES* 

**8/23/2018** - I have uploaded the Arduino code used to receive and process the data from the Android app. To set up the Arduino connect the bluetooth module VCC to 5V and GND to GND, connect the RX and TX pins to digital pins and define these in the Arduino code. If you wish to use an AUX input for music effects you must build the circuit in the schematic below. 

I have updated the "Effects" tab in the Android app to my preferences and have written most of the functions to control these effects in the Arduino. I will update both the Android and Arduino code as I develop these further. You may develop your own effects and program them yourself, get creative! If you wish to change the displayed text for the switches in the "Effects" tab you can do so by changing the text of the switches in the layout file, tab2_fragment.xml. 

**8/28/2018** - I have updated the schematic and pcb design fo an Arduino shield. There was a problem in the original one where the bluetooth TXD and RXD pins were not properly connected to the TX and RX pins of the Arduino.

## Arduino Code

To set up the Arduino connect the bluetooth module VCC to 5V and GND to GND, connect the RX and TX pins to digital pins or, the RX and TX pins of the Arduino, and define these in the Arduino code. If you wish to use an AUX input for music effects you must build the circuit in the schematic below. 

I will update both the Android and Arduino code as I develop these further. You may develop your own effects and program them yourself, get creative! If you wish to change the displayed text for the switches in the "Effects" tab you can do so by changing the text of the switches in the layout file, tab2_fragment.xml.  

**IMPORTANT NOTE** there is currently an issue with the responsiveness of the Arduino code when turning off an effect. Basically the current state of the code prevents the Arduino from always being able to read data from the bluetooth device. This means that in order to turn off an effect it may require you to repeatedly turn the switch on and off several times before the Arduino is actually able to read the data from the bluetooth device. I am working on reducing this effect and fixing the problem. The Arduino code will be updated when completed. 

## Main Activity 

When the app is first opened the user will be prompted to enable their phones' bluetooth if it is not already enabled. The user is then able to connect / diconnect from the bluetooth device.

<a href="https://github.com/nrutkowski1/Android_Bluetooth_LED_Control/blob/master/Images/Screenshot_20180812-175101.png"><img src="https://github.com/nrutkowski1/Android_Bluetooth_LED_Control/blob/master/Images/Screenshot_20180812-175101.png" height="400"></a>

### Change Address

Within the Android code there are some changes that must be made before you can connect to your own bluetooth device. You must change the device address defined in **MainActivity.java** to your bluetooths device address. Additionally, you can generate your own UUID to use instead of the one I did however, this is not necessary.

<a href="https://github.com/nrutkowski1/Android_Bluetooth_LED_Control/blob/master/Images/device.png"><img src="https://github.com/nrutkowski1/Android_Bluetooth_LED_Control/blob/master/Images/device.png" height="200"></a>

## First Tab 

The first tab is a set of buttons that, when pushed, will send a string of bytes over bluetooth that contains the RGB values of the buttons background color. If you wish to change the color of the buttons you can do so by changing the **background color** of the **tab1_fragment.xml** file. 

<a href="https://github.com/nrutkowski1/Android_Bluetooth_LED_Control/blob/master/Images/Screenshot_20180812-175009.png"><img src="https://github.com/nrutkowski1/Android_Bluetooth_LED_Control/blob/master/Images/Screenshot_20180812-175009.png" height="400"></a>

## Second Tab

The second tab has a set of switches for different effects which can be programmed later in the Arduino code. The Android app simply sends data over bluetooth that can identify which effect should be played. You can change the labels of the buttons in the **tab2_fragment.xml** file.

<a href="https://github.com/nrutkowski1/Android_Bluetooth_LED_Control/blob/master/Images/Screenshot_20180812-175015.png"><img src="https://github.com/nrutkowski1/Android_Bluetooth_LED_Control/blob/master/Images/Screenshot_20180812-175015.png" height="400"></a>

## Third Tab

The third tab is a color picking dialog which allows for you to choose a color from all 256^3 possible RGB values rather than just the 25 default ones in the first tab. 

<a href="https://github.com/nrutkowski1/Android_Bluetooth_LED_Control/blob/master/Images/Screenshot_20180812-175023.png"><img src="https://github.com/nrutkowski1/Android_Bluetooth_LED_Control/blob/master/Images/Screenshot_20180812-175023.png" height="400"></a>

## Fourth Tab

The fourth tab is a set of buttons which allows navigation to a view with a set of 30 buttons on it. Each of these 30 buttons has a number on it which corresponds to a light on the strip (button 43 controls light 43 on the light strip). Each light can have its color individually controlled. This allows for custom color patterns to be created. Futher updates are planned to improve this tab.

<a href="https://github.com/nrutkowski1/Android_Bluetooth_LED_Control/blob/master/Images/Screenshot_20180812-175029.png"><img src="https://github.com/nrutkowski1/Android_Bluetooth_LED_Control/blob/master/Images/Screenshot_20180812-175029.png" height="400"></a>

<a href="https://github.com/nrutkowski1/Android_Bluetooth_LED_Control/blob/master/Images/Screenshot_20180812-175035.png"><img src="https://github.com/nrutkowski1/Android_Bluetooth_LED_Control/blob/master/Images/Screenshot_20180812-175035.png" height="400"></a>

<a href="https://github.com/nrutkowski1/Android_Bluetooth_LED_Control/blob/master/Images/Screenshot_20180812-175054.png"><img src="https://github.com/nrutkowski1/Android_Bluetooth_LED_Control/blob/master/Images/Screenshot_20180812-175054.png" height="400"></a>

## Circuit Schematic 

Below is a schematic for the circuit which has an AUX input and an HC-05 bluetooth device. This is designed such that the power and ground are from the Arduino. If you want to connect an LED strip you must connect the data pin from the light strip to a digital pin on the Arduino and connect the ground of the light strip to the ground of the Arduino as well as the ground of the power supply for the light strip. 

<a href="https://github.com/nrutkowski1/Android_Bluetooth_LED_Control/blob/master/Images/schematic.png"><img src="https://github.com/nrutkowski1/Android_Bluetooth_LED_Control/blob/master/Images/schematic.png" height="300"></a>

Using the schematic above I designed a PCB which is used as a shield for the Arduino UNO.

<a href="https://github.com/nrutkowski1/Android_Bluetooth_LED_Control/blob/master/Images/pcb_updated.png"><img src="https://github.com/nrutkowski1/Android_Bluetooth_LED_Control/blob/master/Images/pcb_updated.png" height="300"></a>

