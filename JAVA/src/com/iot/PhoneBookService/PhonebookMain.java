package com.iot.PhoneBookService;
import java.sql.SQLException;

public class PhonebookMain {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		PhonebookUI pbui=new PhonebookUI();
	
	while(true) {
	pbui.menu();
	pbui.menu_proc(pbui.menu_input());
	}
	
	
	}
}
