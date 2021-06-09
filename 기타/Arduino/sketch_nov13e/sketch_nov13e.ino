//카드찍어서, 서보모터 움직이기(카드찍을 때마다 열리고,닫히고)
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
 
if(!mfrc522.PICC_IsNewCardPresent()) return;
  if(!mfrc522.PICC_ReadCardSerial()) return;
  //mfrc522.PICC_DumpToSerial(&(mfrc522.uid));
  //delay(1000);

   Serial.println(mfrc522.uid.uidByte[0],HEX);
   Serial.println(mfrc522.uid.uidByte[1],HEX);
   Serial.println(mfrc522.uid.uidByte[2],HEX);
   Serial.println(mfrc522.uid.uidByte[3],HEX);


  if(mfrc522.uid.uidByte[0]==0x8B &&
  mfrc522.uid.uidByte[1]==0xD0 &&
  mfrc522.uid.uidByte[2]==0x88 &&
  mfrc522.uid.uidByte[3]==0x22){
    servo.write(180);
  }
  else if(!mfrc522.uid.uidByte[0]==0x8B &&
  !mfrc522.uid.uidByte[1]==0xD0 &&
  !mfrc522.uid.uidByte[2]==0x88 &&
  !mfrc522.uid.uidByte[3]==0x22){ 
    Serial.print("Your tag is not of type MIFARE Classic.");
    }
  
  
 
   mfrc522.PICC_HaltA();
   mfrc522.PCD_StopCrypto1();
}
