
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import www.message.entity.Message;
import www.message.entity.PageMessage;
import www.message.service.MessageService;

@WebServlet("/Update.do")
public class UpdateDoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//사용자가 접속하는 url주소를 기준으로 주소를 분석함
		//context경로 포함해서 url출력	
		String url=request.getRequestURI();
		System.out.println(url);
		//contextpath를 출력
		String contextPath=request.getContextPath();
		System.out.println(contextPath);
		//contextPath를 이용하여 최종url만 추출
		String path
		=url.substring(contextPath.length());
		System.out.println(path);
				
				//한글 깨지는 문제 해결
				request.setCharacterEncoding("UTF-8");
				
			//1. 파라메터정보 저장(request.getParameter())
			int no=Integer.parseInt(request.getParameter("no"));
			String name=request.getParameter("name");
			String content=request.getParameter("content");
			System.out.println("control-name:"+name);
			System.out.println("control-content:"+content);
			Message message=new Message(no,name,content);
								
			//2.데이터베이스 처리
			//message객체 만들기-DB접속 데이터처리(Service)
				MessageService service
				=MessageService.getInstance();
				int success = service.update(message); //success 1성공 0실패
				String page="";
				if(success<1) {//입력 실패에 대한 페이지로 이동
					page="/WEB-INF/message/update_fail.jsp";
				}else {//입력 성공에 대한 페이지로 이동
					page="/WEB-INF/message/update_sucess.jsp";
				}
				
				//3.데이터를 dispatcher로 view에게 전달하면 끝
				//request.setAttribute("success",success);
				
				//4.저장한 데이터와 함께 view생성하기 위해 넘겨줌
				RequestDispatcher dispatcher
				=request.getRequestDispatcher(page);
				 try {
					dispatcher.forward(request, response);
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}
	}


}


