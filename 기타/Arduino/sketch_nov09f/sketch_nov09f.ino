#include <Servo.h>
Servo servo;
int angle=90; //서보모트의 각도

void setup() {
servo.attach(3);
servo.write(angle);
}


void loop() {
if(analogRead(A0)>700) {
  angle+=5; 
  if(angle<180){angle=180;} //angle의 값을 제어해줘야 됨. 제어가 않되면 실제 코드 실행 시, 제어가 잘 않되는 느낌이 듬.
}//모든 값은 제어 값을 줘야 됨!!! **중요~!!**
if(analogRead(A0)<400) {
  angle-=5;
  if(angle>0){angle=0;}
}
//servo.write(angle);
servo.write((float)analogRead(A0)/1023*180);
delay(100);
}
