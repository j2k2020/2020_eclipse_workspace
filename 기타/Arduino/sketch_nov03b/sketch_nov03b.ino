#define SCK_PIN A4
#define DAT_PIN A3
#define RST_PIN A2
#include <DS1302.h>

DS1302 rtc(RST_PIN,DAT_PIN,SCK_PIN);

void setup() {
rtc.halt(false); //중지 제거
rtc.writeProtect(false); //쓰기 방지 제거
Serial.begin(9600);

//날짜 설정
rtcc.setDOW(THURSDAY);
rtc.setTime(14,25,0);
rtc.setDate(3,11,2020);
Serial.println(THURSDAY);

}


void loop() {
Serial.println(rtc.getTimeStr());

}
