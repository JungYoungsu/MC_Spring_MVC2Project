package com.multicampus.biz.user;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceClient {
	public static void main(String[] args) {
		// 1. Spring �����̳ʸ� �����Ѵ�.
		ClassPathXmlApplicationContext container = 
			new ClassPathXmlApplicationContext("springConfig.xml");
		
		// 2. UserService Ÿ���� ���� Ŭ���� ��ü�� Lookup�Ѵ�.
		UserService userService = 
			(UserService) container.getBean("userService");
		
		// 3. Lookup�� ��ü�� �޼ҵ� �׽�Ʈ
		UserVO vo = new UserVO();
		vo.setId("test");
		vo.setPassword("test");
		UserVO user = userService.getUser(vo);
		
		if(user != null) {
			System.out.println(user.getName() + "�� �α��� ȯ��^^");
		} else {
			System.out.println("�α��� ����. �ٽ� �α����ϼ���.");
		}
	}
}
