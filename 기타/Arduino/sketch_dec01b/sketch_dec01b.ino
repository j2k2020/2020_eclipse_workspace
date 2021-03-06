//카드찍어서, 서보모터 움직이기(카드찍을 때마다 열리고,닫히고)
/*
RFID - RC522
#1, SDA     -    10~
#2, SCK      -    13
#3, MOSI    -    11
#4, MISO    -    12
#5, IRQ       -    N.C(연결 안 함)
#6, GND     -    GND
#7, RST       -    9
#8, 3.3V      -   3.3V

MG995 서보
#1, Red(VCC)          -   5V
#2, Orange (PWM) -   6~
#3, Brown(GND)     -   GND
*/

#include <Servo.h>
#include <SPI.h>
#include <MFRC522.h>
#define RST_PIN 9 //리셋 핀
#define SS_PIN 10 //셀렉트 핀
int angle=0;

MFRC522 mfrc522(SS_PIN,RST_PIN);
Servo servo;

void setup() {
servo.attach(3);
servo.write(angle);

  Serial.begin(9600);
  SPI.begin();
  mfrc522.PCD_Init(); //mfrc초기화 함수
  mfrc522.PCD_DumpVersionToSerial(); //RFID펌웨어 버전 확인

}

void loop() {
 if(!mfrc522.PICC_IsNewCardPresent()) return; //카드 인식 후 다음으로 아니면 실행x
 if(!mfrc522.PICC_ReadCardSerial()) return; //id가 읽혀졌으면 다음으로 아니면 실행x
/*
Serial.println(mfrc522.uid.uidByte[0],HEX);
Serial.println(mfrc522.uid.uidByte[1],HEX);
Serial.println(mfrc522.uid.uidByte[2],HEX);
Serial.println(mfrc522.uid.uidByte[3],HEX);
//                                                            Firmware Version: 0x92 = v2.0
//8B
//D0
//88
//22
*/

Serial.write(mfrc522.uid.uidByte[0]);
Serial.write(mfrc522.uid.uidByte[1]);
Serial.write(mfrc522.uid.uidByte[2]);
Serial.write(mfrc522.uid.uidByte[3]);

mfrc522.PICC_HaltA(); //PICC종료
mfrc522.PCD_StopCrypto1(); //암호화 종료 

}
