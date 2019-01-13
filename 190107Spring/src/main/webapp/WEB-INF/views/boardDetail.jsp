<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 보기</title>
<link rel="stylesheet" href="resources/css/posts_style.css">



</head>
<body>
	<div class="row postTitle">${board.boardtitle}</div>
	<div class="row">
		<div class="cell">HITS : ${board.hitcount}</div>
		<div class="cell">작성자 : ${board.id}</div>
		<div class="cell">작성일 : ${board.indate}</div>
	</div>
	<div class="row">${board.boardcontent}</div>
	<div class="row">
		<div class="cell">
			<form class="form" action="updatewrite" method="post">
				<div class="form-group">
					<c:if test="${sessionScope.loginID==board.id}">
						<input type="hidden" name="boardseq" value="${board.boardseq}">
						<input type="hidden" name="boardtitle" value="${board.boardtitle}">
						<input type="hidden" name="boardcontent"
							value="${board.boardcontent}">

						<button type="submit" class="button">수정하기</button>
					</c:if>
				</div>
			</form>
		</div>
		<div class="cell">
			<form class="form" action="deleteboard" method="post">
				<div class="form-group">
					<c:if test="${sessionScope.loginID==board.id}">
						<input type="hidden" name="boardseq" value="${board.boardseq}">
						<button type="submit" class="button">삭제하기</button>
					</c:if>
				</div>
			</form>
		</div>
		<div class="cell">
			<form class="form" action="getboardlist" method="get">
				<div class="form-group">
					<button type="submit" class="button">돌아가기</button>
				</div>
			</form>
		</div>
	</div>




	<!-- 댓글 작성 -->
	<c:if test="${sessionScope.loginID!=null}">
		<div>
			<form action="insertcomment" method="post">
				<input type="hidden" name="boardseq" value="${board.boardseq}">
				댓글쓰기 : <input type="text" name="comments" size="60px">
				<button class="re_button">댓글 작성</button>
			</form>
		</div>
	</c:if>
	<!-- 댓글 및 답글 -->
	<c:if test="${commentList!=null}">

		<div id="i04h0g" class="row re_boxes">
			<div id="i7k1wp" class="cell">
				<c:forEach var="comment" items="${commentList}">
					<!-- 댓글 -->
					<c:if test="${empty comment.targetid}">
						<div id="i6tqnn" class="row re_box">
							<div id="isrfj2" class="cell">${comment.id}</div>
							<div id="ic822o" class="cell">${comment.comments}</div>
							<div id="i8jxz2" class="cell">${comment.indate}</div>
							<div id="i9187x" class="form-group">
								<c:if test="${sessionScope.loginID!=null}">
									<c:if test="${!empty comment.id}">
									<form id="rere_form" action="insertrecomment" method="post">
										<button type="button" id="rere${comment.commentsseq}"
											class="re_button"
											onclick="showDiv_rere('rere${comment.commentsseq}')">답글</button>

										<div id="divrere${comment.commentsseq}" style="display: none;">
											<input type="hidden" name="boardseq"
												value="${board.boardseq}"> <input type="hidden"
												name="parentseq" value="${comment.commentsseq}"> <input
												type="hidden" name="targetid" value="${comment.id}">
											<input type="text" name="comments">
											<button type="submit">작성</button>
										</div>
									</form>
									</c:if>
									<c:if test="${sessionScope.loginID==comment.id}">
										<form id="modify${comment.commentsseq}" action="updatecomment"
											method="post">
											<button type="button" id="remod${comment.commentsseq}"
												class="re_button"
												onclick="showDiv_rere('remod${comment.commentsseq}')">수정</button>

											<div id="divremod${comment.commentsseq}"
												style="display: none;">
												<input type="hidden" name="boardseq"
													value="${board.boardseq}"> <input type="hidden"
													name="commentsseq" value="${comment.commentsseq}">
												<input type="text" name="comments"
													value="${comment.comments}">
												<button type="submit">수정</button>
											</div>

										</form>
										<form id="ihch1p" action="deleteComment" method="post">
											<input type="hidden" name="commentsseq" value="${comment.commentsseq}">
											<input type="hidden" name="boardseq" value="${board.boardseq}">
											<button type="submit" id="io3sdf" class="re_button">삭제</button>
										</form>
									</c:if>
								</c:if>

							</div>
						</div>
					</c:if>
					<!-- 댓글의 답글 -->
					<c:forEach var="recomment" items="${commentList}">
						<c:if test="${recomment.parentseq==comment.commentsseq}">
							<div class="row re_box">
								<div class="cell" id="iebqtu"></div>
								<!--rere아이디 -->
								<div class="cell" id="i95x21">${recomment.id}</div>
								<!--re타겟아이디 -->
								<div class="cell" id="ic4b2s">${recomment.targetid}</div>
								<!-- 댓글 내용 -->
								<div class="cell" id="ias5fj">${recomment.comments}</div>
								<div class="cell" id="ikzqbv">${recomment.indate}</div>
								<div class="form-group">
									<form id="rere_form" action="insertrecomment" method="post">
										<button type="button" id="rere${recomment.commentsseq}"
											class="re_button"
											onclick="showDiv_rere('rere${recomment.commentsseq}')">답글</button>

										<div id="divrere${recomment.commentsseq}"
											style="display: none;">
											<input type="hidden" name="boardseq"
												value="${board.boardseq}"> <input type="hidden"
												name="parentseq" value="${comment.commentsseq}"> <input
												type="hidden" name="targetid" value="${recomment.id}">
											<input type="text" name="comments">
											<button type="submit">작성</button>
										</div>
									</form>
									<c:if test="${sessionScope.loginID==recomment.id}">
									<form id="modify${recomment.commentsseq}" action="updatecomment"
										method="post">
										<button type="button" id="remod${recomment.commentsseq}"
											class="re_button"
											onclick="showDiv_rere('remod${recomment.commentsseq}')">수정</button>

										<div id="divremod${recomment.commentsseq}"
											style="display: none;">
											<input type="hidden" name="boardseq"
												value="${board.boardseq}"> <input type="hidden"
												name="commentsseq" value="${recomment.commentsseq}"> <input
												type="text" name="comments" value="${recomment.comments}">
											<button type="submit">수정</button>
										</div>

									</form>
									<form id="ihch1p" action="deleteReComment" method="post">
											<input type="hidden" name="commentsseq" value="${recomment.commentsseq}">
											<input type="hidden" name="boardseq" value="${board.boardseq}">
									
										<button type="submit" class="re_button">삭제</button>
									</form>
									</c:if>
								</div>
							</div>
						</c:if>
					</c:forEach>

				</c:forEach>
			</div>
		</div>

	</c:if>
</body>
<script type="text/javascript">
	function showDiv_rere(id) {

		var e = document.getElementById('div' + id);
		if (e.style.display == 'block')
			e.style.display = 'none';
		else
			e.style.display = 'block';

	}
</script>
</html>