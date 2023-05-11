package com.mvc.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
	// controller에서 받은 요청을 처리하고, 
	// 필요한 데이터를 갖고 컨트롤러로 보낸다.
	// 컨트롤러에서 받은 요청을 분석해서 각 처리에 해당하는 비즈니스로직을 수행후 필요한 데이터를 가지고 컨트롤러로 보내준다
	public String execute(HttpServletRequest request,  HttpServletResponse response);
	
}
