void setup() {
  Serial.begin(9600);
  
}

int data=0;
void loop() {
  Serial.write(data++);
  delay(2000);
}
