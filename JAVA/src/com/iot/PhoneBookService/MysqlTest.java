package com.iot.PhoneBookService;

import java.sql.SQLException;
import java.util.List;

public class MysqlTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		PhonebookService2 service=new PhonebookService2();
		
		List<Phonebook> list=service.getList();
		for(Phonebook out:list){
			System.out.printf("%d %s %s %s\n",out.getNo(),out.getName(),out.getPHnum(),out.getMemo());
		}

	}
}
