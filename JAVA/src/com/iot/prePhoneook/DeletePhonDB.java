package com.iot.prePhoneook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeletePhonDB {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1.ojdbc6.jar 드라이버를 라이브러리로 포함(bulid path)
		//2.드라이버 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn=DriverManager.getConnection(
		"jdbc:oracle:thin:@localhost:1521:xe","hr","1234");
		//url,id,password
		
		if(conn==null) {System.out.println("DB접속에 실패");}
		System.out.println("DB접속 성공");
		
		//sql문을 작성해서 conn객체를 이용하여 데이터 베이스에 데이터 가져오기
		Statement stmt=null;
		
		String name;
				
		Scanner input=new Scanner(System.in);
		System.out.println("이름 입력해 삭제 하세요.");
		name=input.next();
				
		String sql="delete from Phonebook where name=?";
		stmt=conn.createStatement(); 
		
		
		int result=stmt.executeUpdate(sql);
		System.out.println(result+"개가 삭제되었습니다.");
		
		stmt.close();
		conn.close();

}

}
