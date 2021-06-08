package com.iot.PhoneBookService;

public class Phonebook {
	//1. select 구문 가지와서 맴버변수만 선언
		int no;
		String name;
		String PHnum;
		String memo;
		//2. 기본생성자, 맴버변수 생성자
		public Phonebook() { }
		
		//3.get, set함수
		public Phonebook(int no, String name, String PHnum, String memo) {
			this.no = no;
			this.name = name;
			this.PHnum = PHnum;
			this.memo = memo;
		}

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

		public String getPHnum() {
			return PHnum;
		}

		public void setPHnum(String PHnum) {
			this.PHnum = PHnum;
		}

		public String getMemo() {
			return memo;
		}

		public void setMemo(String memo) {
			this.memo = memo;
		}
		
		
		
		
		
	}
