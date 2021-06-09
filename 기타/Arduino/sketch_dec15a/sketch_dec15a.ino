#include<SPI.h>
#include<MFRC522.h>
#define SS_PIN 10  //spi통신을 위한 ss(chip select)핀 설정
#define RST_PIN 9 //리셋 핀 설정
MFRC522 rfid(SS_PIN,RST_PIN); //'rfid'이름으로 클래스 객체 선언
MFRC522::MIFARE_Key key;
byte nuidPICC[4]; //카드 ID들을 저장(비교)하기 위한 배열(변수)선언

void setup() {
 Serial.begin(9600);
 SPI.begin();  //spi통신 시작
 rfid.PCD_Init(); //rfid(mfrc522)초기화
 
 //초기 키 ID 초기화
 for(byte i=0; i<6; i++){
  key.keyByte[i] = 0xFF;
 }
 //MIFARE 타입의 카드키 종류들만 인식됨을 표시
 Serial.println(F("This code scan the MIFARE classsic NUID"));
  Serial.print(F("Using the following key:"));
  printHex(key.keyByte, MFRC522::MF_KEY_SIZE);
}

void loop() {
  //카드가 인식되어 다음으로 넘어가고, 아니면 실행 안하고 리턴
  if( ! rfid.PICC_IsNewCardPresent())
  return;

  if( ! rfid.PICC_ReadCardSerial())
  return;

  Serial.print(F("PICC type:"));

  //카드의 타입을 읽어온다.
  MFRC522::PICC_Type piccType = rfid.PICC_GetType(rfid.uid.sak);

  //모니터에 출력
  Serial.println(rfid.PICC_GetTypeName(piccType));

  //MIFARE 방식인지 확인하고 아니면 리턴
  if(piccType != MFRC522::PICC_TYPE_MIFARE_MINI &&
  piccType != MFRC522::PICC_TYPE_MIFARE_1K &&
  piccType != MFRC522::PICC_TYPE_MIFARE_4K){
    Serial.println(F("Your tag is not of type MIFARE classic"));
    return;
  }

  //만약 바로 전에 인식한 RF카드와 다르면
  if(rfid.uid.uidByte[0] != nuidPICC[0] ||
  rfid.uid.uidByte[1] != nuidPICC[1] ||
  rfid.uid.uidByte[2] != nuidPICC[2] ||
  rfid.uid.uidByte[3] != nuidPICC[3] ){
    Serial.println(F("A new card has been detected"));

   //ID를 저장해둔다
   for(byte i=0; i<4; i++){
    nuidPICC[i] = rfid.uid.uidByte[i];
   }

   //모니터 출력
   Serial.println(F("The NUID tag is:"));

   Serial.println(F("In hex:"));
   //16진수로 변환해서 출력
   printHex(rfid.uid.uidByte, rfid.uid.size);
   Serial.println();

  // Serial.println(F("In dec:"));
   //10진수로 변환해서 출력
 //  printDec(rfid.uid.uidByte, rfid.uid.size);
 //  Serial.println();
  }
  else Serial.println(F("Card read previously"));

  rfid.PICC_HaltA();
  rfid.PCD_StopCrypto1();
}

//16진수로 변환 함수
void printHex(byte *buffer, byte bufferSize) {
  for (byte i = 0; i < bufferSize; i++) {
    Serial.print(buffer[i] < 0x10 ? " 0" : " ");
    Serial.print(buffer[i], HEX);
  }
}


/*
//10진수로 변환 함수
void printDec(byte *buffer, byte bufferSize) {
  for (byte i = 0; i < bufferSize; i++) {
    Serial.print(buffer[i] < 0x10 ? " 0" : " ");
    Serial.print(buffer[i], DEC);
  }
}
*/

//참고)https://rasino.tistory.com/221
