package com.iot.MessageService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//데이터베이스 접속 처리(Data Access Object :DAO )
public class MessageService {
	
	//select 전체 데이터를 리턴해주는 함수
	public List<Message> getList() throws ClassNotFoundException, SQLException{
		
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn=DriverManager.getConnection(
		"jdbc:oracle:thin:@localhost:1521:xe","hr","1234");
		
		if(conn==null) {System.out.println("DB접속에 실패");}
		System.out.println("DB접속 성공");

		
		String sql="Select*from message"; //전체 사용
		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		
		//List<Message> list=null; //기본형 에서 null값에 불러오고 싶은 값을 넣는다. 아래 참조.
		List<Message> list=new ArrayList<Message>(); //<Message>앞뒤 형을 맞춰줘야 됨.
		
		while(rs.next()) {
			Message msg=new Message();//Message바구니 (no,name,content를 담는 곳)
			msg.setNo(rs.getInt("no")); 
			msg.setName(rs.getString("name")); 
			msg.setContent(rs.getString("content"));
			list.add(msg);
		}
		rs.close();
		pstmt.close();
		conn.close();
    return list;}
	
	
//insert함수 구현 - 데이터 삽입
	public int insert(Message msg) throws ClassNotFoundException, SQLException { //Message msg 메시지 전체 클래스 한번만 넘겨주면 메시지 클래스에 있는 내용 전부 참조 가능
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn=DriverManager.getConnection(
		"jdbc:oracle:thin:@localhost:1521:xe","hr","1234");
		//url,id,password
		
		if(conn==null) {System.out.println("DB접속에 실패");}
		System.out.println("DB접속 성공");

		String sql="insert into message(no,name,content) values(?,?,?)";
		PreparedStatement pstmt=conn.prepareStatement(sql);//위의 sql문을 처리하기 위해 객체 생성
		//(?)물음표를 채워줘야함
		pstmt.setInt(1, msg.getNo());
		pstmt.setString(2,msg.getName() );
		pstmt.setString(3,msg.getContent() );
		
		int result=pstmt.executeUpdate();
		System.out.println(result+"개가 입력되었습니다.");
		
		pstmt.close();
		conn.close();
		
		return 0;
	}
	
	
//update 데이터 업데이트
	public int update(Message msg) throws ClassNotFoundException, SQLException {
		
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
		pstmt.setString(1, msg.getContent());
		pstmt.setInt(2,msg.getNo());
		int result=pstmt.executeUpdate();//qurey는 요청, update는 변경
		System.out.println(result+"개가 수정되었습니다.");
		
		pstmt.close();
		conn.close();
		
		return 0;
	}
	
//update 데이터 삭제
	public int delete(int no) throws ClassNotFoundException, SQLException { //전체가 올 필요 없이, 참조 할 부분만 오면됨.(int no)
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","1234");
			if(conn==null) {
				System.out.println("DB접속 실패");
			}else{
				System.out.println("DB접속 성공!");
				}

			String sql="delete from message where no=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,no);
			int result=pstmt.executeUpdate();//qurey는 요청, update는 변경
			System.out.println(result+"개가 삭제되었습니다.");
			
			pstmt.close();
			conn.close();
			
			return 0;
		}


}
