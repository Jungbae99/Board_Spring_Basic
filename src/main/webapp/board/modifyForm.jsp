<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
*{
text-align: center;
margin: 0 auto;
}

form{
display: inline-block;
}

</style>

</head>
<body>

	<br><br>
	<h2>글 수정 폼</h2>
	<hr><br>
	
	<form action="/JSP_MVC/modify.do" method="post" >
	
		<input type="hidden" name="id" value= "${modify.id }">
		<table border="1">
		
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer" value ="${modify.writer }" ></td>
			</tr>
			
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" value ="${modify.title }"></td>
			</tr>
			
			<tr>
				<th>내용</th>
				<td><textarea type="text" name="content" cols="22" rows="5" >${modify.content }</textarea></td>
			</tr>
			
			<tr>
				<td colspan="2">
					<input type="submit" value="글 수정">
				</td>
			</tr>	
				
		</table>
	</form>


</body>
</html>