//참조: https://m.blog.naver.com/PostView.nhn?blogId=darknisia&logNo=220667411137&proxyReferer=http:%2F%2F59.6.46.38%2F
//스마일
int row[]={12,13,14,15,16,17,18,19} //행
int col[]={2,3,4,5,6,7,8,9} //열

int pattern1[]={4,5,6,7}; //각 행 별 패턴(1~8행)
int pattern2[]={3,8};
int pattern3[]={2,4,7,9};
int pattern4[]={2,9};
int pattern5[]={2,4,7,9};
int pattern6[]={3,8};
int pattern7[]={3,8};
int pattern8[]={4,5,6,7};

void setup() {
  for(int i=0; i<8; i++){ //행과 열의 디지털 핀을 출력으로 설정
    pinMode(row[i],OUTPUT);
    pinMode(col[i],OUTPUT);
  }
}

void clear(){
  for(int k=0; k<8; k++){ //led를 켜기 전에 모두 끄기(리셋)
    digitalWrite(row[k],LOW);
    digitalWrite(col[k],HIGH);
  }
}
void loop() {
   clear(); //1번행 패턴
   digitalWrite(row[0],HIGH);
   for(int i=0; i<4; i++){
    digitalWrite(pettern1[i],LOW);
   }delay(2);

    clear(); //2번행 패턴
   digitalWrite(row[1],HIGH);
   for(int i=0; i<2; i++){
    digitalWrite(pettern2[i],LOW);
   }delay(2);

    clear(); //3번행 패턴
   digitalWrite(row[3],HIGH);
   for(int i=0; i<4; i++){
    digitalWrite(pettern3[i],LOW);
   }delay(2);

    clear(); //4번행 패턴
   digitalWrite(row[3],HIGH);
   for(int i=0; i<2; i++){
    digitalWrite(pettern4[i],LOW);
   }delay(2);

    clear(); //5번행 패턴
   digitalWrite(row[4],HIGH);
   for(int i=0; i<4; i++){
    digitalWrite(pettern5[i],LOW);
   }delay(2);

    clear(); //6번행 패턴
   digitalWrite(row[5],HIGH);
   for(int i=0; i<4; i++){
    digitalWrite(pettern6[i],LOW);
   }delay(2);

    clear(); //7번행 패턴
   digitalWrite(row[6],HIGH);
   for(int i=0; i<2; i++){
    digitalWrite(pettern7[i],LOW);
   }delay(2);

    clear(); //1번행 패턴
   digitalWrite(row[7],HIGH);
   for(int i=0; i<4; i++){
    digitalWrite(pettern8[i],LOW);
   }delay(2);
   
   
  



}
