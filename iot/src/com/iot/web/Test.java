package com.iot.web;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//4rd
		response.setCharacterEncoding("UTF-8");  //보내는쪽setCharacterEncoding (Encoding은 암호화 한다는 뜻)
	    response.setContentType("text/html;charset=UTF-8"); //보낸걸 받는쪽setContentType
		PrintWriter out=response.getWriter();
				
		String cnt_=request.getParameter("cnt");//웹 브라우저가 서버에게 요청보내는 거기 때문에 request 사용
		int cnt=Integer.parseInt(cnt_); //cnt_를 정수로 바꾸는 함수(parseInt)를 사용해서 정수로 변경
		
		for( int i=0; i<cnt; i++) {
		out.println("서버에 접속한 것을 환영 합니다.<br>");
		//internet explorer, chrome다 변경사항 없이 한글을 출력 가능
		}
		
		
		//3rd
		/*
		response.setCharacterEncoding("UTF-8");  //보내는쪽setCharacterEncoding (Encoding은 암호화 한다는 뜻)
        response.setContentType("text/html;charset=UTF-8"); //보낸걸 받는쪽setContentType
		PrintWriter out=response.getWriter();
		out.println("서버에 접속한 것을 환영 합니다.<br>");
		//internet explorer, chrome다 변경사항 없이 한글을 출력 가능
		 */
		
		
		//2nd
		/*
		response.setCharacterEncoding("UTF-8");  //보내는쪽setCharacterEncoding (Encoding은 암호화 한다는 뜻)
		PrintWriter out=response.getWriter();
		out.println("서버에 접속한 것을 환영 합니다.<br>");
		//internet explorer ->오른쪽->인코딩->UTF-8선택, chrome은 호환이 불가
		 */
		
		
		//1st
		/*for(int i=0; i<100; i++) {
		//out.print("Hello client");
		//out.println("Hello client");	
		//out.println("Hello client<br>");	
      }*/
		
	}

}
