package chap1019;
import java.sql.*;

public class TrySelectDB {
	public static void main(String[] args){
		Connection conn=null;
		//Sql문을 작성-> conn객체를 이용하여 DB에 데이터 가져오기
		Statement stmt=null;
		ResultSet rs=null;
		try {
		//1.ojdbc.jar 드라이버를 라이브러리로 포함(bulid path)
		//2.드라이버 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","1234");
		//url, id, password
		if(conn==null) {
			System.out.println("DB접속 실패");
		}else{
			System.out.println("DB접속 성공!");
			}

		String sql="select * from message";
		stmt=conn.createStatement(); //위의 sql문을 처리하기 위해 객체 생성
		rs=stmt.executeQuery(sql);
		//rs=stmt.executeQuery("select * from message");
		
		//결과를 가지고 출력하는 방법 알아보기
		while(rs.next()) {
			int no=rs.getInt(1); //("no");
			String name=rs.getString(2); //("name");
			String content=rs.getNString("content");
			
			System.out.printf("%d %s %s \n",no,name,content);
		}
		}//try문
		catch(Exception e){System.err.println(e);}
		
		finally {
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
}}
