package DB1020;
import java.sql.*;


public class SelectPhonDB {
	public static void main(String[] args) throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","1234");
		if(conn==null) {System.out.println("DB접속에 실패");}
		else {System.out.println("DB접속 성공~");}
		
		Statement stmt=null;
		ResultSet rs=null;
		
		String sql="select*from phonebook";
		stmt=conn.createStatement();
		rs=stmt.executeQuery(sql);
		
		//결과를 가지고 출력하는 방법
		while(rs.next()) {
			int no=rs.getInt("no");
			String name=rs.getString("name");
			String PHnum=rs.getString("PHnum");
			String memo=rs.getString("memo");
			
			System.out.printf("%d %s %s %s \n", no,name,PHnum,memo);
		}
		rs.close();
		stmt.close();
		conn.close();

	}

}
