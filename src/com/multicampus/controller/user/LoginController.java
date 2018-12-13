package com.multicampus.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multicampus.biz.user.UserDAO;
import com.multicampus.biz.user.UserVO;

@Controller
public class LoginController {

	@RequestMapping("/login.do")
	public String handleRequest(UserVO vo, UserDAO userDAO) throws Exception {
		System.out.println("로그인 기능 처리");
		UserVO user = userDAO.getUser(vo);
		if (user != null) {
			return "getBoardList.do";
		} else {
			return "login.jsp";
		}

	}

}
