package com.spring.fifth.dao;

import com.spring.fifth.vo.User;

public interface UserMapper {
	public int insertUser(User user);//회원가입시

	public User selectUser(User user);//로그인시 유저 
}
