<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Member</title>
<style>
body {
	margin: 0;
	padding: 0;
	display: flex;
	justify-content: center;
	align-items: center;
	background-color: #CCCCFF;
}

.div1 {
	display: flex;
	justify-content: center;
	align-items: center;
	width: 35%;
	height: 100%;
	padding: 30px;
	margin: 30px;
	background-color: #FFFFFF;
	border-radius: 10%;
}

.div2 {
	text-align: center;
	align-items: center;
	background-color: #99CCFF;
	width: 450px;
	height: 100%;
	padding: 30px;
	font-size: 20px;
	color: #336699;
	font-weight: 700;
	border-radius: 10%;
}

.div2 button {
	font-size: 20px;
	background-color: #FFFFFF;
	border: 1px solid #336699;
	color: #336699;
	border-radius: 25%;
	padding: 5px;
}

.div2 fieldset {
	border: none;
}

.div2 input {
	border: 1px solid #336699;
	color: #336699;
}

.textRed {
	color: red;
}
</style>
</head>
<body>
	<div class="div1">

		<div class="div2">
			<h2>新 增 會 員 資 料</h2>
			<div class="textRed">${err}</div>
			<form method="post" action="/team6/MemberController">
				<fieldset>
					<div>
						<p>
							會員帳號： <input type="text" name="account" maxlength="20" required>
						</p>
					</div>
					<div>
						<p>
							會員名稱： <input type="text" name="mName" maxlength="20" required>
						</p>
					</div>
					<div>
						<p>
							會員密碼： <input type="password" name="password" maxlength="18"
								required id="myInput"><br><br><input
						type="checkbox" onclick="myFunction()">Show Password
								
						</p>
					</div>
					<div>
						<p>
							電子信箱： <input type="email" name="mEmail" value="@gmail.com"
								required>
						</p>
					</div>
					<div>
						<p>
							電話號碼： <input type="text" name="mPhone" value="09"
								pattern="[0]{1}[9]{1}\d{8}" maxlength="10" required>
						</p>
					</div>
					<div>
						<p>
							會員生日： <input type="date" name="birthday" value="1990-01-01">
						</p>
					</div>
				</fieldset>
				<p>
					<button name="type" value="insert">確定新增</button>
			</form>
			<a href="/team6/MemberController"><button>取消</button></a>

		</div>
	</div>
	<script>
		function myFunction() {
			var x = document.getElementById("myInput");
			if (x.type === "password") {
				x.type = "text";
			} else {
				x.type = "password";
			}
		}
	</script>
</body>
</html>