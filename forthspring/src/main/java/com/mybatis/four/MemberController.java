package com.mybatis.four;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mybatis.four.dao.MemberDao;
import com.mybatis.four.vo.MemberInfo;


@Controller
public class MemberController {
	
	@Autowired
	MemberDao dao= new MemberDao();

	@RequestMapping(value = "/insertUser", method = RequestMethod.POST)
	public String signup(MemberInfo memberinfo, Model model) {
		
		if(dao.insertMember(memberinfo) == 1) {
			model.addAttribute("warning", memberinfo.getUsername());
		}else {
			model.addAttribute("warning", "ȸ�����Կ� �����Ͽ����ϴ�.");
		}
		
		return "signup";
	}
	
}