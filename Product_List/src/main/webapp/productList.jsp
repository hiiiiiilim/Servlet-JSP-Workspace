<%@page import="com.kh.product.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="com.kh.product.Product" %>
<%@ page import= "com.kh.product.ProductDAO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품목록</title>
</head>
<body>
	<h1>제품목록</h1>
	<table border="1">
		<tr>
			<th>제품ID</th>
			<th>제품명</th>
			<th>카테고리</th>
			<th>가격</th>
			<th>수량</th>
		</tr>
		<%
			ProductDAO productDAO = new ProductDAO();
			List<Product> products = productDAO.getAllProducts();
			
			for(Product p : products){
		%>
		<tr>
			<td> <a href="productDetail.jsp?productId=<%=p.getProductId()%>">
				<%=p.getProductId() %>
			</a></td>
			<td> <%=p.getProductName() %></td>
			<td> <%=p.getCategory() %></td>
			<td> <%=p.getPrice() %></td>
			<td> <%=p.getStockQuantity() %></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>

<!-- 
	<ul>
		< %
			//제품목록을 ArrayList에 저장
			/*
				ArrayList<Product> products = new ArrayList<>();
				products.add(new Product(1, "노트북", "전자제품", 899.99,10));
				products.add(new Product(2,"냉장고", "가전제품", 799.99,10));
			*/
			
			ArrayList<Product> products = (ArrayList<Product>) request.getAttribute("products");
			
			for(Product p : products){
		% >
			<li>< %=p.getProductName() % >의 가격 < %=p.getPrice() % ></li>
		< %
			}
		% >
	</ul>
 -->