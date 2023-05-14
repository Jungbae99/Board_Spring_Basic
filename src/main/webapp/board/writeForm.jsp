<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  
  	<style>
      .form-table {
        margin-bottom: 20px;
      }
      .submit-btn {
        margin-top: 20px;
      }
    </style>
  </head>
<body>

	<br><br>
	<h2>Create Form</h2>
	<hr>
	
	<form action="/JSP_MVC/write.do" method="post">	
			<div class="mb-3">
  				<label for="exampleFormControlInput1" class="form-label">작성자</label>
  				<input type="text" class="form-control" name="writer" placeholder="작성자를 입력하세요">
  				
			</div>
			
			
			<div class="mb-3">
  				<label for="exampleFormControlInput1" class="form-label">제목</label>
  				<input type="text" class="form-control" name="title" placeholder="제목을 입력하세요">
  				
			</div>
			
			
			<dev class="mb-3">
				<label for="exampleFormControlTextarea1" class="form-label">내용</label>
				<td><textarea class="form-control" type="text" name="content" cols="22" rows="5" ></textarea></td>
			</dev>
			
			<br>
			<div class="col-12">
    			<button type="submit" class="btn btn-primary">글 등록</button>
  			</div>
				
		</table>
	</form>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>


