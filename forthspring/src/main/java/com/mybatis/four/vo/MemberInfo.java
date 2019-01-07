package com.mybatis.four.vo;

public class MemberInfo {
	private String username;
	private String pass;
	public MemberInfo(String username, String pass) {
		super();
		this.username = username;
		this.pass = pass;
	}
	public MemberInfo() {
		super();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "Member [username=" + username + ", pass=" + pass + "]";
	}
	
	
	
	
}
