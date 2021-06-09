//배열 방법
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
Serial.println(realTime);
char rt[9];
realTime.toCharArray(rt,9);
int irt[4];
irt[0]=rt[3]-'0';
irt[1]=rt[4]-'0';
irt[2]=rt[6]-'0';
irt[3]=rt[7]-'0';
for(int i=0;i<4;i++){
  Serial.println(irt[i]);
}
/*1st
 * char realTime[9];
strcpy(realTime,(char*)realTime);

int irt[4];
irt[0]=realTime[3]-'0';
irt[1]=realTime[4]-'0';
irt[2]=realTime[6]-'0';
irt[3]=realTime[7]-'0';
*/
}


void loop() {
  
}
