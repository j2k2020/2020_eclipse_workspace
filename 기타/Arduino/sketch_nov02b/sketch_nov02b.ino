#define D1 10
#define D2 11
#define D3 12
#define D4 13

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

int n[4];
void forDigitNum(int num){
  //1. 숫자를 분리
  n[3]=num/1000;
  n[2]=num/100%10;
  n[1]=num/10%10;
  n[0]=num%10;

  /*
  n[3]=num/1000;
  n[2]=num/100-(n[3]*10);
  n[1]=num/10-(n[3]*100)-(n[2]*10);
  n[0]=num/1-(n[3]*1000)-(n[2]*100)-(n[1]*10);
  */

  
}
void loop() {
 forDigitNum(3210);
 //데이터 분리 확인하는 작업
 /*for(int i=3;i>-1;i--){
  Serial.println(n[i]);
  delay(1000);
 }*/
 for(int i=13;i>9;i--){
  digitalNumber(i,n[i-10]);
  delay(3);
  digitalPinInit();
 }
}
