//온도센서
void setup() {
Serial.begin(9600);
// 8iupinMode(19,OUTPUT);
Serial.println(A5);

}

void loop() {
  Serial.println(analogRead(A5));

}
