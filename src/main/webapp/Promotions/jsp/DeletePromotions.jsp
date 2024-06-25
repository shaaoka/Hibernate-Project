
<%@page import="com.team6.model.PromotionsBean"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!@SuppressWarnings("unchecked")%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>所有活動資料</title>
<style>
a, a:visited {
	text-decoration: none;
	color: blue;
}
</style>
</head>

<body style="background-color: #fdf5e6">
	<div align="center">
		<h3>刪除成功!</h3>
		<h2>所有活動資料</h2>
		<table border="1">
			<tr style="background-color: #a8fefa">
				<th>活動編號</th>
				<th>活動名稱</th>
				<th>活動內容</th>
				<th>活動圖片</th>
				<th>活動折扣</th>
				<th>折扣碼</th>
				<th>開始日期</th>
				<th>結束日期</th>
				<%
				List<PromotionsBean> promotionsBeans = (ArrayList<PromotionsBean>) request.getAttribute("PromotionsBeans");
				for (PromotionsBean promotions : promotionsBeans) {
				%>
			
			<tr>
				<td><%=promotions.getPromotions_id()%></td>
				<td><%=promotions.getPromotions_name()%></td>
				<td><%=promotions.getPromotions_content()%></td>
				<td><%=promotions.getPromotions_picture()%></td>
				<td><%=promotions.getPromotions_discount()%></td>
				<td><%=promotions.getPromotions_discountCode()%></td>
				<td><%=promotions.getPromotions_startDate()%></td>
				<td><%=promotions.getPromotions_endDate()%></td>
			</tr>
			<%
			}
			%>
		</table>
		<h3>
			共<%=promotionsBeans.size()%>筆優惠資料
		</h3>
		<p>
			<a href="/team6/Promotions/html/PromotionsIndex.html">回首頁</a>
	</div>
</body>

</html>