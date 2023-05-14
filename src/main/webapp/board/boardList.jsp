<%@page import="java.util.List"%>
<%@page import="com.mvc.board.BoardDTO"%>
<%@page import="com.mvc.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<%
  List<BoardDTO> list = (List<BoardDTO>) request.getAttribute("list");
  if (list != null) {}
%>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  </head>
  <body>
    <h1>Jungbae Board!</h1>
    <table class = "table" border="1">

<thead>
    <tr>
      <th scope="col">번호</th>
      <th scope="col">작성자</th>
      <th scope="col">제목</th>
      <th scope="col">등록일</th>
      <th scope="col">조회수</th>
    </tr>
  </thead>

<tbody class="table-group-divider">		
	<%int rowIndex = list.size();%>
	<c:forEach var="dto" items="${list}" >
	
		<tr>
		 	<th scope="row" ><%= rowIndex-- %></th>
			<td>${dto.writer }</td>
			<td>
				<a href="/JSP_MVC/contentView.do?id=${dto.id}" >${dto.title }</a>
			</td>		
			<td>
				<fmt:formatDate value="${dto.regDate }" pattern="yyyy-MM-dd일  HH : mm"/>
			</td>
			
			<td>${dto.viewCount }</td>
		</tr>
	</c:forEach>

	<tr>
		<td colspan="5">
			<a href="/JSP_MVC/writeForm.do">
  				<button type="button" class="btn btn-secondary"
        		data-bs-toggle="tooltip" data-bs-placement="top"
        		data-bs-custom-class="custom-tooltip"
        		data-bs-title="This top tooltip is themed via CSS variables.">
  				create
				</button>
			</a> 
  		</td>
  		
  		<td colspan="10">
			<a href="/JSP_MVC/listReverse.do">
  				<button type="button" class="btn btn-secondary"
        		data-bs-toggle="tooltip" data-bs-placement="top"
        		data-bs-custom-class="custom-tooltip"
        		data-bs-title="This top tooltip is themed via CSS variables.">
  				old
				</button>
			</a> 
		</td>
	</tr>
</tbody>	
</table>  	

  




    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
  </body>
</html>

