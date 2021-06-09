byte startbyte=0x7E;
  int joyX;
  int highX=0;
  int lowX=0; 
  byte dataLen=2;
  byte endbyte=0xFE;
  
void setup() {
  
  Serial.begin(9600);  
}


void loop() {
  
  joyX=analogRead(A0);
  
  if(joyX>255){
    highX=joyX>>8;
    lowX=0x00FF & joyX;
  }else{
    highX=0;
    lowX=joyX;
  }

Serial.write(startbyte);
Serial.write(dataLen);
Serial.write(highX);
Serial.write(lowX);
Serial.write(endbyte);
delay(1100);
}
