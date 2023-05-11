package com.mvc.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModiftFormCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		
		BoardDAO dao = BoardDAO.getInstance();
		
		BoardDTO dto = dao.modifyForm(Integer.parseInt(id));
		
		request.setAttribute("modify", dto);
		
		return "/board/modifyForm.jsp";
	}

}
