package com.mybatis.four;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mybatis.four.dao.MemberDao;



/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	MemberDao dao= new MemberDao();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		
		return "signup";
	}
	
}
