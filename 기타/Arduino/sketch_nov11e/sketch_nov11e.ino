//버퍼로 받고,출력,메모리 밀기(2)
byte startbyte=0x7E;
int joyX;
int highX=0;
int lowX=0;
byte dataLen=2;
byte endbyte=0xFE;

void setup() {
  Serial.begin(9600);
  
  
}
//아두이노에서 숫자를 보내나 
//문자를 보내나 문자로 인식
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
delay(600);
}
