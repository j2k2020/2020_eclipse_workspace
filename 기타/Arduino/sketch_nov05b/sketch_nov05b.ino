//Serial Slaver( Recv )
void setup() {
 Serial.begin(9600);
  pinMode(13,OUTPUT);
}

void loop() {
  if(Serial.available()){
    char data=(char)Serial.read();
     if(data='1'){
      digitalWrite(13,HIGH);
     }else{
      digitalWrite(13,LOW);
     }
  }


}
