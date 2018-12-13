package com.multicampus.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multicampus.biz.user.UserService;
import com.multicampus.biz.user.UserVO;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;

	@RequestMapping("/login.do")
	public String login(UserVO vo) throws Exception {
		if (userService.getUser(vo) != null)
			return "redirect:getBoardList.do";
		else
			return "login";
	}

}
