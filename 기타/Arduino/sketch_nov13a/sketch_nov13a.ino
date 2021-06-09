//2상여자
#define IN1 8
#define IN2 9
#define IN3 10
#define IN4 11

#define STEP 4096 //2048*2배
int pinArray[4]={IN1, IN2, IN3, IN4};

int CW[8]={
           0b1000,//1
           0b1100,//2
           0b0100,//3
           0b0110,//4
           0b0010,//5
           0b0011,//6
           0b0001,//7
           0b1001//8
           };

int CCW[8]={
           0b1000,//1
           0b1001,//2
           0b0001,//3
           0b0011,//4
           0b0010,//5
           0b0110,//6
           0b0100,//7
           0b1100//8
           };

void setup() {
  for(int i=0; i<4; i++){
    pinMode(pinArray[i],OUTPUT);  }
}

void loop() {
  int temp;
  for(int i=0; i<STEP; i++){
    temp=i%8;
    digitalWrite(pinArray[0],bitRead(CW[temp],0));
    digitalWrite(pinArray[1],bitRead(CW[temp],1));
    digitalWrite(pinArray[2],bitRead(CW[temp],2));
    digitalWrite(pinArray[3],bitRead(CW[temp],3));
delay(1); //스텝이 4에서 8로 늘어났으므로 딜레이를 줄여준다.
  }
delay(1000);

//반대로 돔.
for(int i=0; i<STEP; i++){
    temp=i%8;
    digitalWrite(pinArray[0],bitRead(CCW[temp],0));
    digitalWrite(pinArray[1],bitRead(CCW[temp],1));
    digitalWrite(pinArray[2],bitRead(CCW[temp],2));
    digitalWrite(pinArray[3],bitRead(CCW[temp],3));
delay(1);
  }
delay(1000);
}
