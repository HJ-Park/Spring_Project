package com.spring.fifth.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.fifth.vo.Board;

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
			if(result.size()==0) {
				result = null;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return result;
		
	}
}
