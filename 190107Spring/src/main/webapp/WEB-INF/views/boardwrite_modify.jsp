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
<form action="boardwrite_modify_on" method="post">
	<input type="hidden" name="boardseq" value="${board.boardseq}">
	제목:<textarea cols="50" rows="1" name="boardtitle">${board.boardtitle}</textarea><br>
	내용:<textarea cols="50" rows="30" name="boardcontent">${board.boardcontent}</textarea><br>
	<button>submit!</button>
</form>
</body>
</html>