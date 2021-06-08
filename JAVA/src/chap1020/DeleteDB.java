package chap1020;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteDB {

	public static void main(String[] args)throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","1234");
		if(conn==null) {
			System.out.println("DB접속 실패");
		}else{
			System.out.println("DB접속 성공!");
			}
		
		
		Statement stmt=null;

		String sql="delete from message where no=3";
		stmt=conn.createStatement(); 
		int result=stmt.executeUpdate(sql);
		System.out.println(result+"개가 삭제되었습니다.");
		
		stmt.close();
		conn.close();
}}