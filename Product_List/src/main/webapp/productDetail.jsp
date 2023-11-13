<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.product.Product" %>
<%@ page import="com.kh.product.ProductDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>제품 상세 정보</title>
       <style>

        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
             text-align: center;
        }

        h1 {
            background-color: #333;
            color: #fff;
            padding: 10px;
            text-align: center;
        }

        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            background-color: #fff;
        }

        table, th, td {
            border: 1px solid #ccc;
        }

        th, td {
            padding: 10px;
            text-align: left;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #e0e0e0;
        }
    </style>
</head>
<body>
	<h1>제품 상세 정보</h1>
	<%
		//String =  id 값을 가지고 오겠다.
		String productIdValue = request.getParameter("productId");
		int productId = Integer.parseInt(productIdValue);
		//DAO 작업
		ProductDAO productDAO = new ProductDAO();
		Product product = productDAO.getProductId(productId);
	%>
	<p>제품 ID: <%=product.getProductId() %></p>
	<p>제품 이름: <%=product.getProductName() %></p>
	<p>제품 가격: <%=product.getPrice() %></p>
	<p>제품 카테고리: <%=product.getCategory() %></p>
	<p>재고 수량: <%=product.getStockQuantity() %></p>
	
</body>
</html>