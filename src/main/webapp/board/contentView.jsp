<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
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
<!-- id를 받아와서 이것을 이용해 내용을 출력 -->

<br><hr>
<h2><a href="/JSP_MVC/list.do">게시판 목록으로 가기</a></h2>
<hr><br>
<h2>${content.title } 내용보기</h2>
<br><hr><br>

<table border="1">

<tr>
<th>글번호</th>
<td>${content.id}</td>
</tr>

<tr>
<th>조회수</th>
<td>${content.viewCount}</td>
</tr>

<tr>
<th>작성자</th>
<td>${content.writer}</td>
</tr>

<tr>
<th>제목</th>
<td>${content.title}</td>
</tr>

<tr>
<th>내용</th>
<td>${content.content}</td>
</tr>

<tr>
<td colspan="2">
<form action="/JSP_MVC/modifyForm.do" method="post">
<input type="hidden" name="id" value="${content.id}">
<input type="submit" value="글 수정">
</form>

&nbsp;&nbsp;

<form action="/JSP_MVC/delete.do" method="post">
<input type="hidden" name="id" value="${content.id}">
<input type="submit" value="글 삭제">
</form>

</td>
</tr>

</table>


</body>
</html>