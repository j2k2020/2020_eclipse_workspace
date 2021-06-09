void setup() {
   Serial.begin(9600);
   
}

void loop() {
  // put your main code here, to run repeatedly:
   Serial.write('0');
   delay(1000);
    Serial.write('1');
   delay(1000);
}

void SerialEvent(){
  int c=Serial.read();
  if(c=='0'){
    digitalWrite(10,LOW);
  }else if(c=='1'){
    digitalWrite(10,HIGH);
  }
}
