package com.iot.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Add5")
public class Add5 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		String value_=request.getParameter("value");
		String operator=request.getParameter("operator");
		
		int value=0;
		if(!value_.equals("")) value=Integer.parseInt(value_);
		
		//Cookie cookie=new Cookie("c",value_);
		//Cookie cookie=new Cookie("c",String.valueOf(value));
		
		//클라이언트로 부터 쿠기 받아오기
		Cookie[] cookies=request.getCookies();
		
		String v="0";
		String op="+";
		
		if(cookies!=null) { //클라이언트가 쿠키가 있으면 받아와서 사용 그렇지 않을 경우 생성
			for(Cookie cookie:cookies) {
				if("v".equals(cookie.getName())) v=cookie.getValue();
				else if("op".equals(cookie.getName())) op=cookie.getValue();
			}
		}/*else { //쿠키가 없을 경우 처리
			v="0";
			op="+";
		}
		*/
		if(op.equals("=")) {
			//연산 후 출력(이전 저장되어 있는 오퍼레이트를 가져와 계산)
			int result=0;
			if(op.equals("+")) {
				result=Integer.parseInt(v)+value;
			
			}else if(op.equals("-")) {
				result=Integer.parseInt(v)-value;
			}
			System.out.println(result);
			out.println("결과:"+result);
		
			/*
			 * 쿠키 삭제
			 */

			}else {
			int imsi=0;
			//이전 저장되어 있는 오퍼레이트를 가져와 계산만 하는 작업 그리고 결과를 임시 저장
			if(op.equals("+")) {
				imsi=Integer.parseInt(v)+value;
				Cookie cookie=new Cookie("v",String.valueOf(imsi));
				response.addCookie(cookie);
				
			}else if(op.equals("-")) {
				imsi=Integer.parseInt(v)-value;
				Cookie cookie=new Cookie("v",String.valueOf(imsi));
				response.addCookie(cookie);
			}
			//실시간으로 저장소에 저장되는 값을 확인
			System.out.println(imsi);
			System.out.println("redirect before");
			response.sendRedirect("Add5.html"); //값과 상관없이 화면 전환 (정적 페이지)
		}
		
		Cookie cookie=new Cookie("op",operator);
		response.addCookie(cookie);
		System.out.println("redirect after");
		
		
		//response.sendRedirect("add5.html");
	}

}
