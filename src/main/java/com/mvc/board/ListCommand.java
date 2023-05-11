package com.mvc.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		BoardDAO dao = BoardDAO.getInstance();
		List<BoardDTO> list = dao.boardList();
		
		request.setAttribute("list", list);
		// request 영역에 ArrayList 객체를 바인딩한다.
		
		return "/board/boardList.jsp";
		// ContextPath를 제외한 나머지 jsp경로를 문자열로 반환한다.
	}

}
