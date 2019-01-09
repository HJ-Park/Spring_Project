package com.spring.fifth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.fifth.dao.UserDao;
import com.spring.fifth.vo.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class UserController {
	
	@Autowired
	UserDao ud;
	
	//会員加入ページヘ
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(User user, Model model) {
		
		return "signup";
	}
	//会員加入	メソード
	@RequestMapping(value = "/signup_on", method = RequestMethod.POST)
	public String signup_on(User user, Model model) {
		model.addAttribute("name", user.getName());
		model.addAttribute("phone", user.getPhone());
		model.addAttribute("email", user.getEmail());
		model.addAttribute("birthdate", user.getBirthdate());
		if(ud.insertUser(user) == 1) {
			model.addAttribute("userid", user.getId());
			
			System.out.println("sucess commit");
			return "login";
		}else {
			model.addAttribute("warnning","가입실패");
			return "signup";
		}
	}
	
	
	//ログインページへ	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		
		return "login";
	}
	
	//ログインメソード
	@RequestMapping(value = "/login_on", method = RequestMethod.POST)
	public String login_on(User user, Model model) {
		
		System.out.println(user);
		User gUser = ud.selectUser(user);
		if(gUser != null) {
			model.addAttribute("name", gUser.getName());
			model.addAttribute("phone", gUser.getPhone());
			model.addAttribute("email", gUser.getEmail());
			model.addAttribute("birthdate", gUser.getBirthdate());
			System.out.println("sucess commit");
			return "login";
		}else {
			model.addAttribute("warnning","로그인 실패");
			return "login";
		}	
	}
}