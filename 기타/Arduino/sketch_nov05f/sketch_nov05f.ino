//SPI통신Master( Send )
#include <SPI.h>
#define chipSelect 10//HIGH 슬레이버 선택되지 않은 상태, LOW 선택된 상태
void setup() {
  Serial.begin(9600);
 SPI.begin();
 pinMode(chipSelect, OUTPUT);
 digitalWrite(chipSelect,HIGH);//슬레이브 선택 안된 상태
 SPI.setClockDivider(SPI_CLOCK_DIV16); //DIV16=16Mhz DIV8=8Mhz
}
byte data;
void loop() {
  char p[10]="hello\n";
  
 
      //master->slave chip select
      digitalWrite(chipSelect,LOW);
      //master->slave전송코드
      for(int i=0;i<6;i++){
       data=SPI.transfer(p[i]);
       Serial.print((char)data);
       //SPI.transfer(p[i]);
        
      }
      digitalWrite(chipSelect,HIGH);
      

//delay(1000);
}
