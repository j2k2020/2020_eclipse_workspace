package chap1017;
//함수 제네릭
class A{
	public String toString() {return "CLASS A";}
	/*
String chap1017.A.toString()
Returns a string representation of the object. In general, the toString method returns a string that"textually represents" this object. The result shouldbe a concise but informative representation that is easy for aperson to read.It is recommended that all subclasses override this method. 
The toString method for class Objectreturns a string consisting of the name of the class of which theobject is an instance, the at-sign character `@', andthe unsigned hexadecimal representation of the hash code of theobject. In other words, this method returns a string equal to thevalue of: 
 getClass().getName() + '@' + Integer.toHexString(hashCode())
 
Overrides: toString() in Object
Returns:a string representation of the object.*/
}

class B{
	public String toString() {return "CLASS B";}
	
}
class Show{
	public<T> void print(T inst) {//public과 리턴형 사이에 제네릭을 선언! , 함수 제네릭이라서 선언자 뒤에 함수형에 제네릭<T>선언!
		System.out.println("public<T>:"+inst);
	}
	public<T,U> void print2(T inst1, U inst2) { //제네릭을 2개 선언
		System.out.println("public<T,U>:"+inst1);
		System.out.println("public<T,U>:"+inst2);
	}
}
public class MethodGenMain {

	public static void main(String[] args) {
		//System.out.println(new A());
		//System.out.println(new A().toString());
		
		A a=new A();
		B b=new B();
		Show show=new Show();
		//함수들이기에 <>이게 필요없음, 제네릭을 선언하는 것에 대한 객체가 들어가는 것은 아래 구현되어있다.
		show.<A>print(a); //<A>을 제네릭으로 사용하겠다면 출력은 반듯이 (a)가 되어야 한다.
		show.<B>print(b);
		
		//<T,U> void print2(T inst1, U inst2)
		show.<A,B>print2(a,b);
	
	}

}
