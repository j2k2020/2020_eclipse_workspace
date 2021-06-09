//문자열을 분리하는 방법
String s="123:456";
String is="123";
void setup() {
Serial.begin(9600);
Serial.println(String("찾는 위치:")+s.indexOf(':'));
Serial.println(String("문자 분리:")+s.substring(0,3));
Serial.println(String("문자 길이:")+s.length());
Serial.println(String("문자를 정수로:")+is.toInt());
/* 
 *  https://www.arduino.cc/reference/ko/language/variables/data-types/stringobject/
 문자열 함수
LANGUAGE charAt()

LANGUAGE compareTo()

LANGUAGE concat()

LANGUAGE c_str()

LANGUAGE endsWith()

LANGUAGE equals()

LANGUAGE equalsIgnoreCase()

LANGUAGE getBytes()

LANGUAGE indexOf()

LANGUAGE lastIndexOf()

LANGUAGE length()

LANGUAGE remove()

LANGUAGE replace()

LANGUAGE reserve()

LANGUAGE setCharAt()

LANGUAGE startsWith()

LANGUAGE substring()

LANGUAGE toCharArray()

LANGUAGE toInt()

LANGUAGE toFloat()

LANGUAGE toLowerCase()

LANGUAGE toUpperCase()

LANGUAGE trim()
*/
}

void loop() {
  

}
