package chap1022; //상속1
class A{
	
}
public class ObjectTest {

	public static void main(String[] args) {
		
		Object obj=new Object();
		A a=new A(); //개체가 생성되어 있는 클래스의 이름을 가지고 온다.
		
		//System.out.println(obj.getClass().getName()); //출력값:java.lang.Object
		System.out.println(a.getClass().getName());  //출력값:chap1022.A
		System.out.println(a.toString());//출력값:chap1022.A@4fca772d
		//모든 상위에 있는 것은 Object...
		
		
	}

}
