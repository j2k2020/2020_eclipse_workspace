package com.iot.prePhoneook;
import java.sql.*;
import java.util.*;

public class InsertDB {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1.ojdbc6.jar 드라이버를 라이브러리로 포함(bulid path)
				//2.드라이버 로딩
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn=DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe","hr","1234");
				//url,id,password
				
				if(conn==null) {System.out.println("DB접속에 실패");}
				System.out.println("DB접속 성공");

				String sql="insert into message(no,name,content) values(?,?,?)";
				PreparedStatement pstmt=conn.prepareStatement(sql);//위의 sql문을 처리하기 위해 객체 생성
				//(?)물음표를 채워줘야함
				pstmt.setInt(1, 3);
				pstmt.setNString(2, "park");
				pstmt.setNString(3, "park message");
				
				int result=pstmt.executeUpdate();
				System.out.println(result+"개가 입력되었습니다.");
				
				pstmt.close();
				conn.close();
	}
}
