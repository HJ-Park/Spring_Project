<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>upload board</title>
<link rel="stylesheet" href="resources/css/SimpleBoard/xe.min.css">
<link rel="stylesheet" href="resources/css/SimpleBoard/button_flat.css">
<link rel="stylesheet" href="resources/css/SimpleBoard/xeicon.min.css">
<link rel="stylesheet" href="resources/css/SimpleBoard/board.css">
<link rel="stylesheet" href="resources/css/SimpleBoard/_style_list.css">
<link rel="stylesheet"
	href="resources/css/SimpleBoard/view_document.css">
<link rel="stylesheet" href="resources/css/SimpleBoard/write_form.css">
<link rel="stylesheet" href="resources/css/SimpleBoard/css3.css">
<link rel="stylesheet" href="resources/css/SimpleBoard/css3-shadow.css">
<link rel="stylesheet"
	href="resources/css/SimpleBoard/selectric-dark.css">
<link rel="stylesheet" href="resources/css/SimpleBoard/layout.css">
<link rel="stylesheet" href="resources/css/SimpleBoard/responsive.css">
<link rel="stylesheet" href="resources/css/SimpleBoard/style.css">
</head>
<body>

	<c:if test="${sessionScope.loginID==null}">
		<h1>${warnning}</h1>
	</c:if>
	<c:if test="${sessionScope.loginID!=null}">
		<h1>${sessionScope.loginID}님환영합니다.</h1>
	</c:if>




	<!-- 보드시작 -->
	<div class="xet_body_content w" id="iawul7">
		<div class="xet_container">
			<div class="b_title" id="iepwqh">
				<h2 id="izi673">업로드 게시판</h2>
			</div>
			<div class="xet_content" id="iuruzi">
				<div id="xet_board">
					<div class="board-header"></div>
					<div
						class="boardNavigation xet_clearfix mg-b15 visible-xs hidden-sm">
						<div class="float_right"></div>
					</div>
					<div id="id45a9" class="boardListForm">
						<table cellspacing="0" border="0" cellpadding="0"
							summary="List of Articles" class="boardList">
							<thead class="hidden-xs">
								<tr>
									<th scope="col">번호</th>
									<th scope="col">제목</th>
									<th scope="col">작성자</th>
									<th scope="col"><a
										href="https://xetemplate.cafe24.com/index.php?mid=simple_board_list&sort_index=regdate&order_type=desc">날짜</a></th>
									<th scope="col" class="hidden-xs"><a
										href="https://xetemplate.cafe24.com/index.php?mid=simple_board_list&sort_index=readed_count&order_type=desc">조회
											수</a></th>
								</tr>
							</thead>
							<!-- boardList null체크 -->
							<c:if test="${boardList!=null}">
								<tbody>
									<c:forEach var="b" items="${boardList}">
										<tr class="bg1">
											<td class="num"><span>${b.boardseq}</span></td>
											<td class="title"><a
												href="/sixth/boardview?boardseq=${b.boardseq}"
												class="subject">${b.boardtitle}</a><span
												class="visible-xs hidden-sm"><i title="날짜"
													class="xi-time"> </i> ${b.indate} <i title="작성자"
													class="xi-user"> </i> ${b.id} </span></td>
											<td class="author hidden-xs">${b.id}</td>
											<td class="date hidden-xs">${b.indate}</td>
											<td class="reading hidden-xs">${b.hitcount}</td>
										</tr>
									</c:forEach>
								</tbody>
							</c:if>
						</table>
					</div>
					
					<div>
					
					
					
					<ul class="pagination">
						<li><a href="goPage?page=${navi.currentPage-navi.pagePerGroup}"
							title="이전페이지그룹" class="prevEnd">&lt;&lt;</a></li>
						<li><a href="goPage?page=${navi.currentPage-1}"
							title="이전페이지" class="prevEnd">&lt;</a></li>
						<c:forEach var="page" begin="${navi.startPageGroup}" end="${navi.endPageGroup}">
						<li>
						<c:if test="${page==nowpage}">
							<strong class="page_on">
						</c:if>
						<a href="goPage?page=${page}">${page}</a>
						<c:if test="${page==nowpage}">
							</strong>
						</c:if>
						</li>
						</c:forEach>
						<li><a
							href="goPage?page=${navi.currentPage+1}"
							title="다음페이지" class="nextEnd">&gt;</a></li>
						<li><a href="goPage?page=${navi.currentPage+navi.pagePerGroup}"
							title="다음페이지그룹" class="nextEnd">&gt;&gt;</a></li>
					</ul>
					<div class="boardNavigation">
						<div class="float_left boardSearch">
							<form action="pageNum" method="get"
								onsubmit="return procFilter(this, search)" id="fo_search"
								class="boardSearchForm">
								<!-- <input type="hidden" name="category" value="" /> -->
								<div class="boardSearch">
									<span class="l-r3"><select name="search_target">
											<option	value="title_content">제목+내용</option>
											<option value="title">제목</option>
											<option value="content">내용</option>
											<option value="comment">댓글</option>
											<option value="nick_name">닉네임</option>
											<option value="tag">태그</option></select></span>
											
											
											<input type="text" name="search_keyword" value="" title="검색" accesskey="S"
										placeholder="검색" class="inputText" />
										<span class="search_btn_wrp r-r3">
										<button type="submit" class="search_btn light">
											<span class="hidden-xs">검색</span>
										</button></span>
								</div>
							</form>

						</div>
						<div class="boardNavigation">
							<div class="float_right">
								<a href="boardNewWrite" class="xet_btn medium light"> <span><i
										class="xi-list-ul-l"></i> 글쓰기</span>
								</a>
							</div>
						</div>
						<div class="float_right"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>

	<footer id="xet_footer">
		<div class="xet_container footer_content" id="i164v7a">
			<div id="izwz0x" class="xet_copyright">Since 2010 | Providing
				Templates for XpressEngine. ©2017 xetemplate.com All Rights
				Reserved.</div>
		</div>
	</footer>



</body>
</html>