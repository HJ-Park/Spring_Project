package com.spring.fifth.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.fifth.vo.User;

@Repository			//@Componentml �� ������̼����� DAO ��Ͽ� ȿ����,DB���� �ڵ� ���
public class UserDao {

	
	@Autowired
	SqlSession sqlSession;
	
	public int insertUser(User user) {
		int result = 0;
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		
		try {
			result = mapper.insertUser(user);
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return result;
		
		
	}

	public User selectUser(User user) {
		User result = null;
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		
		try {
			result = mapper.selectUser(user);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return result;
		
		
	}
}
