<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardwrite</title>
</head>
<body>
<form action="boardwrite_on" method="post">
	제목:<input name="boardtitle" type="text"><font color="red">${warnning}</font><br>
	내용:<textarea name="boardcontent"></textarea><br>
	<button>submit!</button>
</form>
</body>
</html>