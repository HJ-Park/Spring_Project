package com.spring.sixth.service;

public class PageNavigator {
	private int boardPerPage;// 페이지당 글목록수
	private int pagePerGroup;// 그룹당 페이지수
	private int currentPage;// 현재 페이지
	private int totalBoard;// 전체 레코드수
	private int totalPage;// 전체 페이지수
	private int currentPageGroup;// 현재 페이지 그룹
	/*
	 * 구하려는것
	 */
	
	
	private int startPageGroup;// 현재 그룹 첫페이지		//jsp
	private int endPageGroup;// 현재 그룹 마지막페이지		//jsp
	private int startBoardCurrentPage;// 현재 페이지의 첫글 위치	//DB에서 조회시 사용

	public PageNavigator() {
		super();
	}
	

	public PageNavigator(int boardPerPage, int pagePerGroup, int currentPage, int totalBoard) { 
		this.boardPerPage = boardPerPage;
		this.pagePerGroup = pagePerGroup;
		//this.totalBoard = totalBoard;
		//전체 페이지 = (총글 레코드수 + 페이지당 글 목록수 -1)/페이지당 글 목록수
		totalPage = (totalBoard+boardPerPage-1)/boardPerPage;
		
		if(currentPage<1) {
			this.currentPage = 1;
		}else if(currentPage>totalPage) {
			this.currentPage = totalPage;
		}
		this.currentPage = currentPage;
		
		//현재 그룹= (현재페이지-1)/그룹당페이지수
		currentPageGroup=(currentPage-1)/pagePerGroup;
		
		startPageGroup= currentPageGroup*pagePerGroup+1;
		
		if(startPageGroup<1) {
			startPageGroup = 1;
		}
		
		endPageGroup = startPageGroup+pagePerGroup -1;
		if(endPageGroup>totalPage) {
			endPageGroup= totalPage;
		}
		//현재 페이지의 첫 글 위치 = (현재페이지 -1) * 페이지당 글목록수
		startBoardCurrentPage = (currentPage-1) * boardPerPage;
		
	}


	public int getBoardPerPage() {
		return boardPerPage;
	}


	public void setBoardPerPage(int boardPerPage) {
		this.boardPerPage = boardPerPage;
	}


	public int getPagePerGroup() {
		return pagePerGroup;
	}


	public void setPagePerGroup(int pagePerGroup) {
		this.pagePerGroup = pagePerGroup;
	}


	public int getCurrentPage() {
		return currentPage;
	}


	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}


	public int getTotalBoard() {
		return totalBoard;
	}


	public void setTotalBoard(int totalBoard) {
		this.totalBoard = totalBoard;
	}


	public int getTotalPage() {
		return totalPage;
	}


	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}


	public int getCurrentPageGroup() {
		return currentPageGroup;
	}


	public void setCurrentPageGroup(int currentPageGroup) {
		this.currentPageGroup = currentPageGroup;
	}


	public int getStartPageGroup() {
		return startPageGroup;
	}


	public void setStartPageGroup(int startPageGroup) {
		this.startPageGroup = startPageGroup;
	}


	public int getEndPageGroup() {
		return endPageGroup;
	}


	public void setEndPageGroup(int endPageGroup) {
		this.endPageGroup = endPageGroup;
	}


	public int getStartBoardCurrentPage() {
		return startBoardCurrentPage;
	}


	public void setStartBoardCurrentPage(int startBoardCurrentPage) {
		this.startBoardCurrentPage = startBoardCurrentPage;
	}


	@Override
	public String toString() {
		return "PageNavigator [boardPerPage=" + boardPerPage + ", pagePerGroup=" + pagePerGroup + ", currentPage="
				+ currentPage + ", totalBoard=" + totalBoard + ", totalPage=" + totalPage + ", currentPageGroup="
				+ currentPageGroup + ", startPageGroup=" + startPageGroup + ", endPageGroup=" + endPageGroup
				+ ", startBoardCurrentPage=" + startBoardCurrentPage + "]";
	}




}
