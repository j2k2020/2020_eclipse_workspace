package com.iot.prePhoneook;
import java.sql.*;
import java.util.Scanner;

public class UpdatePhonDB {
	public static void main(String[] args) throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","1234");
		if(conn==null) {System.out.println("DB접속에 실패");}
		else {System.out.println("DB접속 성공~");}
				
	String search_name;
	String PHnum;
				
	Scanner input=new Scanner(System.in);
	System.out.println("이름과 전화번호를 입력해 변경하세요.");
	search_name=input.next();
	PHnum=input.next();
				
	String sql="update Phonebook set PHnum=? where name=?";
	PreparedStatement pstmt=conn.prepareStatement(sql);
		
	pstmt.setString(1,"010-0000-0000");
	pstmt.setNString(2, "정재은");
	
	int result=pstmt.executeUpdate();
	System.out.println(result+"개가 수정되었습니다.");
				
	pstmt.close();
	conn.close();


	}

}
