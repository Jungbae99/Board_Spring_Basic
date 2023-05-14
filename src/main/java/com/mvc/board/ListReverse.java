package com.mvc.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListReverse implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDAO dao = BoardDAO.getInstance();
		List<BoardDTO> list = dao.boardList();
		
		request.setAttribute("list", list);
		return "/board/listReverse.jsp";
		
	}

}
