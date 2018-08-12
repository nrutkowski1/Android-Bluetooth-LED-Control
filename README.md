# Android Bluetooth LED Control
An android app to control a WS2812b RGB LED strip with 300 pixels

There are still some sublte navigation issues within the app that exists. A future update will be made which addresses these issues ands provides greater functionality to the app. As of now, the app functions as intended. 

Arduino code will be uploaded once completed

The app is a series of tabs each of which can be customized by the user. The functionality of each button can be changed within the Arduino code. 

## Main Activity 

When the app is first opened the user will be prompted to enable their phones' bluetooth if it is not already enabled. The user is then able to connect / diconnect from the bluetooth device.

<a href="url"><img src="https://github.com/nrutkowski1/Android_Bluetooth_LED_Control/blob/master/Images/Screenshot_20180812-175101.png" height="400"></a>

### Change Address

Within the Android code there are some changes that must be made before you can connect to your own bluetooth device. You must change the device address defined in **MainActivity.java** to your bluetooths device address. Additionally, you can generate your own UUID to use instead of the one I did however, this is not necessary.

<a href="url"><img src="https://github.com/nrutkowski1/Android_Bluetooth_LED_Control/blob/master/Images/device.png" height="200"></a>

## First Tab 

The first tab is a set of buttons that, when pushed, will send a string of bytes over bluetooth that contains the RGB values of the buttons background color. If you wish to change the color of the buttons you can do so by changing the **background color** of the **tab1_fragment.xml** file. 

<a href="url"><img src="https://github.com/nrutkowski1/Android_Bluetooth_LED_Control/blob/master/Images/Screenshot_20180812-175009.png" height="400"></a>

## Second Tab

The second tab has a set of switches for different effects which can be programmed later in the Arduino code. The Android app simply sends data over bluetooth that can identify which effect should be played. You can change the labels of the buttons in the **tab2_fragment.xml** file.

<a href="url"><img src="https://github.com/nrutkowski1/Android_Bluetooth_LED_Control/blob/master/Images/Screenshot_20180812-175015.png" height="400"></a>

## Third Tab

The third tab is a color picking dialog which allows for you to choose a color from all 256^3 possible RGB values rather than just the 25 default ones in the first tab. 

<a href="url"><img src="https://github.com/nrutkowski1/Android_Bluetooth_LED_Control/blob/master/Images/Screenshot_20180812-175023.png" height="400"></a>

## Fourth Tab

The fourth tab is a set of buttons which allows navigation to a view with a set of 30 buttons on it. Each of these 30 buttons has a number on it which corresponds to a light on the strip (button 43 controls light 43 on the light strip). Each light can have its color individually controlled. This allows for custom color patterns to be created. Futher updates are planned to improve this tab.

<a href="url"><img src="https://github.com/nrutkowski1/Android_Bluetooth_LED_Control/blob/master/Images/Screenshot_20180812-175029.png" height="400"></a>

<a href="url"><img src="https://github.com/nrutkowski1/Android_Bluetooth_LED_Control/blob/master/Images/Screenshot_20180812-175035.png" height="400"></a>

<a href="url"><img src="https://github.com/nrutkowski1/Android_Bluetooth_LED_Control/blob/master/Images/Screenshot_20180812-175054.png" height="400"></a>

## Circuit Schematic 

Below is a schematic for the circuit which has an AUX input and an HC-05 bluetooth device. This is designed such that the power and ground are from the Arduino. If you want to connect an LED strip you must connect the data pin frmo the light strip to a digital pin on the Arduino and connect the ground of the light strip to the ground of the Arduino as well as the ground of the power supply for the light strip. 

<a href="url"><img src="https://github.com/nrutkowski1/Android_Bluetooth_LED_Control/blob/master/Images/schematic.png" height="300"></a>

Using the schematic above I designed a PCB which is used as a shield for the Arduino UNO.

<a href="url"><img src="https://github.com/nrutkowski1/Android_Bluetooth_LED_Control/blob/master/Images/pcb.png" height="300"></a>

