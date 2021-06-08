package com.iot.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieRecv")
public class CookieRecv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies=request.getCookies();
		
		if(cookies!=null) { //클라이언트가 쿠키가 있으면 받아와서 사용 그렇지 않을 경우 생성
			for(Cookie cookie:cookies) {
				System.out.println(cookie.getName()+":"+cookie.getValue());
			
				//if("+".equals(cookie.getName())) {}  //+에 쿠키를 가져와 비교
				//if(cookie.getName().contentEquals("+")) {} //쿠키를 가져와 +와 비교
				
				//cookie.setMaxAge(60); //쿠키의 보관 기한-(60)초 동안 보관
				
			}
			
			
		}
	}

}