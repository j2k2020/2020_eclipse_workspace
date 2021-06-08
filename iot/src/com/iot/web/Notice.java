package com.iot.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Notice")
public class Notice extends HttpServlet {
	private static final long serialVersionUID = 1L;
//서버역할의 전달만 받는 구문
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");  //보내는쪽setCharacterEncoding (Encoding은 암호화 한다는 뜻)
	    response.setContentType("text/html;charset=UTF-8"); //보낸걸 받는쪽setContentType
	    
	    //request.setCharacterEncoding("UTF-8");  //보내온 것에 대해 처리 한다.(웹 브라우저->서버) 
	    //이 내용이 있어야   method="post"가 한글을 읽는다.
	    
		PrintWriter out=response.getWriter();
				
		String title=request.getParameter("title");//웹 브라우저가 서버에게 요청보내는 거기 때문에 request 사용
		String content=request.getParameter("content");
		
		out.println(title);
		out.println(content);
		
		
		
		
		
	}

}
