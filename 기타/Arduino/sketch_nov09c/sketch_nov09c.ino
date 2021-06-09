//참조: https://m.blog.naver.com/PostView.nhn?blogId=darknisia&logNo=220667411137&proxyReferer=http:%2F%2F59.6.46.38%2F

int row[]={12,13,14,15,16,17,18,19} //행
int col[]={2,3,4,5,6,7,8,9} //열

void setup() {
 for(int i=0; i<8; i++){
  pinMode(row[i],OUTPUT);
  pinMode(col[i],OUTPUT);
 }

}

void loop() {
  for(int i=0; i<8; i++){
    for(int j=0; j<8; j++){
      for(int k=0; k<8; k++){ //led를 켜기 전에 모두 끄기(리셋)
        digitalWrite(row[k],LOW);
        digitalWrite(col[k],HIGH);
      }
    }
  }

digitalWrite(row[i],HIGH); // i행 j열의 LED를 켬
digitalWrite(col[j],LOW);
delay(1000);

}
