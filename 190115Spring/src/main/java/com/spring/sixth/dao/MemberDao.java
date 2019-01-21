package com.spring.sixth.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.sixth.vo.User;

@Repository
public class MemberDao {
	@Autowired
	SqlSession sqlSession;
	
	
	public int insertUser(User user) {
		int result =0;
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		
		try {
			result = mapper.insertUser(user);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
	}


	public User selectUser(User user) {
		User result =null;
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		
		try {
			result = mapper.selectUser(user);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
	}
	
}
