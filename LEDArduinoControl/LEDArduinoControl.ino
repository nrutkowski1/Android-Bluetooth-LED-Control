#include <SoftwareSerial.h>
#include <string.h>
#include <FastLED.h>

/**
 * define the bluetooth rx and tx pins
 */
SoftwareSerial BT(10, 11); // RX | TX

/**
 * NEED SWITCHES 2,3,5,6 AND THEN DONE
 */

/**
 * define constants in code 
 */
#define data 3  //use whichever digital pin you want
#define num_leds 300  //change for your led strip
#define led_type WS2812   //the code I have written is for WS2812 idk if how itll work on other types
#define color_order GRB //change to approriate color order
#define strobeRate 100  //only used if you want a strobe effects

float audio;
float calc;

uint8_t gHue = 0;
uint8_t hue = 0;

int curRed;
int curGreen;
int curBlue;

boolean isActive = false; //not currently used

CRGB leds[num_leds];  //define your array of leds

String holdInput = "";
String hold = "";

void setup(){

  pinMode(data, OUTPUT);  //setup data pin

  FastLED.addLeds<led_type, data, color_order>(leds, num_leds).setCorrection(TypicalSMD5050); //define the lights

  /**
   * initially set all of the lights to be turned off
   */
  for(int i = 0; i < num_leds; i++){

    leds[i] = CRGB(0,0,0);
  }
  /**
   * open serial port and bluetooth port
   * change the bluetooth value depending on the baud rate of your bluetooth module
   * I used the HC-05 whihc has a default of 9600 
   */
  Serial.begin(38400);
  //Serial.println("Enter AT commands!");
  BT.begin(38400); //Baud Rate for command Mode. 
}

/**
 * reads the data from the bluetooth and processes it based on characters defined in the app
 */
void readInputData(){

  if(BT.available()){

    char inputData = BT.read();
    holdInput.concat(inputData);

    String identifier = "";

    //Serial.println(holdInput);

    if(inputData == '\n'){

      identifier = holdInput.substring(0, 1);

      if(identifier == "x"){

        readColorData(holdInput);
      }
      if(identifier == "y"){
        
        readEffectsData(holdInput);
      }
      if(identifier == "z"){

        readColorPatternData(holdInput);
      }
      
      holdInput = "";
    }
  }
}

/**
 * processes the solid light color data 
 * from the app (tabs 1 and 3).
 * sets the strand of lights to one solid color
 * If your power supply does not meet the 
 * current requirements for your led strip the solid
 * color lights may have a gradient effect
 */
void readColorData(String colorData){

  String red = "";
  String green = "";
  String blue= "";

  int R_Index;
  int G_Index;
  int B_Index;
  int end_Index;

  int r_val = 0;
  int g_val = 0;
  int b_val = 0;

  for(int i = 0; i < colorData.length() + 1; i++){
      
    R_Index = colorData.indexOf("R");
    G_Index = colorData.indexOf("G");
    B_Index = colorData.indexOf("B");
    end_Index = colorData.indexOf('\n');
  }
         
  red = colorData.substring(R_Index, G_Index);
  green = colorData.substring(G_Index, B_Index);
  blue = colorData.substring(B_Index, end_Index);
      
  red.remove(0,1);
  blue.remove(0,1);
  green.remove(0,1);

  r_val = red.toInt();
  g_val = green.toInt();
  b_val = blue.toInt();
          
  //Serial.println(r_val);
  //Serial.println(g_val);
  //Serial.println(b_val);

  setColorLight(r_val, g_val, b_val);

  curRed = r_val;
  curGreen = g_val;
  curBlue = b_val;

  colorData = "";
}

/**
 * this function determines which switch has been pressed in the "effects" tab
 * in the app and then begins the function for the desired effect
 */
void readEffectsData(String effectData){
  
  String s = "";
  s = effectData.substring(effectData.length() - 2, effectData.length() - 1);
  
  int switchType;
  switchType = s.toInt();

  //start the function for the desired effect based on switch pressed
  //change the functions in each case to whatever you like this is what I chose, you can write your own functions are below
  switch(switchType){
    case 0:
      setDefault();
      //Serial.println(switchType);
      //return 0;
      break;
    case 1:
      Serial.println(switchType);
      strobeMusic();
      //return 1;
      break;
    case 2:
      Serial.println(switchType);
      //changeColorMusic();
      musicColor();
      //return 2;
      break;
    case 3:
      Serial.println(switchType);
      musicColor2();
      //return 3;
      break;
    case 4:
      Serial.println(switchType);
      changeColor();
      //return 4;
      break;
    case 5:
      Serial.println(switchType);
      strobe();
      //return 5;
      break;
    case 6:
      Serial.println(switchType);
      //changeColorStrobe();
      //return 6;
      break;
    case 7:
      Serial.println(switchType);
      rainbow();
      //return 7;
      break;
    case 8:
      Serial.println(switchType);
      //placeholder();
      juggle();
      //return 8;
      break;
    case 9:
      Serial.println(switchType);
      //placeholder();
      bpm();
      //return 9;
      break;
  }
}

