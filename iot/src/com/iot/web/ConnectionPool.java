package com.iot.web;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


import org.apache.tomcat.jdbc.pool.DataSource;

public class ConnectionPool {
	private static Connection conn=null;
	
	public static Connection getConnection() throws NamingException, SQLException {
		if(conn!=null) { return conn; }
		else {
			Context initContext=(Context)
					new InitialContext().lookup("java:comp/env/"); //lookup은 찾는 함수
			
			DataSource ds=
					(DataSource)initContext.lookup("jdbc/oralce");
			
			conn=ds.getConnection();
		}
		if(conn==null) {System.out.println("DB접속에 실패");}
		System.out.println("DB접속 성공");
		return conn;
		
	}
	
	

}
