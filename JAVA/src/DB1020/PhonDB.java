package DB1020;

import java.sql.*;

public class PhonDB {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection co=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","1234");
		
		if(co==null) {
			System.out.println("DB접속 실패");
		}else {
			System.out.println("DB접속 성공~");
		}
		
		Statement stmt=null;
		
		String sql="create table PhoneBook(no number(3), name varchar2(10), PHnum varchar(15), memo varchar(100))";
		stmt=co.createStatement();
		ResultSet result=stmt.executeQuery(sql);
		System.out.println(result+"table이 생성되었습니다.");
		
		
		stmt.close();
		co.close();

	}

}
