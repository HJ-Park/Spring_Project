package com.spring.sixth;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final String UPLOADPATH = "C:/upload/";

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {

		return "home";
	}

	@RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
	public String fileUpload(MultipartFile uploadFile, Model model) { // MultipartFile 클래스형식으로 파일 첨부했던 정보가 넘어옴, 파일경로는
																		// 암호화해서 들어옴(=fake path)

		String filename = uploadFile.getOriginalFilename();

		System.out.println(filename);

		try {
			uploadFile.transferTo(new File(UPLOADPATH + filename));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("fileName", filename);
		return "mainpage";
	}

	@RequestMapping(value = "/fileDownload", method = RequestMethod.GET)
	public void fileDownload(HttpServletResponse response, Model model, String downloadFile) {
		response.setHeader("Content-Disposition", "attahment;filename="+downloadFile);
		
		FileInputStream fis;
		ServletOutputStream sos;
		
		try {
			fis = new FileInputStream(UPLOADPATH+downloadFile);//downloadFile엔 원본이름이 세팅되야됨
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
		}finally {
		
		}
		
	}
}