//this sets a specific light to a specific color as used in tab 4
void readColorPatternData(String colorPatternData){
  
  String red = "";
  String green = "";
  String blue = "";
  String lightNum = "";

  int R_Index;
  int G_Index;
  int B_Index;
  int L_Index;
  int end_Index;

  int r_val = 0;
  int g_val = 0;
  int b_val = 0;
  int lightNum_val = 0;

  for(int i = 0; i < colorPatternData.length() + 1; i++){
      
    R_Index = colorPatternData.indexOf("R");
    G_Index = colorPatternData.indexOf("G");
    B_Index = colorPatternData.indexOf("B");
    L_Index = colorPatternData.indexOf("L");
    end_Index = colorPatternData.indexOf('\n');
  }
         
  red = colorPatternData.substring(R_Index, G_Index);
  green = colorPatternData.substring(G_Index, B_Index);
  blue = colorPatternData.substring(B_Index, L_Index);
  lightNum = colorPatternData.substring(L_Index, end_Index);
  
      
  red.remove(0,1);
  blue.remove(0,1);
  green.remove(0,1);
  lightNum.remove(0,1);

  r_val = red.toInt();
  g_val = green.toInt();
  b_val = blue.toInt();
  lightNum_val = lightNum.toInt();
          
  //Serial.println(r_val);
  //Serial.println(g_val);
  //Serial.println(b_val);
  //Serial.println(lightNum_val);

  setColorPattern(r_val, g_val, b_val, lightNum_val);

  colorPatternData = "";
}

/**
 * this is the default effect
 * everytime an effect is turned off
 * the led strip displays the color it was previously set to
 * before the effect was turned on
 */
void setDefault(){

  fill_solid(leds, num_leds, CRGB(curRed,curGreen,curBlue));
  FastLED.show();
}
/**
 * sets the entire strand of lights to a single solid color
 * WARNING: may create a gradient pattern if the power supply 
 * has an insufficient current supply
 */
void setColorLight(int red, int green, int blue){

  fill_solid(leds, num_leds, CRGB(red, green, blue));
  FastLED.setBrightness(255);
  FastLED.show();   
}
/**
 * this sets a single specific light to a specific color
 */
void setColorPattern(int red, int green, int blue, int num){

  leds[num - 1] = CRGB(red, green, blue);
  FastLED.setBrightness(255);
  FastLED.show();
}

/**
 * reads an aux input and sets the brightness of the 
 * led strip based on the analog reading of the aux input. 
 * 
 * due to the current method used to loop the function and read the bluetooth input,
 * when you turn the switch off in the app the arduino may not respond immediately 
 * and must be pressed multiple times. I am working to fix this issue.
 */
void strobeMusic(){

    while(true){
      
      audio = analogRead(A2);
      calc = map(audio, 0, 700, 0, 255);

      FastLED.setBrightness(calc);
      FastLED.show();
      FastLED.delay(125);
      
      if(BT.available()){
        
        char inputData = BT.read();
        
        hold.concat(inputData);

        if(inputData == '\n'){
        
            String s = "";
          
            s = hold.substring(hold.length() - 2, hold.length() - 1);
  
            int switchType;
            switchType = s.toInt();

            Serial.println(switchType);

            if(switchType == 0){

              setDefault();
              break;
      
          hold = "";
          }
        }
      }
   }
}
/**
 * this cycles through colors based on the aux input.
 * the greater the difference in the aux input the more significant 
 * of a color change i.e.
 * 
 * small change in aux input results in color change from red -> orange
 * large change in aux input results in color change from red -> green
 * 
 * still working to develop this more
 * 
 * due to the current method used to loop the function and read the bluetooth input,
 * when you turn the switch off in the app the arduino may not respond immediately 
 * and must be pressed multiple times. I am working to fix this issue.
 */
