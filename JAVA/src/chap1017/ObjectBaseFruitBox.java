package chap1017;
//클래스 제네릭
class Orange{
	int sugarContent;
	public Orange(int sugar) {sugarContent=sugar;}
	public void showSugarContent() {System.out.println("오렌지 당도:"+sugarContent);}}


class Apple{
	int weight;
	public Apple(int weight) {this.weight=weight;}
	public void showAppleWeight() {System.out.println("사과 무게:"+weight);}}


class FruitBox<T>{ //제네릭 (클레스를 저장하는 클레스)
	T item; // 이 fruitBox를 하나의 컨테이너로 보고, 위의 다른 클래스들을 T라는 item에 담아 사용할 수 있다.
	public void store(T item) {this.item=item;}
	public T pullOut() {return item;}}


class ObjectBaseFruitBox{
	public static void main(String[]args) {
		
		
		
		FruitBox<Orange> orBox=new FruitBox<Orange>();//FruitBox<T>을 FruitBox<Orange>으로 선언해서 Orange클래스를 사용하려고 선언한다.
		orBox.store(new Orange(10));
		Orange org=orBox.pullOut();//제네릭 사용으로 강제 형변환 필요X,그냥 출력!
		org.showSugarContent();

		
		
		FruitBox<Apple> apBox=new FruitBox<Apple>();
		apBox.store(new Apple(20));
		Apple app=apBox.pullOut();//제네릭 사용으로 강제 형변환 필요X,그냥 출력!
		app.showAppleWeight();}
	

/*
class FruitBox{
	Object item;
	public void store(Object item) {
		this.item=item;
	}
	public Object pullOut() {
		return item;
	}
}

class ObjectBaseFruitBox{
	public static void main(String[]args) {
		FruitBox fBox1=new FruitBox();
		fBox1.store(new Orange(10));//Orange(10)라는 객체를 생성->store에 저장->store는 fruitBox에 저장!
		Orange org1=(Orange)fBox1.pullOut(); //(orange)로 강제 형변환 fBox1.에서 꺼낼때~형변환!!
		//형변환을 하지 않으면 무엇인지 모르기 때문에 강제 형변환을 시켜주는 것임
		org1.showSugarContent();
		
		FruitBox fBox2=new FruitBox();
		fBox2.store("오렌지");//에러가 나는 이유는 들어가는 형이 스트링 형이니까, 
		Orange org2=(Orange)fBox2.pullOut();//출력부분도 스트링으로 형변환 맞춰야 한다.
		org2.showSugarContent();
	}
	*/
	
}