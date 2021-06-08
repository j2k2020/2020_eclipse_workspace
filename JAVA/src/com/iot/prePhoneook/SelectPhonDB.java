package com.iot.prePhoneook;
import java.sql.*;


public class SelectPhonDB {
	public static void main(String[] args) throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","1234");
		if(conn==null) {System.out.println("DB접속에 실패");}
		else {System.out.println("DB접속 성공~");}
		
		Statement stmt=null;
		ResultSet rs=null;
		
		String sql="Select*from message where no=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);//위의 sql문을 처리하기 위해 객체 생성
		//(?)물음표를 채워줘야함
		rs=pstmt.executeQuery(sql); //뒤에 숫자가 가져오고 싶은 no컬럼 (열,이름)
		

		//결과를 가지고 출력하는 방법
		while(rs.next()) {
			int no=rs.getInt(1);//("no");
			String name=rs.getString(2);//("name");
			String content=rs.getNString("PHnum");
	
			System.out.printf("%d %s %s \n", no,name,content);
		}

		rs.close();
		stmt.close();
		conn.close();

	}

}
