package com.multicampus.controller.board;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multicampus.biz.board.BoardService;
import com.multicampus.biz.board.BoardVO;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;

	public BoardController() {
		System.out.println("===> BoardController »ý¼º");
	}

	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo) throws Exception {
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
	public String getBoardList(BoardVO vo, ModelMap model) throws Exception {
		model.addAttribute("boardList", boardService.getBoardList(vo));
		return "getBoardList";
	}

}
