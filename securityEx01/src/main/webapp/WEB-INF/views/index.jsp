<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
<sec:authorize access="isAnonymous()">
    <a href="<c:url value='/login' />">Login</a>
</sec:authorize>

<sec:authorize access="isAuthenticated()">
    <sec:authentication property="name" />&nbsp;&nbsp;
    <form action="<c:url value='/logout' />" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <button type="submit">Logout</button>
    </form>
</sec:authorize>
<hr>
<h1>Index</h1>
<hr>
<a href="/regForm">회원등록</a>
</body>
</html>