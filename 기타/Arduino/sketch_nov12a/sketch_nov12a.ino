byte startbyte=0x7E;
int joyX;
int joyY;
int highX=0;
int lowX=0;
int highY=0;
int lowY=0;
byte dataLen=4;
byte endbyte=0xFE;

void setup() {
  Serial.begin(9600);
   joyX=1234;
   joyY=1234;
   
  
  joyX=analogRead(A0);
  if(joyX>255){
    highX=joyX>>8;
    lowX=0x00FF & joyX;
  }else{
    highX=0;
    lowX=joyX;
  }
  
   if(joyY>255){
    highY=joyY>>8;
    lowY=0x00FF & joyY;
  }else{
    highY=0;
    lowY=joyY;
  }
 
Serial.write(startbyte);
Serial.write(dataLen);
Serial.write(highX);
Serial.write(lowX);
Serial.write(highY);
Serial.write(lowY);
Serial.write(endbyte);
delay(600);
  
}
void loop() {
  

}
