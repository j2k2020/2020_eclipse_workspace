void setup() {
   Serial.begin(9600);
   pinMode(10,OUTPUT);
}

char i='0';
void loop() {
   Serial.write(i++);
   if(i=='9'){i='0';}
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
