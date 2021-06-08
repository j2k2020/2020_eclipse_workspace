package com.iot.web;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Add2")
public class Add2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setCharacterEncoding("UTF-8");
		 response.setContentType("text/html;charset=UTF-8");
		 PrintWriter out=response.getWriter();
		 //String[] num_=request.getParameterValues("num");
		 String num_[]=request.getParameterValues("num");
		 int num=0;
		 int result=0;

		 for( int i=0; i<num_.length; i++) {
			 if(!num_[i].equals("")) {
			num=Integer.parseInt(num_[i]);
			 result+=num;	
			 }
		 }
		 
		 out.println("합계:"+result);
		 
		 
		 
		 
		 
		 
		 
		//셈 
		/* for( int i=0; i<num_.length; i++) {
			 if(!num_[i].equals("")) {
				 num=Integer.parseInt(num_[i]);
			 result+=num;	
			 }
			 num=0;
		 }*/
		 
		 /*//지원
		 for( int i=0; i<num_.length; i++) {
			int num=0;
			 if(!num_[i].equals("")) {
			num=Integer.parseInt(num_[i]);
			 result+=num;	
			 }
		 }*/
		
		 
		 
	}

}
