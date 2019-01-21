package com.spring.sixth.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.sixth.service.PageNavigator;
import com.spring.sixth.vo.Board;
import com.spring.sixth.vo.BoardFile;
import com.spring.sixth.vo.Comments;

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
	
	public int insertFile(BoardFile boardFile) {
		int result = 0;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);

		try {
			result = mapper.insertFile(boardFile);

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return result;

	}

	public List<Board> selectAllBoard(PageNavigator pn) {
		List<Board> result = null;
		//xml 건들필요 없이 RowBounds만 파라메터로 넘겨주면 그 범위만큼만 셀렉해서 돌아옴
		RowBounds rb = new RowBounds(pn.getStartBoardCurrentPage(), pn.getBoardPerPage());// 어디 위치 부터 몇개 까지 한페이지당 몇개인지
		
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);

		try {

			result = mapper.selectAllBoard(rb);
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

	public List<BoardFile> selectFile(String boardseq){
		List<BoardFile> result = null;
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);

		try {

			result = mapper.selectFile(boardseq);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return result;
	}
	
	
	
	
	public int updateBoard(Board board) {
		
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		int result = 0;
		try {

			result = mapper.updateBoard(board);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
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

	
	
	public int countRecord() {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		int result = 0;
		try {
			result = mapper.countRecord();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return result;
	}
}
