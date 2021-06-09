void setup() {
  // put your setup code here, to run once:
Serial.begin(9600);
/*
Serial.print(bitRead(0b1000,0)); //헤당하는 비트 첫번째 값을 읽어 올때는 0부터
Serial.print(bitRead(0b1000,1));
Serial.print(bitRead(0b1000,2));
Serial.print(bitRead(0b1000,3));
*/

//출력값:1111,  15의 비트값:1111
Serial.print(bitRead(15,0)); //헤당하는 비트 첫번째 값을 읽어 올때는 0부터
Serial.print(bitRead(15,1));
Serial.print(bitRead(15,2));
Serial.print(bitRead(15,3));
}
void loop() {
  // put your main code here, to run repeatedly:

}
