//버퍼로 받고,출력,메모리 밀기(1):버퍼받기
void setup() {
  Serial.begin(9600);  
    
  int buf1[12]={1,2,3,4,5,6,7,8,9,10,11,12};
  for(int i=0; i<12; i++){
    Serial.print(buf1[i]);
    Serial.print(",");
  }
  Serial.println();
  Serial.println(sizeof(int));
  memset(buf1,0,sizeof(buf1)); //memset메모리를 세팅하는 함수
 //ZeroMemory(buf1,sizeof(buf1));//c언어에서 지원됨,아두이노에선 지원x
    
    for(int i=0; i<sizeof(buf1); i++){
    Serial.print(buf1[i]);
    Serial.print(",");
  }

}

void loop() {
  

}
