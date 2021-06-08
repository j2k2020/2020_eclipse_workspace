package chap1021;
class MyColor{
	/*int RED=0;
	int BLUE=1;
	int GREEN=2; //호출 할 때마다 매번 객체를 생성해야되는 귀찮음이 있다. 
	*/	
	static int RED=0;
	static int BLUE=1;
	static int GREEN=2;	
	
	public static int mixColor (int r, int b, int g) { //static을 반환되기 전에 선언해주면, 메모리에 올라가게 된다.
		// 0,0,0=검정색(1000) 1,1,1=흰색(1111);
		if(r==0 && b==0 && g==0) {return 1000;} 
		else if(r==1 && b==1 && g==1) {return 1111;}
		else {return -1;}
	}
	
}

class Pay{
//public class Pay{ //public을 붙이면 에러가 난다.
	int money=1000;
	
	final int day=365; // 1년 365일
	//final int week=7; //1주 7일
	final static int week=7; //1주 7일 //static을 줘서 상수이면 속성을 받을 수 있음
	final int month=12; //12개월(달)
    
}



public class StaticTest {
	
	public static void main(String[] args) {
	/*
	MyColor color=new MyColor();
	System.out.println(color.RED);
	*/
		
		/*
		//객체를 선언x, 클래스명-객체 출력이 가능
		System.out.println(MyColor.RED);
		
		System.out.println(MyColor.mixColor(1,1,1));//MyColor객체 생성x, 클래스명이다.
		//static는 객체를 안만들어도 유지가 되어 메모리에 자동으로 올라간다. 그래서 클래스명만 가지고도 호출이 가능하다!!
*/
		
		Pay pay=new Pay();
		pay.money=10000; //에러 없음!(상수가 아니라서 값 변경 가능)
		//pay.month=13; //에러나옴( final의 값은 변경할 수 없으니 에러가 남:(상수:값 변경 불가) )
		System.out.println("일주일 용돈:"+(pay.money*pay.week));
		System.out.println("일주일 용돈:"+(pay.money*pay.week)); //pay 상수이면서 static의 속성을 같이 가짐
	}

}
