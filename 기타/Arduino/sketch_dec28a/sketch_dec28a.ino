//water sence사용
void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);

}

void loop() {
  // put your main code here, to run repeatedly:
  int waterSensorVal = analogRead(A0);
  Serial.print("Water Sensor : ");
  Serial.println(waterSensorVal);
  delay(100);

}
