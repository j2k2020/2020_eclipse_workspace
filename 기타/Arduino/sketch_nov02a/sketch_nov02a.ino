#define D1 10
#define D2 11
#define D3 12
#define D4 13

void setup() {
  //7segment 초기화
 
 for(int i=2; i<10; i++){
  pinMode(i,OUTPUT);
  digitalWrite(i,LOW);
  }
  
  //digital pin 초기화
for(int i=10; i<=13; i++){
  pinMode(i,OUTPUT);
  digitalWrite(i,HIGH);
}


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
          digitalWrite(i+2,num[n][i]); }
}

void digitalNumber(int Dpin, int n){
  digitalWrite(Dpin,0); //0 = LOW
for(int i=0;i<8;i++){
          digitalWrite(i+2,num[n][i]); }
}

void digitalPinInit(){ //핀을 초기화
   //digital pin 초기화
for(int i=10; i<=13; i++){
  pinMode(i,OUTPUT);
  digitalWrite(i,HIGH);
}

//010 9005 8029 전화번호~
void loop() {
  digitalNumber(D1,0);
  delay(500);
   digitalPinInit();
   digitalNumber(D2,1);
  delay(500);
   digitalPinInit();
   digitalNumber(D3,0);
  delay(500);
   digitalPinInit();
   delay(500);
   
   digitalNumber(D1,9);
  delay(500);
   digitalPinInit();
 digitalPinInit();
   digitalNumber(D2,0);
  delay(500);
   digitalPinInit();
   digitalNumber(D3,0);
  delay(500);
   digitalPinInit();
    digitalNumber(D4,5);
  delay(500);
  digitalPinInit();
  delay(500);
  
   digitalNumber(D1,8);
  delay(500);
  digitalPinInit();
 digitalNumber(D2,0);
  delay(500);
   digitalPinInit();
   digitalNumber(D3,2);
  delay(500);
   digitalPinInit();
    digitalNumber(D4,9);
  delay(500);
  digitalPinInit();
  delay(500);
  

}
