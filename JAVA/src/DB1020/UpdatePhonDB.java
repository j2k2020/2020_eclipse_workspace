package DB1020;
import java.sql.*;
import java.util.Scanner;

public class UpdatePhonDB {
	public static void main(String[] args) throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","1234");
		if(conn==null) {System.out.println("DB접속에 실패");}
		else {System.out.println("DB접속 성공~");}
		
	//sql문을 작성해서 conn객체를 이용하여 데이터 베이스에 데이터 가져오기
	Statement stmt=null;
				
	String search_name;
	String PHnum;
				
	Scanner input=new Scanner(System.in);
	System.out.println("이름과 전화번호를 입력해 변경하세요.");
	search_name=input.next();
	PHnum=input.next();
				
	String sql=String.format("update Phonebook set PHnum='%s' where name='%s'",PHnum,search_name);
	stmt=conn.createStatement();//위의 sql문을 처리하기 위해 객체 생성
				
	int result=stmt.executeUpdate(sql);
	System.out.println(result+"개가 수정되었습니다.");
				
	stmt.close();
	conn.close();


		

	}

}
