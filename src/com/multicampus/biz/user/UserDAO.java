package com.multicampus.biz.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.multicampus.biz.common.JDBCUtil;

// 2. DAO 클래스
@Repository
public class UserDAO {
	// JDBC 관련 변수
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	// SQL 명령어들
	private final String USER_GET = "select * from users where id=? and password=?";

	// CRUD 기능의 메소드
	// 회원 등록
	public void insertUser(UserVO vo) {
		System.out.println("===> JDBC 기반으로 insertUser() 기능 처리");
	}
	
	// 회원 수정
	public void updateUser(UserVO vo) {
		System.out.println("===> JDBC 기반으로 updateUser() 기능 처리");
	}	
	
	// 회원 삭제
	public void deleteUser(UserVO vo) {
		System.out.println("===> JDBC 기반으로 deleteUser() 기능 처리");
	}	
	
	// 회원 상세 조회
	public UserVO getUser(UserVO vo) {
		System.out.println("===> JDBC 기반으로 getUser() 기능 처리");
		UserVO user = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_GET);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			rs = stmt.executeQuery();
			if(rs.next()) {
				user = new UserVO();
				user.setId(rs.getString("ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setName(rs.getString("NAME"));
				user.setRole(rs.getString("ROLE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return user;
	}
	
	// 회원 목록 검색
	public List<UserVO> getUserList(UserVO vo) {
		System.out.println("===> JDBC 기반으로 getUserList() 기능 처리");
		return null;
	}
}
