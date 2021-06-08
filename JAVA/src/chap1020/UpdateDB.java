package chap1020;
import java.sql.*;
public class UpdateDB {

	public static void main(String[] args)throws ClassNotFoundException, SQLException {
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

		String sql="update message set content='change message' where no=1";
		stmt=conn.createStatement(); //위의 sql문을 처리하기 위해 객체 생성
		int result=stmt.executeUpdate(sql);//qurey는 요청, update는 변경
		System.out.println(result+"개가 수정되었습니다.");
		
		stmt.close();
		conn.close();
}}
	
