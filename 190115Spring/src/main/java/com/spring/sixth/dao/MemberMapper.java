package com.spring.sixth.dao;

import com.spring.sixth.vo.User;

public interface MemberMapper {

	public int insertUser(User user);// 회원가입

	public User selectUser(User user);// 로그인 확인절차

}
