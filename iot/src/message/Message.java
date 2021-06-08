package message;
/*
 oracle sql
 create table message( no integer, name varchar2(10), content varchar2(20));
 select*from message;
 insert into message(no, name, content)values(1,"홍길동","메모없음");
 update message set content='메모없음' where no=1;
 delete from message where no=1;
 */
public class Message {
	private int no;
	private String name;
	private String content;
	
	public Message() {  //Message바구니에 대한 기본 생성자
		
	}

	// source->generate using fields 
	public Message(int no, String name, String content) {
		this.no = no;
		this.name = name;
		this.content = content;
	}

	//source->generate getters and setters
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	

}

