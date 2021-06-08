package com.iot.web;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Add3")
public class Add3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 //서블릿이 끝나고 나서도 값을 유지할 수 있는 저장공간 만들기!
		ServletContext application=request.getServletContext(); //저장공간!!!
		
		 response.setCharacterEncoding("UTF-8");
		 response.setContentType("text/html;charset=UTF-8");
		 PrintWriter out=response.getWriter();
		 
		 String value_=request.getParameter("value");
		 String operator_=request.getParameter("operator");
		 
		 int value=0;
		 if(!value_.equals("")) value=Integer.parseInt(value_);
		 
		 //무조건 application 저장소에 저장 시키자
		  // application.setAttribute("application", operator_);
		  // application.setAttribute("value", value);
		 
		 if(operator_.equals("+")) {
			// out.println("덧셈을 합니다.");
			 
			// application.setAttribute("result", 0); 
			// application.getAttribute("result"); 
			//아래 코드는 set가 안된 상황에서 get을 요청하므로 문제가 발생해서 사용 불가!
		    //application.setAttribute("result", value + (Integer)application.getAttribute("result"));
			 
			     if(application.getAttribute("result")==null) {				 
				      // System.out.println("저장소 없음");
				      // System.out.println(value); //넘어가는 값 확인용
				      application.setAttribute("result", value);
				       // System.out.println((Integer)application.getAttribute("result"));	
				   } else { 
			           application.setAttribute("result", (Integer)application.getAttribute("result")+value);
			           // System.out.println("저장소 있음");
			           // System.out.println(value);//넘어가는 값 확인용
			           // System.out.println((Integer)application.getAttribute("result")); 
			       } 
		 }
		 
		 
		 else if(operator_.equals("-")) {
		    // out.println("뺄셈을 합니다.");
			    if(application.getAttribute("result")==null) {
				      application.setAttribute("result", -value);
			 } else { 
			            application.setAttribute("result",(Integer)application.getAttribute("result")-value); }	 
		 }
		 
		 
		 else if(operator_.equals("=")) {
			// out.println("결과를 계산 합니다.");
			      if(application.getAttribute("result")==null)  { out.println("계산한 결과가 없습니다."); } 
			      else { out.println("결과값:"+(Integer)application.getAttribute("result")); }			 		 
	}
}
}
