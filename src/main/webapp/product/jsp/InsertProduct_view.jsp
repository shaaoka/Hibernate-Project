<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增商品</title>
</head>
<body>
<body style="background-color: #fdf5e6">
	<div align="center">


		<h2>新增成功</h2>
		<jsp:useBean id="productBean" scope="request"
			class="com.team6.model.ProductBean" />
		<table>
			<tr>
				<td>商品編號</td>
				<td><input type="text" disabled value="<%=productBean.getProductId()%>"></td>
			</tr>
			<tr>
				<td>類別編號</td>
				<td><input type="text" disabled value="<%=productBean.getCategoryId()%>"></td>
			</tr>
			<tr>
				<td>商品名稱</td>
				<td><input type="text" disabled value="<%=productBean.getProductName()%>"></td>
			</tr>
			<tr>
				<td>商品介紹</td>
				<td><input type="text" disabled value="<%=productBean.getProductDesc()%>"></td>
			</tr>
			<tr>
				<td>圖片路徑</td>
				<td><input type="text" disabled value="<%=productBean.getProductImg_url()%>"> 
				
				</td>
			</tr>
			<tr>
				<td>商品價格</td>
				<td><input type="text" disabled value="<%=productBean.getProductPrice()%>"></td>
			</tr>
			<tr>
				<td>商品狀態</td>
				<td><input type="text" disabled value="<%=productBean.getProductStateId()%>"></td>
			</tr>

		</table>
		<p>
		<a href="${pageContext.request.contextPath}/product/jsp/Product_Index.jsp">回首頁</a>
	</div>
</body>
</html>