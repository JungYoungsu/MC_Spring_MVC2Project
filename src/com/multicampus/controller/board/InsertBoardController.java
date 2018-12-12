package com.multicampus.controller.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multicampus.biz.board.BoardDAO;
import com.multicampus.biz.board.BoardVO;

@Controller
public class InsertBoardController {
	
	@RequestMapping("/insertBoard.do")
	public void insertBoard(BoardVO vo, BoardDAO boardDAO) throws Exception {
		boardDAO.insertBoard(vo);
	}

}








