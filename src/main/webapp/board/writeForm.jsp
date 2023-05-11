<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

</head>
<body>

	<br><br>
	<h2>글 작성 폼</h2>
	<hr><br>
	
	<form action="/JSP_MVC/write.do" method="post">
		<table>
		
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer"></td>
			</tr>
			
			<tr>
				<th>제목</th>
				<td><input type="text" name="title"></td>
			</tr>
			
			<tr>
				<th>내용</th>
				<td><input type="text" name="content" cols="22" rows="5" ></td>
			</tr>
			
			<tr>
				<td colspan="2">
					<input type="submit" value="글 등록">
				</td>
			</tr>	
				
		</table>
	</form>
	
	
</body>
</html>