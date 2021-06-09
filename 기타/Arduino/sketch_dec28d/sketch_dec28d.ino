//소켓통신(3) + 서버모트

#include <Servo.h>
Servo servo;

void setup() {
Serial.begin(9600);
servo.attach(6); //6번핀
servo.write(0);
}

void loop() {}

void serialEvent(){
  byte data[1024]={0,};
   Serial.readBytes(data,sizeof(data)-1);
   int motor =atoi(data);
   servo.write(motor);
}
