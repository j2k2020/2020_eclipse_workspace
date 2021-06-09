//소켓통신
void setup() {
  pinMode(13,OUTPUT);
  digitalWrite(13,LOW);
  Serial.begin(9600);
}

void loop() {
}

void serialEvent(){
  byte recv=Serial.read();
  if(recv=='1') digitalWrite(13,HIGH);
  else if(recv=='0') digitalWrite(13,LOW);
}
