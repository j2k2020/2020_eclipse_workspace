//indexOf방법
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

Serial.println(rtc.getTimeStr());
String  t="16:20:34";
String min,sec;
//(3자리부터,3번째자리 뒤의 숫자4번째자리부터 출력가능)
Serial.println(t.substring(3,5));
//min=t.substring(3,5);
Serial.println(t.substring(6,8));
//sec=t.substring(6,8);

//Serial.println(t.indexOf(':'));
min=t.substring(t.indexOf(':')+1,t.indexOf(':')+1+2); //t.substring(3,5)

//Serial.println(t.lastIndexOf(':'));
sec=t.substring(t.lastIndexOf(':')+1,t.lastIndexOf(':')+1+2);

}


void loop() {
  /*
  Serial.println(String("요일:")+rtc.getDOWStr());
  Serial.println(String("날짜:")+rtc.getDateStr());
  Serial.println(String("시간:")+rtc.getTimeStr());
//Serial.println(rtc.getTimeStr());

//14:25:0
String m=rtc.getTimeStr();
Serial.println(String("찾는 위치:")+m.indexOf(':'));
Serial.println(String("문자 분리:")+m.substring(3,8));

delay(2000);
*/
}