void musicColor(){

  while(true){
    
    audio = analogRead(A2);
    calc = map(audio, 0, 700, 0, 200);

    gHue += calc;

    fill_solid(leds, num_leds, CHSV(gHue, 200, 255));
    
    FastLED.show();
    FastLED.delay(125);
    
    if(BT.available()){
        
        char inputData = BT.read();
        
        hold.concat(inputData);

        if(inputData == '\n'){
        
            String s = "";
          
            s = hold.substring(hold.length() - 2, hold.length() - 1);
  
            int switchType;
            switchType = s.toInt();

            Serial.println(switchType);

            if(switchType == 0){

              setDefault();
              break;
      
          hold = "";
          }
        }
      }
  }
} 

/**
 * the entire strand of lights is a solid color but the
 * color changes based on the aux input
 * 
 * the lights cycle from:
 * 
 * pink->purple->blue->green->yellow->orange->red
 * 
 * this corresponds to an aux input which goes from low->high
 * low being pink and high being red
 * 
 * due to the current method used to loop the function and read the bluetooth input,
 * when you turn the switch off in the app the arduino may not respond immediately 
 * and must be pressed multiple times. I am working to fix this issue.
 */
void musicColor2(){

  while(true){

    FastLED.setBrightness(150);
    audio = analogRead(A2);
    calc = map(audio, 0, 700, 0, 70);

    if(calc < 10){

      fill_solid(leds, num_leds, CRGB(255, 0, 188));
      FastLED.show();
    }
    else if (calc < 20){

      fill_solid(leds, num_leds, CRGB(213, 0, 255));
      FastLED.show();
    }
    else if(calc < 30){

      fill_solid(leds, num_leds, CRGB(0, 9, 255));
      FastLED.show();
    }
    else if(calc < 40){

      fill_solid(leds, num_leds, CRGB(0, 255, 26));
      FastLED.show();
    }
    else if(calc < 50){

      fill_solid(leds, num_leds, CRGB(213, 255, 0));
      FastLED.show();
    }
    else if(calc < 60){

      fill_solid(leds, num_leds, CRGB(255, 128, 0));
      FastLED.show();
    }
    else{

      fill_solid(leds, num_leds, CRGB(255, 0, 0));
      FastLED.show();
    }
    
    FastLED.delay(125);
    
    if(BT.available()){
        
        char inputData = BT.read();
        
        hold.concat(inputData);

        if(inputData == '\n'){
        
            String s = "";
          
            s = hold.substring(hold.length() - 2, hold.length() - 1);
  
            int switchType;
            switchType = s.toInt();

            Serial.println(switchType);

            if(switchType == 0){

              setDefault();
              break;
      
          hold = "";
          }
        }
      }
  }
}

/**
 * this randomly picks a set of 3 lights to turns on and the slowly fade to black
 * each set of lights also is assigned a color with a random hue and gHue which is added to in the loop to constantly 
 * scroll through different colors. 
 * 
 * due to the current method used to loop the function and read the bluetooth input,
 * when you turn the switch off in the app the arduino may not respond immediately 
 * and must be pressed multiple times. I am working to fix this issue.
 */
void changeColor(){

  while(true){

    EVERY_N_MILLISECONDS(20){gHue += 4;}
    fadeToBlackBy(leds, num_leds, 3);
    delay(20);
    int pos = random16(num_leds);
    if(pos == 0){
      leds[pos] += CHSV( gHue + random8(64), 200, 255);
      leds[pos+1] += CHSV( gHue + random8(64), 200, 255);
    }
    else if(pos == 299){
      leds[pos-1] += CHSV( gHue + random8(64), 200, 255);
      leds[pos] += CHSV( gHue + random8(64), 200, 255);
    }
    else{
      leds[pos-1] += CHSV( gHue + random8(64), 255, 255);
      leds[pos] += CHSV( gHue + random8(64), 255, 255);
      leds[pos+1] += CHSV( gHue + random8(64), 255, 255);
    }
    FastLED.show();

    if(BT.available()){
        
        char inputData = BT.read();
        
        hold.concat(inputData);

        if(inputData == '\n'){
        
            String s = "";
          
            s = hold.substring(hold.length() - 2, hold.length() - 1);
  
            int switchType;
            switchType = s.toInt();

            Serial.println(switchType);

            if(switchType == 0){

              setDefault();
              break;
      
          hold = "";
          }
        }
      }
  }
}

/**
 * takes the current color of the lights and strobes them at
 * a constant rate which can be changed above with the strobeRate variable
 * 
 * due to the current method used to loop the function and read the bluetooth input,
 * when you turn the switch off in the app the arduino may not respond immediately 
 * and must be pressed multiple times. I am working to fix this issue.
 */
