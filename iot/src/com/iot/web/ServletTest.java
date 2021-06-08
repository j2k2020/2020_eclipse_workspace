package com.iot.web;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletTest")
public class ServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//init()함수는 서블릿이 최초실행 되었을 때만 최초로 실행되는 함수
	public void init(ServletConfig config) throws ServletException {
	  System.out.println("init 함수 호출");
	}

	//서블릿이 호출되었을 경우 무조건 실행되는 함수
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 System.out.println("service함수 요청");
		 
		if(request.getMethod().equals("GET")) {
			 System.out.println("Get함수 요청");
		}else if(request.getMethod().equals("POST")) {
			 System.out.println("Post함수 요청");
		}
		super.service(request, response);
	}

	//doGet,doPost는 서비스에서 super.service()호출될 때 실행되는 함수
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		 System.out.println("doGet함수 실행");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		 System.out.println("doPost함수 요청");
	}

}






