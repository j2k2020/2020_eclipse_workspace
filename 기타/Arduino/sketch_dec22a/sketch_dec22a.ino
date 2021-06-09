void setup( ) { 
Serial.begin(9600); 
pinMode(11, INPUT_PULLUP); 
} 

void loop( ){
 if(digitalRead(11)==LOW){
  Serial.print(1); //데이터를 보내는 작업
 }
 delay(200);

}
