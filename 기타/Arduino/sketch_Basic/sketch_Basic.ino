char* buf="test message";

void setup() {
 Serial.begin(9600);
}

void loop() {
  unsigned long int t; //부호가 없다. 롱형의 변수 
  for(int i=0; i<10; i++){
    t=micros();
    Serial.println(buf);
    Serial.flush();
    Serial.println(micros()-t);   
  }
  while(1);
  
  //if(Serial.available()){ }

}
