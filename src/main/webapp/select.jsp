<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Store"%>
<%@ page import="model.Product"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品選択</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<%@include file="header-navi.jsp"%>

	<%
	List<Product> listProd;
	Store store = (Store) session.getAttribute("store");
	if (store == null) {
		listProd = new ArrayList<Product>();
	} else {
		listProd = store.getListProd();
	}
	if (listProd.size() > 0) {
	%>

	<h2>商品選択</h2>

	<table class="select-list">
		<tr>
			<th>イメージ</th>
			<th>商品ID</th>
			<th>商品名</th>
			<th>価格</th>
			<th>数/選択</th>
		</tr>

		<%
		for (int idx = 0; idx < listProd.size(); idx++) {
			Product prod = listProd.get(idx);
		%>
		<tr>

			<td><img src="<%=prod.getImgSource()%>" width="50px"
				height="50px"></td>
			<td><%=prod.getId()%></td>
			<td><%=prod.getName()%></td>
			<td><%=prod.getPriceString()%></td>
			<td>
				<form action="add-prod-servlet" method="POST">
					<input type="hidden" name="idx" value="<%=idx%>"> 
					<input type="number" name ="amount" value="<%=prod.getAmount()%>"
						width="50%" min = "1">
					<input type="submit" value="選択">
				</form>
			</td>
			
		
		</tr>
		<%}%>
	</table>

	<%}%>

</body>
</html>