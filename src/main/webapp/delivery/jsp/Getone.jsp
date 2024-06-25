<%@page import="com.team6.model.Delivery"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>單筆訂單資料</title>
<style>
body {
	text-align: center;
	;
}
</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
</head>
<body style="background-color : #fdf5e6">
	<div align="center">
		<h2>外送訂單</h2>
		<jsp:useBean id="deliveryBean" scope="request"
			class="com.team6.model.Delivery" />
		<table>
			<tr>
				<td>外送編號</td>
				<td><input type="text" disabled
					value="<%=deliveryBean.getId()%>"></td>
			</tr>
			<tr>
				<td>顧客姓名</td>
				<td><input type="text" disabled
					value="<%=deliveryBean.getCname()%>"></td>
			</tr>
			<tr>
				<td>電話</td>
				<td><input type="text" disabled
					value="<%=deliveryBean.getPhone()%>"></td>
			</tr>
			<tr>
				<td>產品</td>
				<td><input type="text" disabled
					value="<%=deliveryBean.getProduct()%>"></td>
			</tr>
			<tr>
				<td>數量</td>
				<td><input type="text" disabled
					value="<%=deliveryBean.getNum()%>"></td>
			</tr>
			<tr>
				<td>價格</td>
				<td><input type="text" disabled
					value="<%=deliveryBean.getPrice()%>"></td>
			</tr>
			<tr>
				<td>外送員工</td>
				<td><input type="text" disabled
					value="<%=deliveryBean.getEname()%>"></td>
			</tr>
			
			<tr>
				<td>外送地址</td>
				<td><input type="text" disabled
					value="<%=deliveryBean.getAddress()%>"></td>
			</tr>
			<tr>
				<td>外送時間</td>
				<td><input type="text" disabled
					value="<%=deliveryBean.getTime()%>分鐘"></td>
			</tr>
		</table>
		<br>
		<button id="home">回首頁</button>
		</div>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script>
$(document).ready(function(){
    
	$("#home").click(function(){
    	let homeURL = "/team6/delivery/html/index.html";
    	window.location.href = homeURL;
    
	});
});
</script>
</body>
</html>