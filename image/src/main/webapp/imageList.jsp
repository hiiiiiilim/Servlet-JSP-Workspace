<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>이미지 목록</title>
</head>
<body>
<h1>이미지 목록</h1>
<h2>이미지 제목</h2>
<p>이미지 내용 불러오기</p>
<img alt="" src="ImageServlet?image_id=${image.boardId}">
</body>
</html>