package com.iot.web;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Add4_1") //session공간 분리
public class Add4_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 //서블릿이 끝나고 나서도 값을 유지할 수 있는 저장공간 만들기!
		//ServletContext application=request.getServletContext(); //저장공간!!!
		HttpSession session=request.getSession();
		
		
		 response.setCharacterEncoding("UTF-8");
		 response.setContentType("text/html;charset=UTF-8");
		 PrintWriter out=response.getWriter();
		 
		 String value_=request.getParameter("value");
		 String operator_=request.getParameter("operator");
		 
		 int value=0; //값 초기화
		 if(!value_.equals("")) value=Integer.parseInt(value_); //정수 변환
		 
		 if(session.getAttribute("result")==null) {
			 session.setAttribute("result", 0);
		 }
		 
		 if(session.getAttribute("operator")==null) {
			 session.setAttribute("operator", "+");	 
		 }
	
		 if(operator_.equals("=")) {
			 //연산 후 출력(이전 저장되어 있는 오퍼레이트를 가져와 계산)
			 int result=0;
			 
			   if(session.getAttribute("operator").equals("+")) {
				 result=(Integer)session.getAttribute("result")+value;
			   }
			   else if(session.getAttribute("operator").equals("-")) {
				 result=(Integer)session.getAttribute("result")-value;
			   }
			   out.println("결과:"+result);
			   session.removeAttribute("result");
			   session.removeAttribute("operator");
			   
		 }else {
			  //이전 저장되어 있는 오페리이트를 가져와 계산만 하는 작업 그리고 결과를 임시 저장
			  if(session.getAttribute("operator").equals("+")) {
				  session.setAttribute("result", (Integer)session.getAttribute("result")+value);//application앞에 (Integer)를 넣어서 정수형으로 형변화하여 value랑 같은 형으로 변경해줘야 됨.
			  } else if(session.getAttribute("operator").equals("-")) {
				  session.setAttribute("result", (Integer)session.getAttribute("result")-value);
			  }
			  //실시간으로 저장소 확인
			  System.out.println(session.getAttribute("result"));
		 
		 }
		 
		 session.setAttribute("operator", operator_);	 
		
}
}
