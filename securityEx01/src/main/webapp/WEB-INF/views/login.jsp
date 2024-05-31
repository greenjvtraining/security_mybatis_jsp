<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
<c:if test="${param.logout != null}">
	<p>You have been logged out successfully.</p>
</c:if>
</div>

<div>
	<form action="loginProc" method="post">
		<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"><br>
		<input type="text" name="username" placeholder="Input id...."><br>
		<input type="password" name="password" placeholder="Input pw...."><br>
		<input type="submit" value="로그인">
	</form>
</div>
</body>
</html>