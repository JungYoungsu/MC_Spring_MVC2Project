package com.multicampus.biz.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

// 2. DAO(Data Access Object) Ŭ����

public class BoardDAOIbatis implements BoardDAO {
	@Autowired
	private SqlMapClientTemplate ibatis;
	
	// CRUD ����� �޼ҵ� ����
	// �� ���
	public void insertBoard(BoardVO vo) {
		System.out.println("===> iBatis ������� insertBoard() ��� ó��");
		ibatis.insert("insertBoard", vo);
	}

	// �� ����
	public void updateBoard(BoardVO vo) {
		System.out.println("===> iBatis ������� updateBoard() ��� ó��");
		ibatis.update("updateBoard", vo);
	}

	// �� ����
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> iBatis ������� deleteBoard() ��� ó��");
		ibatis.delete("deleteBoard", vo);
	}

	// �� �� ��ȸ
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> iBatis ������� getBoard() ��� ó��");
		return (BoardVO) ibatis.queryForObject("getBoard", vo);
	}

	// �� ��� �˻�
	@SuppressWarnings("unchecked")
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> iBatis ������� getBoardList() ��� ó��");
		return (List<BoardVO>) ibatis.queryForList("getBoardList", vo);
	}
}
