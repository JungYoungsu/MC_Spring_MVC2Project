package com.multicampus.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.multicampus.biz.user.UserDAO;
import com.multicampus.biz.user.UserVO;

public class LoginController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("로그인 기능 처리");
		
		// 1. 사용자 입력정보 추출
		String id = request.getParameter("id");
		String password = request.getParameter("password");	

		// 2. DB 연동 처리
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		
		UserDAO userDAO = new UserDAO();
		UserVO user = userDAO.getUser(vo);
		
		// 3. 화면 네비게이션
		ModelAndView mav = new ModelAndView();
		if(user != null) {
			mav.setViewName("getBoardList.do");
		} else {
			mav.setViewName("login.jsp");
		}
		return mav;
		
	}

}






