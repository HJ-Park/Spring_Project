package com.spring.fifth.dao;

import java.util.List;

import com.spring.fifth.vo.Board;

public interface BoardMapper {
	int insertBoard(Board board);

	List<Board> selectAllBoard();//모든 게시글 불러오기
	
}
