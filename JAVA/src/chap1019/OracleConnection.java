package chap1019;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnection {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
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
	}
}
