package chap1022;
class Franchise implements A_Point{ //MainAdmin은 Freanchise클래스의 내용을 다 구현해 놓아야 한다.
	public void A_admin() {
		System.out.println("A지점 관리자");
	}
	
	
	public void B_admin() {
		System.out.println("B지점 관리자");
	}
	
	
	public void C_admin() {
		System.out.println("C지점 관리자");
	}
	
	
	public void D_admin() {
		System.out.println("D지점 관리자");
	}
	
	
}

//메인 (전체)관리자 인터페이스
interface MainAdmin{ 
	public void A_admin();
	public void B_admin();
	public void C_admin();
	public void D_admin();
}

//A지점 인터페이스
interface A_Point{
	public void A_admin();
}

//B지점 인터페이스
interface B_Point{
	public void B_admin();
}

//C지점 인터페이스
interface C_Point{
	public void C_admin();
}

//D지점 인터페이스
interface D_Point{
	public void D_admin();
}

class A_Point1 extends Franchise implements A_Point{}
	//상속도 다 받고, A_Point도 implements된 상태
class B_Point1 extends Franchise implements B_Point{}
class C_Point1 extends Franchise implements C_Point{}
class D_Point1 extends Franchise implements D_Point{}


public class AdminInterfaceTest {
	public static void main(String[] args) {
		/*
		MainAdmin m_admin=new Franchise();
		m_admin.A_admin();
		m_admin.B_admin();
		m_admin.C_admin();
		m_admin.D_admin();
		*/
		
		//A_Point Point=new Franchise();
		//Point.A_admin();
		//Point.B_admin();
		//Point.C_admin();
		//Point.D_admin();
		A_Point a_point=new A_Point1();
		B_Point b_point=new B_Point1();
		
	
	}	
}
