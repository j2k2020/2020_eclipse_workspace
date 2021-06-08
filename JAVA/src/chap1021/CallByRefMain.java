package chap1021;
class A{
	int value=100;
	public int getValue() {
		return value;
		
	}
}
public class CallByRefMain {

	public static void main(String[] args) {
		 //class란 - 주소를 들고 있는 놈이다라고 생각하면 된다.
		A one=new A(); //이렇게 객체를 생성했다라는건 주소를 만들었다는 것이다.
		//A two=null;
		A two=new A();//이렇게 객체를 생성했다라는건 주소를 만들었다는 것이다.
		System.out.println(one);
		System.out.println(two);
		two=one;
		System.out.println(two);

	}
}
