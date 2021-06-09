//선생님 코드(1)
int rowsPin[8]={12,13,14,15,16,17,18,19};
int colsPin[8]={2,3,4,5,6,7,8,9};
int data[8][8]={
  {1,0,1,0,1,0,1,0}, 
  {0,0,0,0,0,0,0,0},
  {1,1,1,1,1,1,1,1},
  {0,0,0,0,0,0,0,0},
  {1,1,1,1,1,1,1,1},
  {0,0,0,0,0,0,0,0},
  {1,1,1,1,1,1,1,1},
  {1,0,1,0,1,0,1,0}, 
};

void setup() {
for(int i=0; i<8;i++){ pinMode(rowsPin[i],LOW);}
for(int j=0; j<8; j++){ pinMode(colsPin[j],LOW);}
}

void loop() {
for( int r=0; r<8; r++){
 //gnd설정
 digitalWrite(rowsPin[r],LOW);
 //led input설정
 for(int k=0; k<8; k++){
 digitalWrite(colsPin[r],data[r][k]); }
}

}
