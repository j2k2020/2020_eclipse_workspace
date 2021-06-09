//SPI통신Slave( Recv )
#include <SPI.h>
#define chipSelect 10

void setup() {
 pinMode(MOSI,INPUT);//D11번 핀
 pinMode(MISO,OUTPUT);//D12번 핀
 pinMode(SCK,OUTPUT);//D13번 핀
 pinMode(chipSelect,INPUT); // CHIP SELECT

 SPI.setClockDivider(SPI_CLOCK_DIV16);
//SPI통신 레지스터 설정
//SPI 활성화
SPCR |=_BV(SPE);
//슬레이브모드 변경
SPCR &=~_BV(MSTR);
//인터럽트 허용
SPCR |=_BV(SPIE);

Serial.begin(9600);
}
volatile byte c;

void loop() {
if(c!='_'){
   Serial.print((char)c);
   c='_';
}
//delay(1000);
}
//spi통신은 인터럽트를 이용해서 데이터 수신
ISR(SPI_STC_vect){
 c=SPDR;

 //SPDR='a';
 }
