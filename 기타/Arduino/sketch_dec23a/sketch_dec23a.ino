//이클립스에 RFID카드 데이터 보내기
#include <SPI.h>
#include <MFRC522.h>
#define RST_PIN 9 //리셋 핀
#define SS_PIN 10 //셀렉트 핀
MFRC522 mfrc522(SS_PIN,RST_PIN);
MFRC522::MIFARE_Key key;
byte nuidPICC[4];

void setup() {
  Serial.begin(9600);
  SPI.begin();
  mfrc522.PCD_Init(); //mfrc초기화 함수
}

void loop() {
if(!mfrc522.PICC_IsNewCardPresent()) return; //카드 인식 후 다음으로 아니면 실행x
if(!mfrc522.PICC_ReadCardSerial()) return; //id가 읽혀졌으면 다음으로 아니면 실행x
Serial.write(mfrc522.uid.uidByte,4);
//printHex(mfrc522.uid.uidByte,4);
mfrc522.PICC_HaltA();
mfrc522.PCD_StopCrypto1();
}

void printHex(byte *buffer, byte bufferSize) {
  for (byte i = 0; i < bufferSize; i++) {
   buffer[i] < 0x10 ? " 0" : " ";
  }
  Serial.write(buffer,bufferSize);
}
