package com.mvc.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		
		BoardDAO dao = BoardDAO.getInstance();
		
		int result = dao.boardDelete(Integer.parseInt(id));
		
		String msg = null;
		String url = null;
		
		if(result ==1) {
			msg="글이삭제되었습니다";
			url = "/JSP_MVC/list.do";
		}else {
			msg=" 글이 삭제되지 않았습니다";
			url = "/JSP_MVC/list.do";
		}
		request.setAttribute("url", url);
		request.setAttribute("msg", msg);
		
		return "/board/message.jsp";
		
	
	}

}
