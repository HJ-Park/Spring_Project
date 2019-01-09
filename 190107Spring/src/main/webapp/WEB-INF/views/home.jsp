<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<c:if test="${sessionScope.loginID!=null}">
	<h2>${sessionScope.loginID}님 환영합니다</h2>
</c:if>


<c:if test="${sessionScope.loginID==null}">
<form action="signup" method="get">
<button>회원가입</button>
</form>

<form action="login" method="get">
<button>로그인</button>
</form>
</c:if>

<c:if test="${sessionScope.loginID!=null}">
<form action="logout" method="get">
<button>로그아웃</button>
</form>
</c:if>
</body>
</html>
