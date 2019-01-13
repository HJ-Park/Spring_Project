package com.spring.fifth.dao;

import java.util.List;

import com.spring.fifth.vo.Board;
import com.spring.fifth.vo.Comments;

public interface BoardMapper {
	public int insertBoard(Board board);

	public List<Board> selectAllBoard();//모든 게시글 불러오기
	
	public Board selectBoard(String boardseq);//게시글 상세보기

	public void updateBoard(Board board);		//게시글 수정하기

	public void removeBoard(Board board);		//게시글 삭제하기

	public void updateBoardHit(String boardseq);	//조회수 갱신하기

	public void insertComment(Comments com);	//댓글 작성하기

	public List<Comments> selectPostComments(String boardseq);	//게시글의 댓글 가져오기

	public void insertReComment(Comments com);	//댓글의 답글 작성하기

	public void updateComment(Comments com);	//댓글 수정하기

	public void updateRemoveComment(Comments com);	//댓글 삭제하기

	public void deleteReComment(Comments com);		//대댓글~ 삭제하기
	
}
