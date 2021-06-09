//배열 방법(2)
#define SCK_PIN A4
#define DAT_PIN A3
#define RST_PIN A2
#include <DS1302.h>
//분,초만 출력
DS1302 rtc(RST_PIN,DAT_PIN,SCK_PIN);

void setup() {
rtc.halt(false); //중지 제거
rtc.writeProtect(false); //쓰기 방지 제거
Serial.begin(9600);

//날짜 설정
rtc.setDOW(TUESDAY);
rtc.setTime(16,20,34);
rtc.setDate(3,11,2020);

//2nd
String realTime=rtc.getTimeStr();
int irt[4];
irt[0]=realTime.charAt(3)-'0';
irt[1]=realTime.charAt(4)-'0';
irt[2]=realTime.charAt(6)-'0';
irt[3]=realTime.charAt(7)-'0';
for(int i=0;i<4;i++){
  Serial.println(irt[i]);
}


void loop() {
  
}
