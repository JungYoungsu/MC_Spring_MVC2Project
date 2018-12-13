package com.multicampus.controller.board;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView getBoardList(BoardVO vo, ModelAndView mav) throws Exception {
		mav.addObject("boardList", boardService.getBoardList(vo));
		mav.setViewName("getBoardList");
		return mav;
	}

}
