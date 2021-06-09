void setup() {
Serial.begin(9600);
}

void loop() {
Serial.print(1);
delay(1000);
Serial.print(0);
delay(1000);
}

void serialEvent(){
char c=Serial.read();
if(c=='1') digitalWrite(13,HIGH);
else if(c=='0') digitalWrite(13,LOW);
}
