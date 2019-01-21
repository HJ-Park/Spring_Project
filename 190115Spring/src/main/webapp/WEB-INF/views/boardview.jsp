<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
<title>upload board!! ${board.boardtitle}</title>
</head>
<body>
	<div class="xet_body_content w">
		<div class="xet_container">
			<div class="b_title">
				<h2>심플보드 - 업로드게시판</h2>
			</div>
			<div class="xet_content">
				<!-- // 게시판 시작 // -->
				<div id="xet_board" class="">

					<!-- // header // -->
					<div class="board-header">

						<!-- // 상단 내용 // -->


					</div>
					<div class="viewDocument">
						<div class="boardRead">
							<div class="boardReadHeader">
								<div class="titleArea">
									<a href="/sixth/boardview/${board.boardseq}" class="title">${board.boardtitle}</a>
								</div>
								<div class="title_info">
									<div class="float_left">
										<span> <i class="xi-user" title="작성자"></i> ${board.id}
										</span> <span><i class="xi-time" title="등록일"></i> <strong>${board.indate}
										</strong></span>
									</div>
									<div class="float_right count_wrp">
										<span><i class="xi-comments" title="댓글"></i> <strong><a
												href="https://xetemplate.cafe24.com/simple_board_list/1860#comment"
												title="댓글"> 0</a></strong></span> <span><i class="xi-eye"
											title="조회 수"></i> <strong>${board.hitcount}</strong></span>
									</div>
								</div>
							</div>
							<!-- // 확장 변수 출력 // -->
							<!-- // 본문 출력 // -->
							<div class="boardReadBody">
								<!-- // 이 게시물을... 출력 설정 // -->
								<!--BeforeDocument(sample)-->
								<div class="xe_content">
									${board.boardcontent}
									
									<p>
										<img
											src="./quadrocopter - 심플보드 - 목록형 - XE 템플릿 프리뷰 사이트_files/3c7dbb389be91d4495382e00acfcc0ac.png"
											alt="quadrocopter-1658967_1280.png" style="cursor: pointer;"
											rel="xe_gallery">
									</p>
									
								</div>
								<!--AfterDocument(sample)-->



							</div>
							<div class="boardReadFooter">
								<!-- // 첨부파일 등록 //-->
								<c:forEach var="file" items="${fileList}">
									<a href="/sixth/download?boardseq=${board.boardseq}&fileseq=${file.fileseq}">${file.orgname}</a>
			
								</c:forEach>
								
								<!-- // 첨부 파일 출력 // -->
								<!-- // 태그 리스트 출력 // -->
								<!-- // 트랙백주소 출력 // -->
							</div>
							<div class="boardNavigation">
								<div class="float_left">
									<a href="board_list" class="xet_btn medium light"> <span><i
											class="xi-list-ul-l"></i> 목록</span>
									</a>
								</div>
								<c:if test="${sessionScope.loginID == board.id}">
									<div class="float_left">
										<a href="/sixth/boardmodify?boardseq=${board.boardseq}"
											class="xet_btn medium light"> <span><i
												class="xi-list-ul-l"></i> 수정</span>
										</a>
									</div>
									<div class="float_left">
										<a href="https://xetemplate.cafe24.com/simple_board_list"
											class="xet_btn medium light"> <span><i
												class="xi-list-ul-l"></i> 삭제</span>
										</a>
									</div>
								</c:if>
							</div>
						</div>
					</div>
					<!-- // 하단 내용 // -->
				</div>
				<!-- board End -->
				<!-- // 게시판 끝 // -->
			</div>
		</div>
	</div>
</body>
</html>