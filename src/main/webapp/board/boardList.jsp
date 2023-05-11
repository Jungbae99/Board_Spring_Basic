<%@page import="com.mvc.board.BoardDTO"%>
<%@page import="com.mvc.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%-- EL. jstl. table 태그를 사용하여 게시판 목록 만들기 --%>

<table border="1">

	<tr>
		<th>번호</th>
		<th>작성자</th>
		<th>제목</th>
		<th>등록일</th>
		<th>조회수</th>
	</tr>
		
	<c:forEach var="dto" items="${list}" >
		<tr>
			<td>${dto.id }</td>
			<td>${dto.writer }</td>
			
			<td>
			<a href="/JSP_MVC/contentView.do?id=${dto.id}" >${dto.title }</a>
			</td>
				
			<td>
				<fmt:formatDate value="${dto.regDate }" pattern="yyyy-MM-dd"/>
			</td>
			
			<td>${dto.viewCount }</td>
		</tr>
	
	</c:forEach>

	<tr>
		<td colspan="5">
			<a href="/JSP_MVC/writeForm.do">글 작성하기</a>
		</td>
	</tr>

</table>

</body>
</html>