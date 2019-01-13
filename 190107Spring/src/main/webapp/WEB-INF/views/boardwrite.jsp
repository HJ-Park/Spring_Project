<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardwrite</title>
</head>
<body>
	<c:if test="${board==null}">
		<form action="boardwrite_on" method="post">
	</c:if>
	<c:if test="${board!=null}">
		<form action="updatewrite_on" method="post">
		<input type="hidden" name="boardseq" value="${board.boardseq}">
	</c:if>
	제목:
	<input name="boardtitle" type="text">
	<font color="red">${warnning}</font>
	<br> 
	내용:
	<textarea cols="50" rows="20" name="boardcontent"></textarea>
	<br>
	<button>submit!</button>
	</form>
</body>
</html>