package com.iot.web;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Add1")
public class Add1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setCharacterEncoding("UTF-8");
		 response.setContentType("text/html;charset=UTF-8");
		 PrintWriter out=response.getWriter();
		 
		 String x_=request.getParameter("x");
		 String y_=request.getParameter("y");
		 int x=0;
		 int y=0;
		 if(!x_.equals("")) x=Integer.parseInt(x_); //문자열을 정수로 변환 작업
		 if(!y_.equals("")) y=Integer.parseInt(y_); //문자열을 정수로 변환 작업
		 int sum=0; //x,y값이 않들어 올 수도 있이니, 초기화를 해준다.
         sum=x+y;
         out.printf("%d+%d=%d",x,y,sum);
         
		 
		 
	}

}
