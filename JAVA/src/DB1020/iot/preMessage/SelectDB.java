package DB1020.iot.preMessage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectDB {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1.ojdbc6.jar 드라이버를 라이브러리로 포함(bulid path)
				//2.드라이버 로딩
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn=DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe","hr","1234");
				//url,id,password
				
				if(conn==null) {System.out.println("DB접속에 실패");}
				System.out.println("DB접속 성공");

				
				String sql="Select*from message where no=?";
				PreparedStatement pstmt=conn.prepareStatement(sql);//위의 sql문을 처리하기 위해 객체 생성
				//(?)물음표를 채워줘야함
				pstmt.setInt(1, 1); //뒤에 숫자가 가져오고 싶은 no컬럼 (열,이름)
				ResultSet rs=pstmt.executeQuery();
				
				while(rs.next()) {
					int no=rs.getInt(1); //("no");
					String name=rs.getString(2); //("name");
					String content=rs.getString("content");
					
					System.out.printf("%d %s %s \n",no,name,content);
				}
				rs.close();
				pstmt.close();
				conn.close();
	}

}
