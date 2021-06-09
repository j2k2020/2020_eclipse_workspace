#include <Stepper.h>

 //회전각도 설정 = 2048:한바퀴(360도), 1024:반바퀴(180도)
const int stepsPerRevolution=2048; //360도

  //모터 드라이브에 연결된 핀 int4, int2, int3, int1(핀연결 설정)
Stepper myStepper(stepsPerRevolution, 11, 9, 10, 8);

void setup() {
myStepper.setSpeed(15);
  Serial.begin(9600);
}


void loop() {
  //시계 반대 방향으로 한바퀴 회전
  Serial.println("counterclockwise");
  myStepper.step(stepsPerRevolution);
  delay(100);

   //시계 방향으로 한바퀴 회전
  Serial.println("clockwise");
  myStepper.step(-stepsPerRevolution);
  delay(100);

}
