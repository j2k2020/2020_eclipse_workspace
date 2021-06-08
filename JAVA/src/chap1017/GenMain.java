package chap1017; //Chapter13 제네릭
/*
class Gen{
	private int item; //int자리에 클래스명도 올 수 있음
	public Gen(int item) {
		this.item=item;
	}
	public void print() {
		System.out.println(item);
	}
}
*/


class Gen<T>{
	private T item;
	public Gen(T item) {
		this.item=item;
	}
	public void print() {
		System.out.println(item.toString());
	}
}

class GenClass{
	
	@Override
	public String toString() {
		return "GenClass [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
public class GenMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gen <String> gen=new Gen("aaaaa"); //스트링을 T에 복사해 넣는다, 이것이 클래스 제네닉
		gen.print();
		Gen <Integer> gen1=new Gen(1);
		gen1.print();
		
		GenClass genclass=new GenClass();
		Gen <GenClass> gen2=new Gen(genclass);
		gen2.print();

	}

}












