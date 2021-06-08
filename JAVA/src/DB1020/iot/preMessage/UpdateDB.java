package DB1020.iot.preMessage;
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
		

		String sql="update message set content=? where no=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, "2nd change message");
		pstmt.setInt(2,3);
		int result=pstmt.executeUpdate();//qurey는 요청, update는 변경
		System.out.println(result+"개가 수정되었습니다.");
		
		pstmt.close();
		conn.close();
}}
	
