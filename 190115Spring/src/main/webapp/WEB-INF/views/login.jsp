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
	<form action="login_on" method="post">
		<table>
		<tr>
			<td>ID</td><td><input type="text" name="id"></td>
			</tr>
			<tr>
			<td>PW</td><td><input type="password" name="pw"></td>
			</tr>		
		</table>
		<button>로그인</button>
	</form>
	<a href="./signup"><button>회원가입</button></a>
</body>
</html>