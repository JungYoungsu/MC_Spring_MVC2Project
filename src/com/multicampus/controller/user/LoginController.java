package com.multicampus.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multicampus.biz.user.UserDAO;
import com.multicampus.biz.user.UserVO;

@Controller
public class LoginController {

	@RequestMapping("/login.do")
	public String login(UserVO vo, UserDAO userDAO) throws Exception {
		if(userDAO.getUser(vo) != null) return "redirect:getBoardList.do";
		else return "login";
	}

}






