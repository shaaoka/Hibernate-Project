<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta http-equiv="refresh" content="3 ;url=/team6/delivery/html/index.html">
<title>新增失敗</title>
<style>
body {
	text-align: center;
	background-color : #fdf5e6;
}
</style>
</head>

<body style="background-color: #fdf5e6">
	<div align="center">
		<h2>新增失敗</h2>
		<p>
		<button id="home" class="btn btn-secondary">回首頁</button>
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