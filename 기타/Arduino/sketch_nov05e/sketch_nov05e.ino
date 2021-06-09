//I2c통신Slave( Recv )
#include<Wire.h>
#define SLAVE 4 //slave주소(핀과는 상관없이 임으로 설정 가능)
void setup() {
 Wire.begin(SLAVE); //4번지에서 오는 것만 받겠다고 선언.
 Serial.begin(9600);
 Wire.onRequest(onMaster);
 
}

char i='1';
void onMaster(){
if(i=='9') i='1'; //1~8까지 출력
Wire.write(i++);
 
  
}



void loop() {
  

}
