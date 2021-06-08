package chap1022;
import java.util.ArrayList;
//ctrl을 눌러서 ArrayList.class 확인
//public class ArrayList<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, java.io.Serializable
import java.util.List;
//ctrl을 눌러서 List.class 확인(list는 인터페이스_)
//public interface List<E> extends Collection<E> {

public class ArrayTest {

	public static void main(String[] args) {
		List list=new ArrayList();
		list.add("kim");
		list.add("park");
		list.add("hong");
		System.out.println(list.toString());
		
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		
		
		
	}

}
