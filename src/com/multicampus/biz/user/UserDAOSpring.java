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
		System.out.println("===> Spring ������� insertUser() ��� ó��");

	}

	@Override
	public void updateUser(UserVO vo) {
		System.out.println("===> Spring ������� updateUser() ��� ó��");

	}

	@Override
	public void deleteUser(UserVO vo) {
		System.out.println("===> Spring ������� deleteUser() ��� ó��");

	}

	@Override
	public UserVO getUser(UserVO vo) {
		System.out.println("===> Spring ������� getUser() ��� ó��");
		Object[] args = {vo.getId(), vo.getPassword()};
		return spring.queryForObject(USER_GET, args, new UserRowMapper());
	}

	@Override
	public List<UserVO> getUserList(UserVO vo) {
		System.out.println("===> Spring ������� getUserList() ��� ó��");
		return null;
	}

}
