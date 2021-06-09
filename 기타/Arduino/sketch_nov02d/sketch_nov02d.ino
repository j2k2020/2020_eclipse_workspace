#define D1 10
#define D2 11
#define D3 12
#define D4 13

#define SCK_PIN A4
#define DAT_PIN A3
#define RST_PIN A2
#include <DS1302.h>
//분,초만 출력
DS1302 rtc(RST_PIN,DAT_PIN,SCK_PIN);

void setup() {
  Serial.begin(9600);
 //7segment 초기화
 for(int i=2;i<10;i++){
 pinMode(i,OUTPUT);
 digitalWrite(i,LOW);
 }
 //DIGITAL PIN 초기화
 for(int i=10;i<=13;i++){
  pinMode(i,OUTPUT);
 digitalWrite(i,HIGH);
 }

//시계
rtc.halt(false); //중지 제거
rtc.writeProtect(false); //쓰기 방지 제거
Serial.begin(9600);

//날짜 설정
rtc.setDOW(TUESDAY);
rtc.setTime(16,20,34);
rtc.setDate(3,11,2020);
}
bool num[10][8]={{1,1,1,1,1,1,0,0},
                 {0,1,1,0,0,0,0,0},
                 {1,1,0,1,1,0,1,0},
                 {1,1,1,1,0,0,1,0},
                 {0,1,1,0,0,1,1,0},
                 {1,0,1,1,0,1,1,0},
                 {1,0,1,1,1,1,1,0},
                 {1,1,1,0,0,0,0,0},
                 {1,1,1,1,1,1,1,0},
                 {1,1,1,1,0,1,1,0}
                };
                
void digitalNumber(int n){
for(int i=0;i<8;i++){
          digitalWrite(i+2,num[n][i]);
      }
}

void digitalNumber(int Dpin,int n){
  digitalWrite(Dpin,0); //0=LOW
for(int i=0;i<8;i++){
          digitalWrite(i+2,num[n][i]);
      }
}

void digitalPinInit(){
  //DIGITAL PIN 초기화
 for(int i=10;i<=13;i++){
  pinMode(i,OUTPUT);
 digitalWrite(i,HIGH);
 }
}
//20,34
String realTime=rtc.getTimeStr();
int irt[4];
void forDigitNum(){
  //1. 숫자를 분리
 irt[0]=realTime.charAt(3)-'0';
 irt[1]=realTime.charAt(4)-'0';
 irt[2]=realTime.charAt(6)-'0';
 irt[3]=realTime.charAt(7)-'0';
 for(int i=0;i<4;i++){
  Serial.println(irt[i]);
}
  /*
  n[3]=num/1000;
  n[2]=num/100-(n[3]*10);
  n[1]=num/10-(n[3]*100)-(n[2]*10);
  n[0]=num/1-(n[3]*1000)-(n[2]*100)-(n[1]*10);
  */
for(int i=13;i>9;i--){
  digitalNumber(i,irt[i-10]);
  delay(3);
  digitalPinInit();
 }
  
}
void loop() {
 forDigitNum();
 //데이터 분리 확인하는 작업
 /*for(int i=3;i>-1;i--){
  Serial.println(n[i]);
  delay(1000);
 }*/

}
