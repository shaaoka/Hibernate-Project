<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>修改產品資料</title>
<style>
a, a:visited {
	text-decoration: none;
	color: blue;
}

button {
	margin: 0 20px 0 35px;
}
div.a{
	text-align: center;
}
img{
	width: 12vw;
	height: 12vw;
}
</style>
</head>

<body style="background-color: #fdf5e6">
	<div align="center">

		<h2>修改產品資料</h2>
		<jsp:useBean id="productBean" scope="request"
			class="com.team6.model.ProductBean" />
		<form method="post" action="${pageContext.request.contextPath}/Product_DoUpdate" enctype="multipart/form-data">
			<table>
				<tr>
					<td>商品編號</td>
					<td><input type="text" name="productId" readonly
						value="<%=productBean.getProductId()%>"></td>
				</tr>
				<tr>
					<td>類別編號</td>
					<td><input type="text" name="categoryId"
						value="<%=productBean.getCategoryId()%>"></td>
				</tr>
				<tr>
					<td>商品名稱</td>
					<td><input type="text" name="productName"
						value="<%=productBean.getProductName()%>"></td>
				</tr>
				<tr>
					<td>商品介紹</td>
					<td><input type="text" name="productDesc"
						value="<%=productBean.getProductDesc()%>"></td>
				</tr>
				<tr>
					<td>商品圖片</td>
					<td>
						<input type="file" id="fileInput" name="productImg_url" onchange="previewFile()">
						<p>
						<img src="<%=productBean.getProductImg_url()%>" id="previewImage" alt="圖片預覽">
					</td>
							
				</tr>
				<tr>
					<td>商品價格</td>
					<td><input type="text" name="productPrice"
						value="<%=productBean.getProductPrice()%>"></td>
				</tr>
				<tr>
					<td>狀態編號</td>
					<td><input type="text" name="productStateId"
						value="<%=productBean.getProductStateId()%>"></td>
				</tr>
			</table>
			<div class="a">
				<button type="submit">更新</button>
			</div>
		</form>
				<a href="${pageContext.request.contextPath}/product/jsp/Product_Index.jsp">回首頁</a>
	</div>
	
	<script>
		function previewFile() {
        	const fileInput = document.getElementById('fileInput');
        	const previewImage = document.getElementById('previewImage');
        	const file = fileInput.files[0];

        	if (file) {
            	const reader = new FileReader();
            	reader.onload = function (event) {
            		event.target.value = ' ';
            		previewImage.src = event.target.result;
            	};
            	reader.readAsDataURL(file);
            	event.target.value = ' ';
            }
    	}
    </script>
	
</body>

</html>