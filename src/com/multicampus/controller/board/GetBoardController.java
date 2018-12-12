package com.multicampus.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.multicampus.biz.board.BoardDAO;
import com.multicampus.biz.board.BoardVO;

public class GetBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("글 상세 조회 기능 처리");
		
		// 1. 사용자 입력정보 추출
		String seq = request.getParameter("seq");
		
		// 2. DB 연동 처리
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		
		BoardDAO boardDAO = new BoardDAO();
		BoardVO board = boardDAO.getBoard(vo);
		
		// 3. 검색 결과를 세션에 저장하고 JSP로 이동한다.
		HttpSession session = request.getSession();
		session.setAttribute("board", board);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("getBoard.jsp");
		return mav;
		
	}

}
