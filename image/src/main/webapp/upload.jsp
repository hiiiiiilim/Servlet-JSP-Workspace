<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>+6-*/32-+


<head>
<meta charset="utf-8">
<title>이미지 업로드</title>
</head>
<body>
	<h1>이미지 업로드</h1>
	<!-- 
		action = 폼데이터가 제출될 때 해당 데이터를 처리할 서블릿을 지정하는 속성
		지정된 서블릿으로 폼데이터가 전송
		method = "post" 폼데이터를 서버로 제출할때 사용할 HTTP메서드를 지정하는 속성
		enctype = 폼데이터가 파일 업로드와 같은 바이너리 데이터를 포함할때 사용되는 인코딩 타입을 지정하는 속성
				mulipart/form-data 파일 업로드를 위한 표준 인코딩 방식
				파일이나 일반 텍스트를 함께 전송할 수 있음.
	 -->
	<form action="UploadServlet" method="post" enctype="multipart/form-data">
		<label for="title">제목 : </label>
		<input type="text" name="title" id="title" required><br>
		<label for="content">내용 : </label>
		<input type="text" name="content" id="content" required><br>
		<label for="image">이미지</label>
		<input type="file" name="image" id="image" required><br>
		
		<button type="submit">업로드</button>
	</form>
</body>
</html>