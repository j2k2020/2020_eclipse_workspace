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

@WebServlet("/Add7_proc")
public class Add7_proc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
			
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset=\"UTF-8\">");
			out.println("<title>Insert title here</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<form action=\"Add7\" method=\"post\">");
			out.println("<input type=\"text\" name=\"value\">");
			out.println("<br>");
			out.println("<input type=\"submit\" name=\"operator\" value=\"+\">");
			out.println("<input type=\"submit\" name=\"operator\" value=\"-\">");
			out.println("<input type=\"submit\" name=\"operator\" value=\"=\">");
			out.println("<br>");
			out.println("결과:"+request.getAttribute("result"));
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");			
						
			  	
	}

}