void strobe(){

  while(true){
   
    setColorLight(curRed, curGreen, curBlue);
    FastLED.show();
    delay(strobeRate);
    setColorLight(0, 0, 0);
    FastLED.show();
    delay(strobeRate);

    if(BT.available()){
        
        char inputData = BT.read();
        
        hold.concat(inputData);

        if(inputData == '\n'){
        
            String s = "";
          
            s = hold.substring(hold.length() - 2, hold.length() - 1);
  
            int switchType;
            switchType = s.toInt();

            Serial.println(switchType);

            if(switchType == 0){

              setDefault();
              break;
      
          hold = "";
          }
        }
      }
  }
}

/**
 * this function creates a repeating rainbow along the entire strip of lights
 * the hue is updated each 20 ms by a value of 3 which causes the rainbow to constantly
 * shift the color in a cycle 
 * 
 * due to the current method used to loop the function and read the bluetooth input,
 * when you turn the switch off in the app the arduino may not respond immediately 
 * and must be pressed multiple times. I am working to fix this issue.
 */
void rainbow(){

  while(true){

    EVERY_N_MILLISECONDS(20){gHue += 3;}
    fill_rainbow(leds, num_leds, gHue, 7);
    FastLED.show();

    if(BT.available()){
        
    char inputData = BT.read();
        
    hold.concat(inputData);

    if(inputData == '\n'){
        
      String s = "";
          
      s = hold.substring(hold.length() - 2, hold.length() - 1);
  
      int switchType;
      switchType = s.toInt();

      Serial.println(switchType);

      if(switchType == 0){

        setDefault();
        hold = "";
        break;
      }
    }
  }
  }
}
/**
 * creates 8 different colored dots which randomly travel back and forth
 * along the led strip creating a trail behind them
 * 
 * due to the current method used to loop the function and read the bluetooth input,
 * when you turn the switch off in the app the arduino may not respond immediately 
 * and must be pressed multiple times. I am working to fix this issue.
 */
void juggle() {
  // eight colored dots, weaving in and out of sync with each other

  while(true){
    
    fadeToBlackBy( leds, num_leds, 10);
    byte dothue = 0;
    for( int i = 0; i < 8; i++) {
      leds[beatsin16(i+7,0,num_leds)] |= CHSV(dothue, 200, 255);
      dothue += 32;
    }
    FastLED.show();
    
    if(BT.available()){
        
    char inputData = BT.read();
        
    hold.concat(inputData);

    if(inputData == '\n'){
        
      String s = "";
          
      s = hold.substring(hold.length() - 2, hold.length() - 1);
  
      int switchType;
      switchType = s.toInt();

      Serial.println(switchType);

      if(switchType == 0){

        setDefault();
        hold = "";
        break;
      }
    }
  }
  }
}

/**
 * several colored strips pulsing at a specific rate
 * the colors shift by changing the hue of them each 20 ms
 * 
 * due to the current method used to loop the function and read the bluetooth input,
 * when you turn the switch off in the app the arduino may not respond immediately 
 * and must be pressed multiple times. I am working to fix this issue.
 */
void bpm(){

  while(true){
  // colored stripes pulsing at a defined Beats-Per-Minute (BPM)
    EVERY_N_MILLISECONDS(20){gHue += 2;}
    uint8_t BeatsPerMinute = 10;
    CRGBPalette16 palette = PartyColors_p;
    uint8_t beat = beatsin8( BeatsPerMinute, 64, 255);
    for( int i = 0; i < num_leds; i++) {
    
      leds[i] = ColorFromPalette(palette, gHue+(i*2), beat-gHue+(i*10));
    }
    FastLED.show();
    
    if(BT.available()){
        
    char inputData = BT.read();
        
    hold.concat(inputData);

    if(inputData == '\n'){
        
      String s = "";
          
      s = hold.substring(hold.length() - 2, hold.length() - 1);
  
      int switchType;
      switchType = s.toInt();

      Serial.println(switchType);

      if(switchType == 0){

        setDefault();
        hold = "";
        break;
      }
    }
  }
  }
}

void loop(){

  //bpm();
  //FastLED.show();
  //juggle();
  //FastLED.show();
  //strobeMusic();
  //changeColor();
  //musicColor();
  EVERY_N_MILLISECONDS(20){gHue += 5;}
  //bpm();
  readInputData();
}
