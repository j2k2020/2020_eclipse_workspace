//포텐시오미터 java로 값 넘기기
void setup() {
  Serial.begin(9600);
}


char str[1023];
void loop() {
 sprintf(str,"%d",analogRead(A0));
  Serial.write(str);
  delay(5000); 

  /*
//앞에 들어오던 데이터가 비워지지 않아서 1023이 나뉘어져서  들어온다.
버퍼를 비워주면서 사용해야 문제 해결할 듯.
접속 
url data:3
접속
url data:1
접속
url data:0
접속
url data:23
접속
url data:10
   */
}
