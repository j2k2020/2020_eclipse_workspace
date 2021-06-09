//아두이노에서 숫자를 보내든, 문자를 보내든 문자로 인식  //49-'0'->숫자변환
/* networkData{ 
  byte startbyte;
  byte dataLen;
  int highSensor;
  int lowSensor;
  byte endbyte;

//구조체에 데이터 넣기
 data.startbit=startbit;
 data.dataLen=dataLen;
 data.highsensor=highsensor;
 data.lowsensor=lowsensor;
 data.endbyte=endbyte;
 
}data; //--->구조체는 현재 아두이노에서 실행 불가!!
*/


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
 //int dataLen=String(sensor).length(); //길이 구하기
 //byte dataLen=String(sensor).length();
 byte dataLen=2;
 byte endbyte=0xFE;
  
 //숫자를 보냄->
 
 //Serial.write(data); ->구조체는 아두이노에서는 실행 불가! 
 
 Serial.write(startbyte);
 Serial.write(dataLen);
 Serial.write(highSensor);
 Serial.write(lowSensor);
 Serial.write(endbyte);
 
 
/* 
 Serial.print(startbyte,HEX);
 Serial.print(dataLen,HEX);
 Serial.print(sensor);
 Serial.print(endbyte,HEX);
 */

/* //processing에 123을 보냈을 때
Serial.print( 7E=55,69 /3=51 /123=49,50,51 /FE=70,69 )
Serial.write( 7E=126 /3=3 /123=123 /FE=254 )

//processing에 1234을 보냈을 때
Serial.write( 7E=126 /4=4 /1234=210 /FE=254 )
*/
}

//**시작코드/데이터 길이/데이터/(패리티비티(오류))/종료코드**
void loop() {
 
}
