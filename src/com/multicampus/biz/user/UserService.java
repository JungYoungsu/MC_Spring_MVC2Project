package com.multicampus.biz.user;

import java.util.List;

// 3. Service �������̽�
public interface UserService {

	// CRUD ����� �޼ҵ�
	// ȸ�� ���
	void insertUser(UserVO vo);

	// ȸ�� ����
	void updateUser(UserVO vo);

	// ȸ�� ����
	void deleteUser(UserVO vo);

	// ȸ�� �� ��ȸ
	UserVO getUser(UserVO vo);

	// ȸ�� ��� �˻�
	List<UserVO> getUserList(UserVO vo);

}