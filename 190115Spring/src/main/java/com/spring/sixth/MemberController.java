package com.spring.sixth;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.sixth.dao.MemberDao;
import com.spring.sixth.vo.User;

@Controller
public class MemberController {
	@Autowired
	MemberDao md;
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void login(){
	}
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public void signup(){
	}
	@RequestMapping(value = "/mainpage", method = RequestMethod.GET)
	public void mainpage(){
	}
	
	@RequestMapping(value = "/login_on", method = RequestMethod.POST)
	public String signin(HttpSession session, User user, Model model){
		User onUser = md.selectUser(user);
		
		if(onUser==null) {
			model.addAttribute("warnning", "로그인 실패");
			return "login";
		}
		
		
		session.setAttribute("loginID", onUser.getId());
		
		return "redirect:/board_list";
	}
	@RequestMapping(value = "/signup_on", method = RequestMethod.POST)
	public String signup_on(Model model,User user){
		if (md.insertUser(user) == 1) {
			model.addAttribute("userid", user.getId());

			System.out.println("sucess commit");
			return "login";
		} else {
			model.addAttribute("warnning", "가입실패");
			return "signup";
		}
	}
	
}
