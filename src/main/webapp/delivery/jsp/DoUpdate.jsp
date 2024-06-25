<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>修改員工資料</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<style>
body {
	text-align: center;
	background-color: #fdf5e6;
}

.form {
	display: inline-block
}

button {
	margin: 5px
}
</style>
</head>
<body>
	<div align="center">

		<h2>修改訂單資料</h2>
		<jsp:useBean id="deliveryBean" scope="request"
			class="com.team6.model.Delivery" />
		<form method="post" action="/team6/DeliveryServlet">
			<table>
				<tr>
					<td>訂單編號</td>
					<td><input type="text" name="id"
						value="<%=deliveryBean.getId()%>" readonly="readonly"></td>
				</tr>
				<tr>
					<td>顧客姓名</td>
					<td><input type="text" name="cname"
						value="<%=deliveryBean.getCname()%>"></td>
				</tr>
				<tr>
					<td>電話</td>
					<td><input type="text" name="phone"
						value="<%=deliveryBean.getPhone()%>" pattern="[0]{1}[2-9]{1}[0-9]{8}" required></td>
				</tr>
				<tr>
					<td>產品</td>
					<td><select name="product" id="product">
							<option value="<%=deliveryBean.getProduct()%>"><%=deliveryBean.getProduct()%></option>
							<option value="夏威夷德國披薩">夏威夷德國披薩</option>
							<option value="海鮮德國披薩">海鮮德國披薩</option>
							<option value="牛肉k吧德國披薩">牛肉k吧德國披薩</option>
							<option value="義大利雞肉焗烤麵">義大利雞肉焗烤麵</option>
							<option value="牛肉k吧焗烤薯條">牛肉k吧焗烤薯條</option>
							<option value="炸物拼盤">炸物拼盤</option>
							<option value="蘋果肉桂德國烤餅">蘋果肉桂德國烤餅</option>
							<option value="原味布丁">原味布丁</option>
							<option value="可口可樂">可口可樂</option>
					</select></td>
				</tr>
				<tr>
					<td>數量</td>
					<td><input type="text" name="num"
						value="<%=deliveryBean.getNum()%>"></td>
					
				</tr>
				
				<tr>
					<td>商品單價</td>
					<td><input type="text" name="price" id="price"
						value="<%=deliveryBean.getPrice()%>"></td>
				</tr>
				<tr>
					<td>外送員</td>
					<td><select name="ename">
							<option value="<%=deliveryBean.getEname()%>"><%=deliveryBean.getEname()%></option>
							<option value="Henry">Henry</option>
							<option value="Allen">Allen</option>
							<option value="David">David</option>
							<option value="John">John</option>
					</select></td>
				</tr>
				<tr>
					<td>地址</td>
					<td><select name="address">
							<option value="<%=deliveryBean.getAddress()%>"><%=deliveryBean.getAddress()%></option>
							<option value="中原大學">中原大學</option>
							<option value="健行科技大學">健行科技大學</option>
							<option value="中壢運動園區">中壢運動園區</option>
							<option value="中壢火車站">中壢火車站</option>
							<option value="內壢火車站">內壢火車站</option>
							<option value="家樂福中壢店">家樂福 中壢店</option>
							<option value="家樂福內壢店">家樂福 內壢店</option>
							<option value="桃園市立龍興國民中學">桃園市立龍興國民中學</option>
							<option value="莒光環保公園">莒光環保公園</option>
							<option value="天晟醫院">天晟醫院</option>
					</select>
				</tr>
			<tr>
				<td>外送時間</td>
				<td><input type="text" name="time"
						value="<%=deliveryBean.getTime()%>">分鐘</td>
			</tr>
			</table>
			<button type="submit" name="message" value="Update">更新</button>
		</form>
		<button id="home">回首頁</button>
	</div>
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script> 
$(document).ready(function(){
		
	$("#home").click(function(){
	    let homeURL = "/team6/delivery/html/index.html";
	    window.location.href = homeURL;
	});
	
	// 產品選擇框的 change 事件處理程序
	$("#product").change(function() {
		let Product = $(this).val();
		let newPrice = getNewPrice(Product);
		
		$("#price").val(newPrice);
	    updatePrice(); 
	// 取得選擇的產品值
		$("#price").val(newPrice);
		});
		$("#product").trigger("change");
		});

		function getNewPrice(product) {
			switch (product) {
			case "夏威夷德國披薩":
				return "279";
			case "海鮮德國披薩":
				return "289";
			case "牛肉k吧德國披薩":
				return "259";
			case "義大利雞肉焗烤麵":
				return "160";
			case "炸物拼盤":
				return "189";
			case "蘋果肉桂德國烤餅":
				return "160";
			case "原味布丁":
				return "50";
			case "可口可樂":
				return "39";
			case "牛肉k吧焗烤薯條":
				return "170";
			default:
				return "0";
			}
		}		
</script>
</body>

</html>