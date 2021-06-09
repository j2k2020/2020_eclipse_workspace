//소켓통신(2)
void setup() {
Serial.begin(9600);
}

void loop() {
  Serial.println("1234");
  delay(400);
  Serial.write("5678");
  delay(400);

}

void serialEvent(){
  byte recv=Serial.read();
   Serial.println("event:");
  Serial.write(recv);
  Serial.println();
}
