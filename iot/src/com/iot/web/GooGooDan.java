package com.iot.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GooGooDan")
public class GooGooDan extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//2nd
		response.setCharacterEncoding("UTF-8");  //보내는쪽setCharacterEncoding (Encoding은 암호화 한다는 뜻)
	    response.setContentType("text/html;charset=UTF-8"); //보낸걸 받는쪽setContentType
		PrintWriter out=response.getWriter();	
		int dan=2; //구구단은 2단부터~ 2로 초기화
		
		String dan_=request.getParameter("dan");//웹 브라우저가 서버에게 요청보내는 거기 때문에 request 사용
		if(dan_!=null && dan_!="") { dan=Integer.parseInt(dan_); } //cnt_를 정수로 바꾸는 함수(parseInt)를 사용해서 정수로 변경
		//dan이 null이 아니고, dan이 ""이 아닐때는  dan=Integer.parseInt(dan_);실행!! 그러면 dan의 초기값은 2이기 때문에 2단이 자동으로 실행됨.
		out.println("<"+dan+" 단><br>");
	    for( int i=2; i<=9; i++) { out.println(dan+" x "+i+" = "+dan*i+"<br>");}
			
			
	  //1st	
		/*response.setCharacterEncoding("UTF-8");  //보내는쪽setCharacterEncoding (Encoding은 암호화 한다는 뜻)
		    response.setContentType("text/html;charset=UTF-8"); //보낸걸 받는쪽setContentType
			PrintWriter out=response.getWriter();
			String dan_=request.getParameter("dan");//웹 브라우저가 서버에게 요청보내는 거기 때문에 request 사용
			int dan=Integer.parseInt(dan_); //cnt_를 정수로 바꾸는 함수(parseInt)를 사용해서 정수로 변경
			
			out.println("<"+dan+" 단><br>");
				for( int i=2; i<=9; i++) {
					out.println(dan+" x "+i+" = "+dan*i+"<br>");
				}*/
	}
}
