package com.multicampus.biz.user;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

// 2. DAO Ŭ����
//@Repository
public class UserDAOMybatis implements UserDAO {
	@Autowired
	private SqlSessionTemplate mybatis;

	// CRUD ����� �޼ҵ�
	// ȸ�� ���
	public void insertUser(UserVO vo) {
		System.out.println("===> MyBatis ������� insertUser() ��� ó��");
	}

	// ȸ�� ����
	public void updateUser(UserVO vo) {
		System.out.println("===> MyBatis ������� updateUser() ��� ó��");
	}

	// ȸ�� ����
	public void deleteUser(UserVO vo) {
		System.out.println("===> MyBatis ������� deleteUser() ��� ó��");
	}

	// ȸ�� �� ��ȸ
	public UserVO getUser(UserVO vo) {
		System.out.println("===> MyBatis ������� getUser() ��� ó��");
		return (UserVO) mybatis.selectOne("UserDAO.getUser", vo);
	}

	// ȸ�� ��� �˻�
	public List<UserVO> getUserList(UserVO vo) {
		System.out.println("===> MyBatis ������� getUserList() ��� ó��");
		return null;
	}
}
