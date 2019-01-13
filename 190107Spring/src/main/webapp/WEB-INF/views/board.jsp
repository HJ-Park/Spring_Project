<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board</title>
<link rel="stylesheet" href="resources/css/boardstyle.css">
</head>
<body>

	<form action="boardwrite" method="get">
		<button>write!</button>
	</form>
	
	

		<section class="flex-sect">
			<div class="container-width">
				<div class="flex-title">게시판</div>
				<c:if test="${boardList!=null}">
				<div class="cards">
					<c:forEach var="boardelement" items="${boardList}">
						<div class="card">
							<div class="card-header">No : ${boardelement.boardseq}</div>
							<div class="card-body">
								<div class="card-title"><font color="blue"><a href="boardDetail?boardseq=${boardelement.boardseq}">${boardelement.boardtitle}</a></font></div>
								<div class="card-id"><font color ="skyblue">ID : ${boardelement.id}</font></div>
								<div class="card-hit"><font color ="red">HIT : ${boardelement.hitcount}</font></div>
								<div class="card-content">Borad Content <br>
														<font color ="gray">${boardelement.boardcontent}</font></div>
								<div class="card-indate">date : ${boardelement.indate}</div>						
							</div>
						</div>
					</c:forEach>
				</div>
				</c:if>
			</div>
		</section>
	

</body>
</html>