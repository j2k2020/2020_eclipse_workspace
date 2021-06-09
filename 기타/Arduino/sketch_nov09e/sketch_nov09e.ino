void setup() {
Serial.begin(9600);
pinMode(8,INPUT_PULLUP);

}

int x,y;
bool btn;
int pre_x,pre_y;
void loop() {
  x=analogRead(A0);
  y=analogRead(A1);
  btn=digitalRead(8);
  if((x>pre_x+100)||(x<pre_x-100)){
  Serial.println(String("x=")+x +String("y=")+y +String("btn=")+btn);
  }
  pre_x=x;
  pre_y=y;
  delay(100);
}
