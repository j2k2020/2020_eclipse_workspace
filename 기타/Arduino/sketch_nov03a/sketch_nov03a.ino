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
rtc.setDOW(TUESDAY);
rtc.setTime(14,25,0);
rtc.setDate(3,11,2020);
Serial.println(String("월")+MONDAY);
Serial.println(String("화")+TUESDAY);
Serial.println(String("수")+WEDNESDAY);
Serial.println(String("목")+THURSDAY);
Serial.println(String("금")+FRIDAY);
Serial.println(String("토")+SATURDAY);
Serial.println(String("일")+SUNDAY);
}


void loop() {
  Serial.println(String("요일:")+rtc.getDOWStr());
  Serial.println(String("날짜:")+rtc.getDateStr());
  Serial.println(String("시간:")+rtc.getTimeStr());
//Serial.println(rtc.getTimeStr());
delay(1000);

}
