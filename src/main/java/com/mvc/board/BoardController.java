package com.mvc.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("*.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("BoardController 입니다.");
		// service라는 메서드가 먼저 호출된다, 그리고 Get,Post이냐에 따라서 
		
		request.setCharacterEncoding("UTF-8");
		// http://localhost:8090/JSP_MVC/write.do
		
		String uri = request.getRequestURI();
		// /JSP_MVC/write.do
		
		String conPath = request.getContextPath();
		// /JSP_MVC
		
		String result = uri.substring(conPath.length());
		// /write.do
		
		System.out.println(result);
		Command command = null;
		// Command객체 : 해당요청에 대해 실제 수행하는 객체
		
		String viewPage = null;
		// jsp페이지를 지정한다
		
		
		
		if(result.equals("/list.do")) { 
			command = new ListCommand();
			viewPage = command.execute(request, response);
			
			
			
		}else if(result.equals("/writeForm.do")) {	
			viewPage = "/board/writeForm.jsp";
			
		}else if(result.equals("/write.do")) {
			command = new WriteCommand();
			viewPage = command.execute(request, response);
			
									
		}else if(result.equals("/contentView.do")) {
			
			command = new ContentViewCommand();
			viewPage = command.execute(request, response);

		}else if(result.equals("/modifyForm.do")) {
			command = new ModiftFormCommand();
			viewPage = command.execute(request, response);
			
			
		}else if(result.equals("/modify.do")) {
			command = new ModifyCommand();
			viewPage = command.execute(request, response);
			
		}else if(result.equals("/delete.do")) {
				command = new DeleteCommand();
				viewPage = command.execute(request, response);
			
		}else if(result.equals("/listReverse.do")) {
			command = new ListReverse();
			viewPage = command.execute(request, response);
		}
		
		RequestDispatcher dispatcher;
		// RequestDispatcher : 서블릿 포워딩기능의 객체
		if(viewPage != null) {
			dispatcher = request.getRequestDispatcher(viewPage); 
			// request객체의 get~메서드를 호출하면서 viewPage를 주면서 서블릿 포워딩기능의 객체를 받아온다
			
			dispatcher.forward(request, response);
			// forward 메서드를 호출해준다 (request, response 기본객체를 전달해 jsp로 전달해서 요청처리하는 요청)
		}
		
	}

}
