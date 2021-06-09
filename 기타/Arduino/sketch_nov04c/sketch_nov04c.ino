void setup() {
  //flame센서
 Serial.begin(9600);
 //pinMode(A5,OUTPUT);
}

void loop() {
Serial.println(analogRead(A5));
delay(300);
}
