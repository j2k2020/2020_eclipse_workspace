//I2c통신Master( Send )
//DATA PIN 1개=A4, CLK PIN 1개=A5 
#include<Wire.h>
#define SLAVE 4 //slave주소(핀과는 상관없이 임으로 설정 가능)
void setup() {
  Wire.begin();
  Serial.begin(9600);
}

void loop() {
  Wire.requestFrom(SLAVE,1); //(4번 주소로부터, 1바이트 수신)
   Wire.requestFrom(SLAVE,sizeof(int));
  char data=Wire.read();
  Serial.println(data);
  delay(1000);
  
}
