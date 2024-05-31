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
<sec:authorize access="isAnonymous()">
    <a href="<c:url value='/login' />">Login</a>
</sec:authorize>

<sec:authorize access="isAuthenticated()">
    <form action="<c:url value='/logout' />" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        <button type="submit">Logout</button>
    </form>
</sec:authorize>

<hr>
<h1>Members Page</h1>
<hr>
<sec:authorize access="isAuthenticated()">
    <p>Welcome, authenticated user!</p>
    <p>Logged in as: <sec:authentication property="name" /></p>
    <p>Logged user Role: <sec:authentication property="principal.role" /></p>
    <p>Logged user Nickname: <sec:authentication property="principal.nickname" /></p>
</sec:authorize>
<p>세션 : ${sessionScope.username }</p>
<sec:authorize access="isAnonymous()">
    <p>Welcome, anonymous user!</p>
</sec:authorize>

<sec:authorize access="hasRole('ROLE_ADMIN')">
    <p>Welcome, admin user!</p>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_USER')">
    <p>Welcome, standard user!</p>
</sec:authorize>


</body>
</html>