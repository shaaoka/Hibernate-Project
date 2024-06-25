<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
<style>
    body{
		margin: 0;
		padding: 0;
		background-color:  #CCCCFF;
	}
	.div1 {
        left: 0;
		display: flex;
		justify-content: center;
		align-items: center;
		width: 20%;
		height: 100%;
		padding: 30px;
		margin: 30px;
		background-color: #FFFFFF;
		border-radius: 3%;
	}
	.div2 {
		text-align: center;
		align-items: center;
		background-color: 	#99CCFF;
		width: 300px;
		height: 100%;
		padding: 30px;
		font-size: 20px;
		color: #336699;
		border-radius: 3%;
	}
	.div2 button{
		font-size: 20px;
		background-color: #FFFFFF;
		border: 1px solid #336699 ;
		color: #336699 ;
		margin: auto;
        padding: 10px;
        border-radius: 25%;
		font-family: 標楷體;
	}
    .div2 hr{
        border: 2px solid #FFFFFF;
    }
	.div2 label{
		font-size: 18px;
		color: #FFFFFF;
		font-family: 標楷體;
	}
</style>
</head>
<body>
<div class="div1">
<div class="div2" >
<h2> Dönerbox  Pizza </h2>
<label>後 臺 管 理</label>
<hr>
<div>${boss}</div>
<br>
<form method="post" action="/team6/MemberController">
<button> 會員功能 </button><p>
</form>
<form method="post" action="${pageContext.request.contextPath}/product/jsp/Product_Index.jsp">
<button name="type" value="" > 產品功能 </button><p>
</form>
<form method="post" action="/team6/order/html/OrderIndex.html">
<button name="type" value="" > 訂單功能 </button><p>
</form>
<form method="post" action="/team6/reservation/html/ReserveHomePage.html">
<button name="type" value="" > 訂位功能 </button><p>
</form>
<form method="post" action="/team6/delivery/html/index.html">
<button name="type" value="" > 外送功能 </button><p>
</form>
<form method="post" action="/team6/Promotions/html/PromotionsIndex.html">
<button name="type" value="" > 活動功能 </button><p>
</form>
<br>
</div>
</div>
</body>
</html>