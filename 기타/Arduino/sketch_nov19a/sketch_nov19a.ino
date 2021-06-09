void setup() { //java 컴파일창에 0,1 띄우기
  // put your setup code here, to run once:
 Serial.begin(9600);
 
}

void loop() {
  // put your main code here, to run repeatedly:
   Serial.write('0');
   delay(1000);
    Serial.write('1');
   delay(1000);
}
