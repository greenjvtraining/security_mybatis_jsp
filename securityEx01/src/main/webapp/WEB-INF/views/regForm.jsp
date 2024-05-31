<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Reg Form</h1>
<hr>
<div>
	<form action="regProc" method="post">
		<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"><br>
		<input type="text" name="username" placeholder="Input id...." ><br>
		<input type="password" name="password" placeholder="Input pw...." ><br>
		<input type="text" name="nickname" placeholder="Input nickname...."><br>
		<input type="submit" value="회원등록">
	</form>
</div>
</body>
</html>