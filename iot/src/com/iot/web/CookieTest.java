package com.iot.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieTest")
public class CookieTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie cookie1=new Cookie("name1","value1"); //서버가 쿠키만드는 줄
		response.addCookie(cookie1); //쿠키 보내기
		Cookie cookie2=new Cookie("name2","value2");
		response.addCookie(cookie2);
	}
}
