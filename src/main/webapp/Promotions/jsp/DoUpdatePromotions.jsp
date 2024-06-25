<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>修改活動資料</title>
<style>
a, a:visited {
	text-decoration: none;
	color: blue;
}

button {
	margin: 0 20px 0 35px;
}
</style>
</head>

<body style="background-color: #fdf5e6">
	<div align="center">

		<h2>修改活動資料</h2>
		<jsp:useBean id="PromotionsBean" scope="request"
			class="com.team6.model.PromotionsBean" />
		<form method="post" action="PromotionsController">
			<table>
				<tr>
					<td>活動編號</td>
					<td><input type="text" name="Promotions_id" readonly
						value="<%=PromotionsBean.getPromotions_id()%>"></td>
				</tr>
				<tr>
					<td>活動名稱</td>
					<td><input type="text" name="Promotions_name"
						value="<%=PromotionsBean.getPromotions_name()%>"></td>
				</tr>
				<tr>
					<td>活動內容</td>
					<td><input type="text" name="Promotions_content"
						value="<%=PromotionsBean.getPromotions_content()%>"></td>
				</tr>
				<tr>
					<td>活動圖片</td>
					<td><input type="text" name="Promotions_picture"
						value="<%=PromotionsBean.getPromotions_picture()%>"></td>
				</tr>
				<tr>
					<td>活動折扣</td>
					<td><input type="text" name="Promotions_discount"
						value="<%=PromotionsBean.getPromotions_discount()%>"></td>
				</tr>
				<tr>
					<td>折扣碼</td>
					<td><input type="text" name="Promotions_discountCode"
						value="<%=PromotionsBean.getPromotions_discountCode()%>"></td>
				
				<tr>
					<td>開始日期</td>
					<td><input type="text" name="Promotions_startDate"
						value="<%=PromotionsBean.getPromotions_startDate()%>"></td>
				<tr>
					<td>結束日期</td>
					<td><input type="text" name="Promotions_endDate"
						value="<%=PromotionsBean.getPromotions_endDate()%>"></td>
				
				
				
				</tr>
			</table>
			<button type="submit" name="fun" value="DoUpdate">更新</button>
			<a href="/team6/Promotions/html/PromotionsIndex.html">回首頁</a>
		</form>
	</div>
</body>

</html>