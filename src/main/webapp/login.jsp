<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

	<h2>キャル食料ショップ</h2>

	<img src="img/home.jpg" width="450px">

	<div class="login-page">
		<div class="form">
			<form action="login-servlet" method="post" class="register-form">
				ユーザID：<input type="text" name="userId" placeholder="ID" required>
				パスワード：<input type="password" name="password" placeholder="PW"
					required> <input type="submit" value="ログイン">
			</form>
		</div>
	</div>


	<%
	String errorMsg = (String) request.getAttribute("errorMsg");
	if (errorMsg != null) {
	%>
	<p class="error-msg"><%=errorMsg%></p>
	<%
	}
	%>

</body>
</html>
