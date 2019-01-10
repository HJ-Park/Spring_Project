package com.spring.fifth;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.fifth.dao.BoardDao;
import com.spring.fifth.vo.Board;

@Controller
public class BoardController {
	@Autowired
	BoardDao bd;
	
	
	
	//move board
	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public String board() {
		return "board";
	}
	
	@RequestMapping(value = "/boardwrite", method = RequestMethod.GET)
	public String boardWrite(HttpSession session) {
		
		if(!session.getAttribute("loginID").equals(null)) {
			return "boardwrite";
		}else {
			return "login";
		}
		
	}
	
	@RequestMapping(value = "/boardwrite_on", method = RequestMethod.POST)
	public String boardWrite_on(Board board, HttpSession session,Model model) {
		
		String id = (String) session.getAttribute("loginID");
		
		board.setId(id);
		
		//input data
		if(bd.insertBoard(board)!=1) {
			model.addAttribute("warnning", "input error!");
			return "boardwrite";
		}
		
		if(!session.getAttribute("loginID").equals(null)) {
			
			
			
			List<Board> boardList = bd.selectAllBoard();
			for (Board boardtest : boardList) {
				boardtest.toString();
			}
			
			model.addAttribute("boardList", boardList);
			
					
			
			return "board";
		}else {
			return "login";
		}
		
	}
	
}
