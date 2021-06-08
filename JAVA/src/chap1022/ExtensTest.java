package chap1022;//상속2
//부모클래스
class P_A{ 
	String p_a="부모님";
	
	public P_A() {
		System.out.println("부모님 생성자");
	}
	
	public void p_teck() {
		System.out.println("부모님의 돈버는 기술");
	}
		
}


//자식클래스
class C_A extends P_A{ 
	String c_a="자식님";
	
	public C_A() {
		System.out.println("자식님 생성자");
		super.p_teck(); //super는 내부에서만 사용가능, main에서는 사용이 불가.
	}
	
}



public class ExtensTest {
	public static void main(String[] args) {
		C_A c=new C_A();
		System.out.println("부모님 재산:"+c.p_a);
		
		//부모님 기술 사용
		c.p_teck();
		System.out.println("자식님 재산:"+c.c_a);
		
		

	}

}
