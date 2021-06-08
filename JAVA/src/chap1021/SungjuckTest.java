package chap1021;
class Sungjuck{
	//국,영,수,합,평균
	//2.속성을 전달받아 값을 설정하는 생성자 함수
	//3.get,set함수 만들기
	//4.전체 출력 함수
	 int kor;
	 int eng;
	 int mat;
	 int tot;
	 double avg;
	 String hakbun;
	 String name;
	 static int subjectCnt=3; //과목 //static유지한다. 클래스 객체가 만들어지지 않아도 사용이 가능하다.

	 //생성자
	public Sungjuck(String hakbun, String name, int kor, int eng, int mat) {
		this.hakbun=hakbun;
		this.name=name;
		this.kor=kor;
		this.eng=eng;
		this.mat=mat;
		this.tot=kor+eng+mat;	
		this.avg=tot/subjectCnt; //this.avg=tot/3; 같은 뜻
	}
	
	/*
	//생성자는 2개로 만들어도 된다.
	public Sungjuck(int kor, int eng, int mat) {
		this.kor=kor;
		this.eng=eng;
		this.mat=mat;
		this.tot=kor+eng+mat;
		this.avg=tot/3;	
	}
	public Sungjuck(String hakbun, String name, int kor, int eng, int mat) {
		this.hakbun=hakbun;
		this.name=name;
		this.kor=kor;
		this.eng=eng;
		this.mat=mat;
		this.tot=kor+eng+mat;
		this.avg=tot/3;	
	}
	*/
	
	public void sethakbun(String hakbun) {//(String[]args)이름을 전달 받아야 됨 //set은 
		this.hakbun=hakbun;
	}
	public void setname(String name) {//(String[]args)이름을 전달 받아야 됨 //set은 
		this.name=name;
	}
	
	public void setKor(int kor) {//(String[]args)이름을 전달 받아야 됨 //set은 
		this.kor=kor;	
	}
	public void setEng( int eng) {//(String[]args)이름을 전달 받아야 됨 //set은 
		this.eng=eng;
	}
	public void setMat(int mat) {//(String[]args)이름을 전달 받아야 됨 //set은 
		this.mat=mat;
	}
	public void setTot(int tot) {//(String[]args)이름을 전달 받아야 됨 //set은 
		this.tot=tot;
	}
	public void setAvg(double avg) {//(String[]args)이름을 전달 받아야 됨 //set은 
		this.avg=avg;
	}
	
public void print() {
System.out.println("국어:"+kor);
System.out.println("영어:"+eng);
System.out.println("수학:"+mat);
System.out.println("합계:"+tot);
System.out.println("평균:"+avg);
		
	}
public void Allprint() {
	//System.out.printf("국어:%d 영어:%d 수학:%d 합계:%d 평균:%.2f \n",kor,eng,mat,tot,avg);
	System.out.printf("%s   %s   %d  %d  %d  %d  %.2f \n",hakbun,name,kor,eng,mat,tot,avg);

	
}
	
	
}
public class SungjuckTest {

	public static void main(String[] args) {
		System.out.println("과목 갯수:"+Sungjuck.subjectCnt);// static란 클래스가 선언되지 않아도 출력이 가능!
		
		
		Sungjuck[] c=new Sungjuck[5]; //배열선언 5명 //객체만 선언된 상태 - 아직 메모리에 올라가지 않음
		c[0]=new Sungjuck("1","홍길동",50,50,50);
		c[1]=new Sungjuck("2","김길동",60,60,60);
		c[2]=new Sungjuck("3","최길동",70,70,70);
		c[3]=new Sungjuck("4","고길동",80,80,80);
		c[4]=new Sungjuck("5","정길동",90,90,90);
		System.out.println("________________________________");
		System.out.println(" 학번   이름    국어  영어  수학  합계   평균 ");
		System.out.println("================================");
		
		for(int i=0; i<c.length; i++) {
			//c[i].print();
			c[i].Allprint();
		}System.out.println("________________________________");

	}
}
