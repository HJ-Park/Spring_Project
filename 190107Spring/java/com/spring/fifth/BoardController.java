package com.spring.fifth;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.fifth.dao.BoardDao;
import com.spring.fifth.vo.Board;
import com.spring.fifth.vo.Comments;

@Controller
public class BoardController {
	@Autowired
	BoardDao bd;
	
	
	
	//move board
	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public String board(Model model) {
		
		return "redirect:/getboardlist";
	}
	
	@RequestMapping(value = "/boardwrite", method = RequestMethod.GET)
	public String boardWrite(HttpSession session) {
		
		if(session.getAttribute("loginID")==null) {
			return "login";
		}
		
		
		return "boardwrite";
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
			
					
			
			return "redirect:/getboardlist";
		}else {
			return "login";
		}
		
	}
	
	@RequestMapping(value = "/getboardlist", method = RequestMethod.GET)
	public String getBoardList(Model model) {

		
		List<Board> boardList = bd.selectAllBoard();
		model.addAttribute("boardList", boardList);
		
		return "board";
	}
	
	//게시물 상세보기
	@RequestMapping(value = "/boardDetail", method = RequestMethod.GET)
	public String boardDetail(Model model, String boardseq) {
		
		try {
		Integer.parseInt(boardseq);
		bd.updateBoardHit(boardseq);
		}catch(Exception e) {
			return "redirect:/selectBoardList";
		}
		Board board = bd.selectBoard(boardseq);
		List<Comments> commentList = bd.selectPostComments(boardseq);
		if(board ==null) {
			return "redirect:/selectBoardList";
		}
		
		
		System.out.println(board);
		
		model.addAttribute("board", board);
		model.addAttribute("commentList", commentList);
		
		return "boardDetail";
	}
	
	/*//게시물 수정
	@RequestMapping(value = "/boardwrite_modify", method = RequestMethod.POST)
	public String boardwrite_modify(Model model,Board board) {
		
		System.out.println(board);
		model.addAttribute("board", board);
		return "boardwrite_modify";
	}
	
	
	@RequestMapping(value = "/boardwrite_modify_on", method = RequestMethod.POST)
	public String boardwrite_modify_on(Model model,Board board) {
		System.out.println(board);
		
		
		try {
			bd.updateBoard(board);
		}catch(Exception e) {
			e.printStackTrace();
			return "boardwrite_modify";
		}
		
		model.addAttribute("board", board);
		model.addAttribute("boardseq", board.getBoardseq());
		return "redirect:/boardDetail";
	}*/
	
	
	
	@RequestMapping(value = "/deleteboard", method = RequestMethod.POST)
	public String deleteboard(HttpSession session, Model model,String boardseq) {
		
		

		Board board = bd.selectBoard(boardseq);
		System.out.println(board);
		if(!session.getAttribute("loginID").equals(board.getId())) {
			return "redirect:/home";
		}
		
		try {
			bd.removeBoard(board);
		}catch(Exception e) {
			e.printStackTrace();
			return "redirect:/home";//에러발생 페이지가 없음..
		}
		
		return "redirect:/board";
	}
	
	
	@RequestMapping(value = "/updatewrite", method = RequestMethod.POST)
	public String updatewrite(HttpSession session, Model model,String boardseq) {
		
		

		Board board = bd.selectBoard(boardseq);
		System.out.println(board);
		if(!session.getAttribute("loginID").equals(board.getId())) {
			return "redirect:/home";
		}
		
		model.addAttribute("board", board);
			
		return "redirect:/boardwrite";
	}
	
	
	@RequestMapping(value = "/updatewrite_on", method = RequestMethod.POST)
	public String updatewrite_on(HttpSession session, Model model,Board board) {
		
		
		System.out.println(board);
		
		bd.updateBoard(board);
		
		
		return "redirect:/getboardlist";
	}
	
	
	//댓글쓰기insertcomment
	@RequestMapping(value = "/insertcomment", method = RequestMethod.POST)
	public String insertComment(HttpSession session, Model model, String boardseq, String comments) {
		
		
		
		Board board = bd.selectBoard(boardseq);
		Comments com = new Comments();
		com.setBoardseq(board.getBoardseq());
		com.setId((String)session.getAttribute("loginID"));
		com.setComments(comments);
		
		System.out.println(com);
		
		bd.insertComment(com);
		
		return "redirect:/boardDetail?boardseq="+boardseq;
	}
	
	//댓글의 답글쓰기insertrecomment
	@RequestMapping(value = "/insertrecomment", method = RequestMethod.POST)
	public String insertReComment(HttpSession session, Model model, Comments com) {
		
		com.setId((String)session.getAttribute("loginID"));
		System.out.println(com);
		bd.insertComment(com);
		
		
		return "redirect:/boardDetail?boardseq="+com.getBoardseq();
	}
	
	
	//댓글 수정 updatecomment
	@RequestMapping(value = "/updatecomment", method = RequestMethod.POST)
	public String updateComment(HttpSession session, Model model, Comments com) {
	
		System.out.println(com);
		bd.updateComment(com);
		return "redirect:/boardDetail?boardseq="+com.getBoardseq();
	}
	
	//댓글 삭제 deleteComment
	@RequestMapping(value = "/deleteComment", method = RequestMethod.POST)
	public String deleteComment(HttpSession session, Model model, Comments com) {
	
		System.out.println(com);
		bd.deleteComment(com);
		return "redirect:/boardDetail?boardseq="+com.getBoardseq();
	}
	
	//대댓글 삭제 deleteReComment
	@RequestMapping(value = "/deleteReComment", method = RequestMethod.POST)
	public String deleteReComment(HttpSession session, Model model, Comments com) {
	
		System.out.println(com);
		bd.deleteReComment(com);
		return "redirect:/boardDetail?boardseq="+com.getBoardseq();
	}
}
