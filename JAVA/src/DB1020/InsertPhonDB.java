package DB1020;
import java.sql.*;
import java.util.Scanner;

public class InsertPhonDB {

	public static void main(String[] args)throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","1234");
		//url, id, password
		if(conn==null) {
			System.out.println("DB접속 실패");
		}else{
			System.out.println("DB접속 성공!");
			}
			
		int no;
		String name,PHnum,memo;
		Scanner input=new Scanner(System.in);
		System.out.println("번호,이름,전화번호,메모를 입력(예: 1 홍길동 010-9999-9999 메모)");
		no=input.nextInt();
		name=input.next();
		PHnum=input.next();
		memo=input.next();
		System.out.printf("%d %s %s %s \n", no,name,PHnum,memo);
		
		String sql="insert into PhoneBook (no,name,PHnum,memo) values(?,?,?,?)";
		PreparedStatement pstmt=conn.prepareStatement(sql); //위의 sql문을 처리하기 위해 객체 생성
		
		//?표를 채워
		pstmt.setInt(1, no);
		pstmt.setString(2, name);
		pstmt.setString(3, PHnum);
		pstmt.setString(4, memo);
		
		//완성된 문장 실행(이 때, sql문장은 필요가 없다!)
		int result=pstmt.executeUpdate();//qurey는 요청, update는 변경
		System.out.println(result+"개가 입력되었습니다.");
		
		pstmt.close();
		conn.close();

	}

}
