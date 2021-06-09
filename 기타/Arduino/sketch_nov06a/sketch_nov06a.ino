int latchPin = 4; //12 RCLK latch pin
int clockPin = 3; //11 SCK clock pin
int dataPin = 2; //14 SER data pin
segement_num[10]={252,96,218,242,102,182,190,224,254,246};
segement_num[4][10]={1,{252,96,218,242,102,182,190,224,254,246}};
void setup() {
  pinMode(latchPin, OUTPUT);
  pinMode(clockPin, OUTPUT);
  pinMode(dataPin, OUTPUT);

  digitalWrite(latchPin,LOW); //LOW일때는 데이터x
   //shiftOut(dataPin,clockPin,LSBFIRST,1); //dp(도트)만 켜짐
   //shiftOut(dataPin,clockPin,MSBFIRST,1); //a만 켜짐
   //shiftOut(dataPin,clockPin,MSBFIRST,2); //a만 켜짐
    shiftOut(dataPin,clockPin,LSBFIRST,242);
    //255 -> 전체 다 켜짐
    //252 -> 0 
    //96->1 
    //242->2
    //242 , 102, 182, 190, 224, 254, 246 
  
  digitalWrite(latchPin,HIGH);
}


void loop() {
  for(int i=0; i<10; i++){
    
  }

}
