package com.iot.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Form")
public class Form extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");  //보내는쪽setCharacterEncoding (Encoding은 암호화 한다는 뜻)
	    response.setContentType("text/html;charset=UTF-8"); //보낸걸 받는쪽setContentType
	    request.setCharacterEncoding("UTF-8");  
	   
	    PrintWriter out=response.getWriter();
	    
	    String id=request.getParameter("id");
	    String password=request.getParameter("password");
	    String save=request.getParameter("save");
	    String inotice=request.getParameter("inotice");
	    String job=request.getParameter("job");
	    //String s=request.getParameter("s");
	    int s=Integer.parseInt(request.getParameter("s")); //문자 대신 숫자로 쓸 경우
	    String food[]=request.getParameterValues("food"); //food를 배열로 선언
	    String date=request.getParameter("date"); //생년월일 받기
	   
	
	   Date d=new Date(); //생년월일 날짜를 받아서 저장
	   SimpleDateFormat old_date_format=new SimpleDateFormat("yyyy-MM-dd");
	   SimpleDateFormat new_date_format=new SimpleDateFormat("yyyy년 MM월 dd일");
	   SimpleDateFormat new2_date_format=new SimpleDateFormat("yyyy/MM/dd");

		  try {
			d=old_date_format.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	    String new_date=new_date_format.format(d);
	    String new2_date=new2_date_format.format(d);
	    
	    out.println("id:"+id+"<br>");
	    out.println("password:"+password+"<br>");
	    out.println("save:"+save+"<br>");
	    out.println("inotice:"+inotice+"<br>");
	    out.println("job:"+job+"<br>");
	    out.println("s:"+s+"<br>");
	    for(int i=0; i<food.length; i++) {
	    	out.println("food"+i+":"+food[i]+"<br>");
	    }
	    
	    out.println("생년월일:"+date+"<br>");
	    out.println("생년월일:"+new_date+"<br>");
	    out.println("생년월일:"+new2_date+"<br>");
	    
	    

}
}
