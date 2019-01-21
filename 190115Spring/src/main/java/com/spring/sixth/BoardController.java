package com.spring.sixth;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.spring.sixth.dao.BoardDao;
import com.spring.sixth.service.PageNavigator;
import com.spring.sixth.vo.Board;
import com.spring.sixth.vo.BoardFile;

@Controller
public class BoardController {
	private static final String UPLOADPATH = "C:/upload/";
	//페이징에서 쓰일 상수
	private static final int boardPerPage= 5;//페이지당 글 목록수
	private static final int pagePerGroup=5;//그룹당 페이지 수
	
	@Autowired
	BoardDao bd;

	@RequestMapping(value = "/board_list", method = RequestMethod.GET)
	public String board_list(HttpSession session, Model model) {
		return "redirect:/pageNum?page=1";
	}

	
	
	@RequestMapping(value = "/goPage", method = RequestMethod.GET)
	public String goPage(HttpSession session, Model model, int page) {
		if(1>page) { //0또는 음수값 처리
			page = 1;
		}
		return "redirect:/pageNum?page="+page;
	}
	
	@RequestMapping(value = "/pageNum", method = RequestMethod.GET)
	public String pageNum(HttpSession session, Model model, int page) {
		
		int totalRecord = bd.countRecord();
		
		//전체 페이지 = (총글 레코드수 + 페이지당 글 목록수 -1)/페이지당 글 목록수
		int totalPage = (totalRecord+boardPerPage-1)/boardPerPage;
		if(page> totalPage) {
			page = totalPage;
		}
		
		PageNavigator pn = new PageNavigator(boardPerPage, pagePerGroup, page/*currentPage*/, totalRecord);
		List<Board> boardList = bd.selectAllBoard(pn);
		System.out.println(boardList);
		
		model.addAttribute("boardList", boardList);
		model.addAttribute("navi",pn);
		model.addAttribute("nowpage", page);
		/*
		 * 페이징 이전 코드 List<Board> boardList = bd.selectAllBoard();
		 * System.out.println(boardList);
		 * 
		 * model.addAttribute("boardList", boardList);
		 */
		return "mainpage";
	}
	
	
	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public String download(String boardseq, String fileseq, HttpServletResponse response) {
		List<BoardFile> fList = bd.selectFile(boardseq);

		System.out.println(fList);
		FileInputStream fis;
		ServletOutputStream sos;
		for (BoardFile boardFile : fList) {

			response.setHeader("Content-Disposition", "attahment;filename=" + boardFile.getOrgname());
			try {
				fis = new FileInputStream(UPLOADPATH + boardFile.getSavname());// downloadFile엔
																				// 원본이름이
																				// 세팅되야됨
				sos = response.getOutputStream();

				FileCopyUtils.copy(fis, sos);

				fis.close();
				sos.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {

			}

		}

		return "redirect:/boardview?" + boardseq;
	}

	@RequestMapping(value = "/boardview", method = RequestMethod.GET)
	public String boardview(HttpSession session, String boardseq, Model model) {

		Board board = bd.selectBoard(boardseq);
		List<BoardFile> bf = bd.selectFile(boardseq);
		System.out.println(board);

		model.addAttribute("board", board);
		System.out.println(bf);
		model.addAttribute("fileList", bf);
		bd.updateBoardHit(boardseq);

		return "boardview";
	}

	@RequestMapping(value = "/boardmodify", method = RequestMethod.GET)
	public String boardmodify(HttpSession session, String boardseq, Model model) {

		Board board = bd.selectBoard(boardseq);
		System.out.println(board);
		model.addAttribute("board", board);

		return "boardwrite";
	}

	@RequestMapping(value = "/boardNewWrite", method = RequestMethod.GET)
	public String boardNewWrite(HttpSession session) {

		return "boardwrite";
	}

	@RequestMapping(value = "/boardupdate_on", method = RequestMethod.POST)
	public String boardupdate_on(HttpSession session, Board board, Model model) {
		if (bd.updateBoard(board) == 1) {
			return "redirect:/boardview?boardseq=" + board.getBoardseq();
		} else {
			model.addAttribute("board", board);
			return "boardupdate";
		}

	}

	@RequestMapping(value = "/boardwrite_on", method = RequestMethod.POST)
	public String boardwrite_on(HttpSession session, Board board, Model model, MultipartFile uploadFile) {
		System.out.println("들어갈 보드 내용" + board);

		if (bd.insertBoard(board) == 1) {

			return "redirect:/board_list";
		} else {
			model.addAttribute("board", board);
			return "boardNewWrite";
		}

	}

	@RequestMapping(value = "/boardwrite_upload", method = RequestMethod.POST)
	public String boardwrite_upload(HttpSession session, Board board, MultipartFile uploadFile, Model model) {
		String id = (String) session.getAttribute("loginID");
		System.out.println("아이디" + id);
		board.setId(id);
		System.out.println("들어갈 내용" + board);
		if (bd.insertBoard(board) == 1) {

			// for (MultipartFile uf : uploadFile) {

			System.out.println("업로드파일" + uploadFile);

			String orgname = uploadFile.getOriginalFilename();
			System.out.println("오리지널네임" + orgname);
			String savname;

			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddmmss");
			String secondNow = sdf.format(date);
			String ext = orgname.split("\\.")[orgname.split("\\.").length - 1];

			savname = secondNow + "." + ext;// 20190118094234+"."+txt

			try {
				uploadFile.transferTo(new File(UPLOADPATH + savname));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			BoardFile bf = new BoardFile();
			bf.setSavname(savname);
			bf.setOrgname(orgname);
			bd.insertFile(bf);

			// }

			model.addAttribute("board", board);

			return "redirect:/board_list";
		} else {
			model.addAttribute("board", board);
			return "boardNewWrite";
		}

	}

}