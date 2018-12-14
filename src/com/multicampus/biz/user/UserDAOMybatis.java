package com.multicampus.biz.user;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

// 2. DAO 클래스
//@Repository
public class UserDAOMybatis implements UserDAO {
	@Autowired
	private SqlSessionTemplate mybatis;

	// CRUD 기능의 메소드
	// 회원 등록
	public void insertUser(UserVO vo) {
		System.out.println("===> MyBatis 기반으로 insertUser() 기능 처리");
	}

	// 회원 수정
	public void updateUser(UserVO vo) {
		System.out.println("===> MyBatis 기반으로 updateUser() 기능 처리");
	}

	// 회원 삭제
	public void deleteUser(UserVO vo) {
		System.out.println("===> MyBatis 기반으로 deleteUser() 기능 처리");
	}

	// 회원 상세 조회
	public UserVO getUser(UserVO vo) {
		System.out.println("===> MyBatis 기반으로 getUser() 기능 처리");
		return (UserVO) mybatis.selectOne("UserDAO.getUser", vo);
	}

	// 회원 목록 검색
	public List<UserVO> getUserList(UserVO vo) {
		System.out.println("===> MyBatis 기반으로 getUserList() 기능 처리");
		return null;
	}
}
