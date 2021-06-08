package chap1022;//상속3

//Abstract(추상메소드)정의가 된게 아니라, 추측 또는 상상으로 클래스 선언해 놓았다고 생각하면 됨

interface Store_Join{ //여기는 다 완성되지 않은 것만 들어가야 됨,완성된게 들어가면 에러가 남.
	public void open();
	public void close();
}

//class Maket extends Coffee_Store,Fruit_Store{ //부모가 2개 일수는 없다!!
//class Maket extends Coffee_Store{ //그래서 한 개만 상속 받는다.	
class Maket extends Coffee_Store implements Store_Join{ //상속 받으면서, Store_Join의 내용을 참조 한다.
	
}



class Fruit_Store implements Store_Join{ //interface에 있는 내용을 모두 구현해줘야 된다.
	String Store_name="과일가게";
	public void open() { System.out.println("과일가게 열기");} 
	public void close() {System.out.println("과일가게 닫기"); }
}

//부모클래스
abstract class Store{ //일부만 완성되지 않음, 완전히 다 완성되지 안은 것만 있으면 에러가 남.
	String Store_name="커피점";
	
	//public  void open(); //완성X
	public abstract void open(); //완성X,그래서 abstract을 붙여서 추상 클래스라고 해줘야됨.
	
	public void close() { //완성o
		System.out.println("커피점 닫기");
	}
}


//자식 클래스
//class Coffee_Store implements Store{ //store부터 (상속)받아서 Coffee_Store로 구현 할 것이다. 라는 뜻
class Coffee_Store extends Store{ //그래서 여기선 implements가 아니라 extends를 써서 구현해줘야 됨. 위에거를 사용하려면
	public void open() {
		System.out.println("커피점 열기");
	}
	public void show() {
		System.out.println("행사");
	}
	
}

public class AbstractTest {
	public static void main(String[] args) {
		Coffee_Store cs=new Coffee_Store();
		cs.open(); //커피점 열기 구현
		cs.close();//커피점 닫기 구현
		cs.show(); //자식클래스에 있는 show는 자식은 구현 가능!
		
		Store cs1=new Coffee_Store();
		cs1.open();
		cs1.close();
		//cs1.show();//부모클래스가 자식클래스에 있는 show는 구현 불가능!
		
		Fruit_Store fs=new Fruit_Store();
		fs.open();
		fs.close();
		
		//Store_Join sj=new Store_Join(); //error
		Store_Join sj=new Fruit_Store();//클래스가 아닌데도 선언이 가능
		System.out.println(sj);//결과값:chap1022.Fruit_Store@1ddc4ec2
		sj.open();
		sj.close();
		//System.out.println(sj.Store_name);//error: Unresolved compilation problem: Store_name cannot be resolved or is not a field
		//implements는 중간다리 역할을 하는 것, extends처럼 상속을 해주는 것은 아니다.

		Store_Join Maket=new Maket();
		//Store_Join Maket1=new Coffee_Store();//Error: Unresolved compilation problem: Type mismatch: cannot convert from Coffee_Store to Store_Join
		//implements는 내가 가지고 있는 것만 참조 받을 수 있다. 
		
		

	}

}
