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
	<c:if test="${boardList!=null}">

		<section class="flex-sect">
			<div class="container-width">
				<div class="flex-title">게시판</div>
				<div class="cards">
					<c:forEach var="boardelement" items="${boardList}">
						<div class="card">
							<div class="card-header">No : ${boardelement.boardseq}</div>
							<div class="card-body">
								<div class="card-title">${boardelement.boardtitle}</div>
								<div class="card-desc">ID : ${boardelement.id}</div>
								<div class="card-desc">HIT : ${boardelement.hitcount}</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</section>
	</c:if>

</body>
</html>