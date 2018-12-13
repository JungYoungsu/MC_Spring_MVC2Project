package com.multicampus.biz.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDAOSpring implements UserDAO {
	@Autowired
	private JdbcTemplate spring;

	private static final String USER_GET = "select * from users where id=? and password=?";

	@Override
	public void insertUser(UserVO vo) {
		System.out.println("===> Spring 기반으로 insertUser() 기능 처리");

	}

	@Override
	public void updateUser(UserVO vo) {
		System.out.println("===> Spring 기반으로 updateUser() 기능 처리");

	}

	@Override
	public void deleteUser(UserVO vo) {
		System.out.println("===> Spring 기반으로 deleteUser() 기능 처리");

	}

	@Override
	public UserVO getUser(UserVO vo) {
		System.out.println("===> Spring 기반으로 getUser() 기능 처리");
		Object[] args = {vo.getId(), vo.getPassword()};
		return spring.queryForObject(USER_GET, args, new UserRowMapper());
	}

	@Override
	public List<UserVO> getUserList(UserVO vo) {
		System.out.println("===> Spring 기반으로 getUserList() 기능 처리");
		return null;
	}

}
