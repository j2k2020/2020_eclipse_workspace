package chap1019;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectDB {
	public static void main(String[] args)throws ClassNotFoundException, SQLException {
		//1.ojdbc.jar 드라이버를 라이브러리로 포함(bulid path)
		//2.드라이버 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","1234");
		//url, id, password
		if(conn==null) {
			System.out.println("DB접속 실패");
		}else{
			System.out.println("DB접속 성공!");
			}
		
		//Sql문을 작성-> conn객체를 이용하여 DB에 데이터 가져오기
		Statement stmt=null;
		ResultSet rs=null;
		
		String sql="select * from message";
		stmt=conn.createStatement(); //위의 sql문을 처리하기 위해 객체 생성
		rs=stmt.executeQuery(sql);
		
		//결과를 가지고 출력하는 방법 알아보기
		while(rs.next()) {
			int no=rs.getInt(1); //("no");
			String name=rs.getString(2); //("name");
			String content=rs.getNString("content");
			
			System.out.printf("%d %s %s \n",no,name,content);
		}
		rs.close();
		stmt.close();
		conn.close();
}}
