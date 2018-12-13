package com.multicampus.controller.board;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.multicampus.biz.board.BoardService;
import com.multicampus.biz.board.BoardVO;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;

	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo) throws Exception {
		// ���� ���ε� ó��
		MultipartFile uploadFile = vo.getUploadFile();
		if (!uploadFile.isEmpty())
			uploadFile.transferTo(new File("C:/" + uploadFile.getOriginalFilename()));

		boardService.insertBoard(vo);
		return "redirect:getBoardList.do";
	}

	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo) throws Exception {
		boardService.updateBoard(vo);
		return "redirect:getBoardList.do";
	}

	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) throws Exception {
		boardService.deleteBoard(vo);
		return "redirect:getBoardList.do";
	}

	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, HttpSession session) throws Exception {
		session.setAttribute("board", boardService.getBoard(vo));
		return "getBoard";
	}

	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model, 
			@RequestParam(value = "searchCondition", defaultValue = "") String searchCondition,
			@RequestParam(value = "searchKeyword", defaultValue = "") String searchKeyword) throws Exception {
		if (searchCondition.equals("TITLE")) {
			vo.setTitle(searchKeyword);
			vo.setContent("");
		} else if (searchCondition.equals("CONTENT")) {
			vo.setTitle("");
			vo.setContent(searchKeyword);
		} else {
			vo.setTitle("");
			vo.setContent("");
		}
		model.addAttribute("boardList", boardService.getBoardList(vo));
		return "getBoardList";
	}

}
