// 4=210 / 1024+210를 하면 1234가 나온다.
// 0000/0000/1101/0010
// 0000/0000/(128) (64) 32 (16)/8 4 (2) 1  --> 표현할 수 있는 수 0~255 (128+127=255)
//128+64+16+2=210 (4라는 HEX코드의 값이 210이다) 이 값을 구해서, 16비트(총 1024)에 더히면 시리얼통신으로 보냈던 숫자(1234)가 나오게 된다.
 
void setup() {
  Serial.begin(9600);
  byte startbyte=0x7E;
  int sensor=1234;
  int highSensor=0;
  int lowSensor=0;
  if(sensor>255){
    highSensor=sensor>>8;
    lowSensor=0x00FF & sensor;
  }else{
    highSensor=0;
    lowSensor=sensor;
  }
  //int dataLen=String(sensor).length();
 // byte dataLen=String(sensor).length();
 byte dataLen=2;
  byte endbyte=0xFE;
/*
Serial.print(startbyte,HEX); //7E=126
Serial.print(dataLen,HEX); //4=4
Serial.print(sensor); //1234=210
Serial.print(endbyte,HEX); //FE=254
 */
Serial.write(startbyte);
Serial.write(dataLen);
Serial.write(highSensor);
Serial.write(lowSensor);
Serial.write(endbyte);
delay(1000);
}
//아두이노에서 숫자를 보내나 
//문자를 보내나 문자로 인식
void loop() {
  
}
