package com.iot.PhoneBookService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhonebookService {
	//phonebook에 대한 데이터 베이스처리
	//입력, 출력, 수정, 삭제
		//select 전체 데이터를 리턴해주는 함수(전체데이터 출력)
		public List<Phonebook> getList() throws ClassNotFoundException, SQLException{
					//1.ojdbc6.jar 드라이버를 라이브러리로 포함(bulid path)
					//2.드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection(
			"jdbc:oracle:thin:@localhost:1521:xe","hr","1234");
					
					if(conn==null) {System.out.println("DB접속에 실패");}
					System.out.println("DB접속 성공");
					
					//sql문을 작성해서 conn객체를 이용하여 데이터 베이스에 데이터 가져오기
							
					String sql="select * from phonebook";
					PreparedStatement pstmt=conn.prepareStatement(sql);//위의 sql문을 처리하기 위해 객체 생성
					ResultSet rs=pstmt.executeQuery();
					
					List<Phonebook> list=new ArrayList<Phonebook>();
					//결과를 가지고 출력하는 방법 알아보기
					while(rs.next()) {
						//개별변수 선언이 아닌 Phonebook클래스를 이용하여 값을 모두 저장
						Phonebook pb=new Phonebook();
						pb.no=rs.getInt("no");
						pb.name=rs.getString("name");
						pb.PHnum=rs.getString("PHnum");
						pb.memo=rs.getString("memo");
						list.add(pb); //DB로 부터 받은 내용을 리스트에 저장
					}
					rs.close();
					pstmt.close();
					conn.close();
			return list;
		}
		
		//insert 데이터 삽입
		public int insert(Phonebook pb) throws ClassNotFoundException, SQLException {
			//1.ojdbc6.jar 드라이버를 라이브러리로 포함(bulid path)
			//2.드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection(
			"jdbc:oracle:thin:@localhost:1521:xe","hr","1234");
			//url,id,password
			
			if(conn==null) {System.out.println("DB접속에 실패");}
			System.out.println("DB접속 성공");
			
			//sql문을 작성해서 conn객체를 이용하여 데이터 베이스에 데이터 가져오기
										
			String sql="insert into Phonebook(no,name,PHnum,memo) values(?,?,?,?)";
			PreparedStatement pstmt=conn.prepareStatement(sql);//위의 sql문을 처리하기 위해 객체 생성
			//?물음표를 채워줘야함.
			pstmt.setInt(1, pb.getNo());
			pstmt.setString(2,pb.getName());
			pstmt.setString(3,pb.getPHnum());
			pstmt.setString(4,pb.getMemo());
						
			int result=pstmt.executeUpdate();
			System.out.println(result+"개가 입력되었습니다.");
			
			pstmt.close();
			conn.close();
			return 0;
		}
		
		//update 데이터 업데이트
		public int update(Phonebook pb) throws ClassNotFoundException, SQLException {
			//1.ojdbc6.jar 드라이버를 라이브러리로 포함(bulid path)
			//2.드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection(
			"jdbc:oracle:thin:@localhost:1521:xe","hr","1234");
			//url,id,password
			
			if(conn==null) {System.out.println("DB접속에 실패");}
			System.out.println("DB접속 성공");
			
			//sql문을 작성해서 conn객체를 이용하여 데이터 베이스에 데이터 가져오기
											
			String sql="update Phonebook set PHnum=? where name=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, pb.getPHnum());
			pstmt.setString(2, pb.getName());
			int result=pstmt.executeUpdate();
			System.out.println(result+"개가 수정되었습니다.");
			
			pstmt.close();
			conn.close();
			return 0;
		}
		
		//delete 데이터 삭제
		public int delete(int no) throws ClassNotFoundException, SQLException {
			//1.ojdbc6.jar 드라이버를 라이브러리로 포함(bulid path)
			//2.드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection(
			"jdbc:oracle:thin:@localhost:1521:xe","hr","1234");
			//url,id,password
			
			if(conn==null) {System.out.println("DB접속에 실패");}
			System.out.println("DB접속 성공");
			
			//sql문을 작성해서 conn객체를 이용하여 데이터 베이스에 데이터 가져오기
										
			String sql="delete from Phonebook where no=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,no);
			int result=pstmt.executeUpdate();
			System.out.println(result+"개가 삭제되었습니다.");
			
			pstmt.close();
			conn.close();
			return 0;
		}
	
}
