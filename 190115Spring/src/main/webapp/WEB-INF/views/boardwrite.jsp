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
					<c:if test="${board==null}">
						<form action="boardwrite_upload" method="post" enctype="multipart/form-data">
					</c:if>
					<c:if test="${board!=null}">
						<form action="boardupdate_on" method="post">
							<input type="hidden" name="boardseq" value="${board.boardseq}">
					</c:if>
					<div class="viewDocument">
						<div class="boardRead">
							<div class="boardReadHeader">
								<div class="titleArea">
									<input type="text" name="boardtitle"
										value="${board.boardtitle}${boardtitle}">

								</div>
								<div class="title_info">
									<div class="float_left">
										<span> <i class="xi-user" title="작성자"></i>
											${sessionScope.id} </strong></span>
									</div>
								</div>
							</div>
							<!-- // 확장 변수 출력 // -->
							<!-- // 본문 출력 // -->
							<div class="boardReadBody">
								<!-- // 이 게시물을... 출력 설정 // -->
								<!--BeforeDocument(sample)-->


								<!-- 파일 전송을 위한 폼 속성 추가 -->
								<table>
									
									<tr>
										<td><input type="file" name="uploadFile" multiple="multiple"/></td>
									</tr>
									
									
								</table>


								<div class="xe_content">
									<textarea cols="100" rows="15" name="boardcontent">${board.boardcontent}${boardcontent}</textarea>

								</div>
								<!--AfterDocument(sample)-->



							</div>
							<div class="boardReadFooter">
								<!-- // 첨부파일 등록 //-->
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
								<button class="boardNavigation">submit!</button>
							</div>
						</div>
					</div>


					</form>
					<!-- // 하단 내용 // -->



				</div>
				<!-- board End -->
				<!-- // 게시판 끝 // -->

			</div>
		</div>
	</div>
	
	
</body>
</html>