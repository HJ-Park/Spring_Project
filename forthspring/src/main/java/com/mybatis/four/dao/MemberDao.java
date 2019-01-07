package com.mybatis.four.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mybatis.four.vo.MemberInfo;

@Repository
public class MemberDao {
	
	@Autowired
	SqlSession sqlSession;
	
	
	public int insertMember(MemberInfo memberinfo) {
		int result = 0;
	
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		
		
		try {
			result = mapper.insertMember(memberinfo);
			
		} catch (Exception e) {
			return 0;
		}finally {
		}
		return result;
	}
	
}
