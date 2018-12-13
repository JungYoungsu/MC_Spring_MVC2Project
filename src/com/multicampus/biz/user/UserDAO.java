package com.multicampus.biz.user;

import java.util.List;

public interface UserDAO {

	// CRUD 기능의 메소드
	// 회원 등록
	void insertUser(UserVO vo);

	// 회원 수정
	void updateUser(UserVO vo);

	// 회원 삭제
	void deleteUser(UserVO vo);

	// 회원 상세 조회
	UserVO getUser(UserVO vo);

	// 회원 목록 검색
	List<UserVO> getUserList(UserVO vo);

}