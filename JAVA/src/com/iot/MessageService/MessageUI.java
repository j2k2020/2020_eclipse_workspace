package com.iot.MessageService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//페키지를 만들때, 꼭~ 라이브러리랑 같은 곳에 만들기~
public class MessageUI {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		MessageService ms=new MessageService();
		//메시지 리스트 출력
		/*
		List<Message> list=ms.getList();
		for(int i=0;i<list.size();i++) {
			Message msg=list.get(i);
			System.out.printf("%d %s %s \n",msg.getNo(),msg.getName(),msg.getContent());
		}
		*/
		
		//메시지 입력
		/*
		Message msg=new Message(5,"bak","kim message");
		ms.insert(msg);
		*/
		
		//메시지 수정
		/*
		Message msg=new Message(5,"","change message");
		ms.update(msg);
		*/
		
		//메시지 삭제
		//ms.delete(5);
		
		while(true) {
		//메뉴만들기
		System.out.println("____________________________");
		System.out.println("	MESSAGE MENU		");
		System.out.println("____________________________");
		System.out.println("1. 출력");
		System.out.println("2. 입력");
		System.out.println("3. 수정");
		System.out.println("4. 삭제");
		System.out.println("5. 프로그램 종료");
		System.out.println("____________________________");
		Scanner sc=new Scanner(System.in);
		//String num=sc.nextLine();
		int num=Integer.parseInt(sc.nextLine());
		Message msg=new Message();
		//System.out.println(num);
		switch(num) {
		case 1 : //출력(getList()) 
			List<Message> list=ms.getList();
			for(int i=0;i<list.size();i++) {
				msg=list.get(i);
				System.out.printf("%d %s %s \n",msg.getNo(),msg.getName(),msg.getContent());
			}
			break;
		case 2 : //입력(insert(Message msg))
			System.out.println("번호 이름  내용입력[2 홍길동 없음]");
			msg.setNo(sc.nextInt());
			msg.setName(sc.next());
			msg.setContent(sc.next());
			ms.insert(msg);
			break;
			
		case 3 : //수정(update(message msg))
			System.out.println("수정할번호와 내용을 입력하세요.[2 메시지]");
			msg.setNo(sc.nextInt());
			msg.setContent(sc.next());
			ms.update(msg);
			break;
			
		case 4 : //삭제(delete(int no))
			System.out.println("삭제할 번호를 입력하세요.[2]");
			int no=sc.nextInt();
			ms.delete(no);
			break; 
		
		case 5 : //프로그램 종료
			System.out.println("프로그램을 종료합니다.");
			System.exit(1);
			break;
			
		default : break;
		}//case end
		}//while end
		}

	}
