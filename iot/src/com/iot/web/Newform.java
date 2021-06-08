package com.iot.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Newform")
public class Newform extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");  //보내는쪽setCharacterEncoding (Encoding은 암호화 한다는 뜻)
	    response.setContentType("text/html;charset=UTF-8"); //보낸걸 받는쪽setContentType
	    request.setCharacterEncoding("UTF-8");  
	   
	    PrintWriter out=response.getWriter();
	    
	    String button=request.getParameter("button");
	    String color=request.getParameter("color");
	    String datetime_local=request.getParameter("datetime_local");
	    String email=request.getParameter("email");
	    String file=request.getParameter("file");
	    String hidden=request.getParameter("hidden");
	    String image=request.getParameter("image");
	    String month=request.getParameter("month");
	    String number=request.getParameter("number");
	    String radio=request.getParameter("radio");
	    String range=request.getParameter("range");
	    String search=request.getParameter("search");
	    String tel=request.getParameter("tel");
	    String time=request.getParameter("time");
	    String url=request.getParameter("url");
	    String week=request.getParameter("week");
	    
	    out.println("button:"+button+"<br>");
	    out.println("color:"+color+"<br>");
	    out.println("datetime_local:"+datetime_local+"<br>");
	    out.println("email:"+email+"<br>");
	    out.println("file:"+file+"<br>");
	    out.println("image"+image+"<br>");
	    out.println("month"+month+"<br>");
	    out.println("number"+number+"<br>");
	    out.println("radio"+radio+"<br>");
	    out.println("range"+range+"<br>");
	    out.println("search"+search+"<br>");
	    out.println("tel"+tel+"<br>");
	    out.println("time"+time+"<br>");
	    out.println("url"+url+"<br>");
	    out.println("week"+week+"<br>");
	    
	    
	    
	    
	}

}
