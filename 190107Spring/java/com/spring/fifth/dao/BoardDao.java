package com.spring.fifth.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.fifth.vo.Board;
import com.spring.fifth.vo.Comments;

@Repository
public class BoardDao {
	@Autowired
	SqlSession sqlSession;

	public int insertBoard(Board board) {
		int result = 0;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);

		try {
			result = mapper.insertBoard(board);

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return result;

	}

	public List<Board> selectAllBoard() {
		List<Board> result = null;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);

		try {

			result = mapper.selectAllBoard();
			if (result.size() == 0) {
				result = null;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return result;

	}

	public Board selectBoard(String boardseq) {
		Board result = null;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);

		try {

			result = mapper.selectBoard(boardseq);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return result;
	}

	public void updateBoard(Board board) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);

		try {

			mapper.updateBoard(board);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeBoard(Board board) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);

		try {

			mapper.removeBoard(board);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateBoardHit(String boardseq) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);

		try {

			mapper.updateBoardHit(boardseq);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertComment(Comments com) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			if (com.getParentseq() == 0) {
				mapper.insertComment(com);
			} else {
				mapper.insertReComment(com);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Comments> selectPostComments(String boardseq) {
		List<Comments> bList = null;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			bList = mapper.selectPostComments(boardseq);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bList;
	}

	public void updateComment(Comments com) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {

			mapper.updateComment(com);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteComment(Comments com) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			com.setComments("삭제된 댓글입니다.");
			com.setId("");
			mapper.updateRemoveComment(com);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	public void deleteReComment(Comments com) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		try {
			mapper.deleteReComment(com);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
