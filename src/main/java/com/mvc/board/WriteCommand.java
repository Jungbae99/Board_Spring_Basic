package com.mvc.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WriteCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDTO dto = new BoardDTO();
		
		dto.setWriter(request.getParameter("writer"));
		dto.setTitle(request.getParameter("title"));
		dto.setContent(request.getParameter("content"));
		
		
		BoardDAO dao = BoardDAO.getInstance();
		
		
		int result = dao.boardInsert(dto);
		
		String msg = null;
		String url = null;
		
		if(result == 1) {
			msg = "글이 등록되었습니다";
			url = "/JSP_MVC/list.do";
		}else {
			msg = "글이 등록되지 않았습니다";
			url = "/JSP_MVC/writeForm.do";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return "/board/message.jsp";
	}

}
