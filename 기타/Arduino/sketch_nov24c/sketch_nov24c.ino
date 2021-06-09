void setup() {
   Serial.begin(9600);
   
}
int a=456;
char str[5];

void loop() {
  String s="123";
 
  Serial.println(s.toInt()); //정수로 바꿔주는 역할
  delay(2000); //sprintf("%s%d",str,a); //문자열과 숫자 
  sprintf(str,"%d",a);
  Serial.write(str);
  delay(2000); 
}
