package com.mvc.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContentViewCommand implements Command {

	
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		
		BoardDAO dao = BoardDAO.getInstance();
		
		BoardDTO dto = dao.getContent(Integer.parseInt(id));
		
		if(dto!=null) {
			request.setAttribute("content", dto);
			return "/board/contentView.jsp";
		}else {
			return "/list.do";
		}
		
	}

}
