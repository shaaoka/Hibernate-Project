<%@page import="com.team6.model.Delivery"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!@SuppressWarnings("unchecked")%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>所有外送訂單資料</title>
<link rel="stylesheet" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<style>
body {
	text-align: center;
	background-color : #fdf5e6;
}

.form {
	display: inline-block
}

button {
	margin:5px
}
a {
	text-decoration: none;
	
}
</style>
</head>
<body>
<div align="center">
	<h2>所有外送訂單資料</h2>
		
	<form method="post" action="/team6/DeliveryServlet">
		<label for="search">顧客姓名:</label>
		<input type="text" id="search" name="cname">
		<button name="message" value="GetName" type="submit" class="btn btn-secondary">查詢</button>
	</form>
	<br>
	<table  id="table_id" class="display" style="width:100%">
	<thead>
		<tr style="background-color:#8E8E8E">
			<th>訂單編號</th>
			<th>顧客姓名</th>
			<th>電話</th>
			<th>產品</th>
			<th>數量</th>
			<th>價格</th>
			<th>外送員工</th>
			<th>外送地址</th>
			<th>外送時間</th>
			<th>動作</th>
			
		</tr>
	</thead>
	<tbody>
		<%
		List<Delivery> deliveryBeans = (ArrayList<Delivery>) request.getAttribute("deliveryBeans");
				for (Delivery delivery: deliveryBeans) {
		%>
		<tr>
			<td><%=delivery.getId()%></td>
			<td><a href="/team6/DeliveryServlet?message=upd&id=<%=delivery.getId()%>"><%=delivery.getCname()%></a></td>
			<td><%=delivery.getPhone()%></td>
			<td><%=delivery.getProduct()%></td>
			<td><%=delivery.getNum()%></td>
			<td><%=delivery.getPrice()%></td>
			<td><%=delivery.getEname()%></td>
			<td><%=delivery.getAddress()%></td>
			<td><%=delivery.getTime()%>分鐘</td>
			<td><button id="del" onclick="confirmDelete('<%=delivery.getId()%>')">刪除</button></td>
		</tr>
	<%}%>
	</tbody>
	</table>
</div>
	<br>
	<button id="home" class="btn btn-secondary">回首頁</button>
		
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
<script>
	function confirmDelete(deliveryId) {
        var confirmDelete = confirm("您確定要刪除此項目嗎？");
        if (confirmDelete) {
            // 如果用户点击了确定，则将其重定向到删除链接
            window.location.href = "/team6/DeliveryServlet?message=del&id=" + deliveryId;
        } else {
            // 如果用户点击了取消，则不执行任何操作
            return false;
        }
    }
	
	function previewFile() {
		const fileInput = document.getElementById('fileInput');
		const previewImage = document.getElementById('previewImage');
		const file = fileInput.files[0];

		if (file) {
			const reader = new FileReader();
			reader.onload = event => {
				previewImage.src = event.target.result;
			};
			reader.readAsDataURL(file);
		}
	}
$(document).ready(function(){
	$('#home').click(function(){
    	let homeURL = "/team6/delivery/html/index.html";
    	window.location.href = homeURL;
    	console.log("error")
	});
	
	
	
	 $('#table_id').DataTable({
		 "searching": false,
		 "ordering": false,
	        columns: [
	            null, // Order ID
	            null, // Customer Name
	            null, // Phone
	            null, // Product
	            null, // Quantity - You might want to specify the actual data source for quantity
	            null, // Price
	            null, // Delivery Staff
	            null, // Delivery Address
	            null,//
	            null,// Delivery Time
	            null
	        ],
	    })

	 
});

</script>
</body>
</html>