//Serial Master( Send )
//마이크 소리 질렀을 때 불켜지기
void setup() {
 Serial.begin(9600);
  
}

void loop() {
 // Serial.println(analogRead(A0));
 // delay(1000); 
 if(analogRead(A0)>580 || analogRead(A0)<530){
 Serial.println("1");
 }else{
 Serial.println("0");
 }
 delay(1000); 
 
}
