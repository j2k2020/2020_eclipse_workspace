package com.iot.PhoneBookService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class PhonebookUI {
	//메뉴출력
	public void menu() {
		System.out.println("____________________________");
		System.out.println("	PHONEBOOK MENU		");
		System.out.println("____________________________");
		System.out.println("1. 출력");
		System.out.println("2. 입력");
		System.out.println("3. 수정");
		System.out.println("4. 삭제");
		System.out.println("5. 프로그램 종료");
		System.out.println("____________________________");	
	}
	//메뉴입력받기
	public int menu_input() {
		Scanner sc=new Scanner(System.in);
		return Integer.parseInt(sc.nextLine());
	}
	//메뉴처리출력
	public void menu_proc(int num) throws ClassNotFoundException, SQLException {
		//메뉴를 처리하는 함수로서 번호를 입력받아 스위치문으로 처리
		//메뉴처리하는데 필요한 사항
		//1.DB처리 서비스, 2.데이터를 보관장소인 Phonebook, 3.DB입력 스캐너
		PhonebookService service=new PhonebookService(); //db처리
		Phonebook data=new Phonebook(); //데이터 보관 장소
		Scanner input=new Scanner(System.in); //DB입력 스캐너
		
		switch(num) {
		case 1 : //출력(getList()) 
			List<Phonebook> list=service.getList();
			for(Phonebook out:list){
				System.out.printf("%d %s %s %s\n",out.getNo(),out.getName(),out.getPHnum(),out.getMemo());
			}
			break;
		case 2 : //입력(insert(Phonebook pb))
			System.out.println("번호 이름 전화번호 메모[2 홍길동 010-1111-1111 없음]");
			data.setNo(input.nextInt());
			data.setName(input.next());
			data.setPHnum(input.next());
			data.setMemo(input.next());
			
			service.insert(data);
			break;
			
		case 3 : //수정(update(Phonebook pb))
			System.out.println("수정할 전화번호와 이름을 입력하세요.[홍길동 010-1111-1111]");
			data.setName(input.next());
			data.setPHnum(input.next());
			
			service.update(data);
			break;
			
		case 4 : //삭제(delete(int no))
			System.out.println("삭제할 번호를 입력하세요.[2]");
			int no=input.nextInt();
			service.delete(no);
			break; 
		
		case 5 : //프로그램 종료
			System.out.println("프로그램을 종료합니다.");
			System.exit(1);
			break;
			
		default : break;
		}
	}

}
