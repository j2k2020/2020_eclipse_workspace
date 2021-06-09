#define soriPin 4
int um[8]={262, 294, 330, 340, 392, 440, 494, 523};
void setup() {
//SW-520D,부저 사용
Serial.begin(9600);
Serial.println(A1);
pinMode(A1,INPUT_PULLUP);
}

void loop() {
Serial.println(digitalRead(A1));

for(int i=0; i<8; i++){
  tone (soriPin, um[i], 200);
  delay(500);
}
delay(100);
}
