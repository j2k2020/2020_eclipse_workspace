#define IN1 8
#define IN2 9
#define IN3 10
#define IN4 11

#define STEP 2048
int pinArray[4]={IN1, IN2, IN3, IN4};

int CW[4]={
           0b1000,
           0b0100,
           0b0010,
           0b0001 };

int CCW[4]={
           0b0001,
           0b0010,
           0b0100,
           0b1000 };

void setup() {
  for(int i=0; i<4; i++){
    pinMode(pinArray[i],OUTPUT);  }
}

void loop() {
  int temp;
  for(int i=0; i<STEP; i++){
    temp=i%4;
    digitalWrite(pinArray[0],bitRead(CW[temp],0));
    digitalWrite(pinArray[1],bitRead(CW[temp],1));
    digitalWrite(pinArray[2],bitRead(CW[temp],2));
    digitalWrite(pinArray[3],bitRead(CW[temp],3));
delay(3);
  }
delay(1000);

//반대로 돔.
for(int i=0; i<STEP; i++){
    temp=i%4;
    digitalWrite(pinArray[0],bitRead(CCW[temp],0));
    digitalWrite(pinArray[1],bitRead(CCW[temp],1));
    digitalWrite(pinArray[2],bitRead(CCW[temp],2));
    digitalWrite(pinArray[3],bitRead(CCW[temp],3));
delay(3);
  }
delay(1000);
}

}
