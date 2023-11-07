<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="review.css">
</head>
<body>

  <div id="buttons">
        <button type="button" href="링크 연결할 곳">행사정보</button>
        <button type="button" href="링크 연결할 곳">예약조회</button>
        <button type="button" href="링크 연결할 곳">문의게시판</button>
        <button type="button" href="링크 연결할 곳">후기게시판</button>
    </div>

	<div id="background">
		<h1>리뷰 작성</h1>
		<div id="reviewbox">
		<form  action="reviewServlet" method="post">
			
			<label for="review_title">제목</label>
			<input type="text" id="review_title" required><br>
			
			<label for="review">내용</label>
			<input type="text" id="review" required><br>

			
			<input type="submit" value="가입">
		</form>
		</div>
	 </div>
	
	<div id="Pagebutton">
        <button id="prevbutton">이전</button>
        <button id="nextbutton">다음</button>
    </div>
	

</body>
</html>