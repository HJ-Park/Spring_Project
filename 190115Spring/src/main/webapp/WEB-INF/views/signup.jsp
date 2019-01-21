<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login page</title>
</head>
<body>
	<h1>${warnning}</h1>
	<form action="signup_on" method="post">
		<table>
			<tr>
			<td>ID</td><td><input type="text" name="id"></td>
			</tr>
			<tr>
			<td>PW</td><td><input type="password" name="pw"></td>
			</tr>
			<tr>
			<td>이름</td><td><input type="text" name="name"></td>
			</tr>
			<tr>
			<td>휴대번호</td><td><input type="text" name="phone"></td>
			</tr>
			<tr>
			<td>이메일</td><td><input type="text" name="email"></td>
			</tr>
			<tr>
			<td>생일</td><td><input type="text" name="birthdate"></td>
			</tr>
		</table>
		
		<button>회원가입</button>
	</form>
</body>
</html>