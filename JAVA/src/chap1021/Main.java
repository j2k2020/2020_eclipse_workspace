package chap1021;

class Person{
	//public String name; //public은 외부에서 선언이 된 객체에 대해 접근이 가능하다.
	//public int age;
	
private String name; //private 사적으로 사용/공동으로 사용하고 싶지 않다. 클래스 안에서만 접근이 가능하다.
private int age;
//이렇게는 생성이 불가능 하기에 private에 생성자자 person(){}을 생성해줘서 사용한다.
	
	//기존에 있던거 외에, 싹~ 새롭게 생성하는 것이 '오브라이팅' = 같은 이름을 다시 정의하는 것
public Person() {}
	//'오브로딩' 같은 함수를 여러개 생성
	public Person(String name, int age) {
		this.name=name; // this(이 객체:내 객체)의 name은 String name다 라는 선언.
		this.age=age;
	}


public void print() {
	System.out.println("이름:"+name+" 나이:"+age);
	
}

public String getName() { //자바의 스팩에 규정된 이름을 반환한다. //get 가지고 온다.
	return name;
}

public int getAge() { //자바의 스팩에 규정된 이름을 반환한다.
	return age;
}

public void setName(String name) {//(String[]args)이름을 전달 받아야 됨 //set은 속성을 설정을 한다.
	this.name=name; 
}

public void setAge(int age) {//(String[]args)이름을 전달 받아야 됨
	this.age=age; 
}


}


public class Main {

	public static void main(String[] args) {
	 
		//private
		Person p1=new Person("홍길동",10);
		p1.print(); //print함수를 호출~
		System.out.println("이름:"+p1.getName());//getName()은 String이 리턴된다.
		
		//name,age private라서 초기화가 않되어 있다.
		Person p2=new Person();
		//초기화를 시켜야 됨.
		p2.setName("Kim");
		p2.setAge(30);
		p2.print();
			
	}

}
