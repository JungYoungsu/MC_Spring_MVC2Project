package com.multicampus.biz.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

// 2. DAO(Data Access Object) 클래스
@Repository
public class BoardDAOSpring {
	@Autowired
	private JdbcTemplate spring;

	// SQL 명령어들
	private final String BOARD_INSERT = "insert into board(seq, title, writer, content) values((select nvl(max(seq), 0)+1 from board),?,?,?)";
	private final String BOARD_UPDATE = "update board set title=?, content=? where seq=?";
	private final String BOARD_DELETE = "delete board where seq=?";
	private final String BOARD_GET    = "select * from board where seq=?";
	private final String BOARD_LIST   = "select * from board order by seq desc";

	// CRUD 기능의 메소드 구현
	// 글 등록
	public void insertBoard(BoardVO vo) {
		System.out.println("===> Spring 기반으로 insertBoard() 기능 처리");
		Object[] args = {vo.getTitle(), vo.getWriter(), vo.getContent()};
		spring.update(BOARD_INSERT, args);
	}

	// 글 수정
	public void updateBoard(BoardVO vo) {
		System.out.println("===> Spring 기반으로 updateBoard() 기능 처리");
		spring.update(BOARD_UPDATE, vo.getTitle(), vo.getContent(), vo.getSeq());
	}

	// 글 삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> Spring 기반으로 deleteBoard() 기능 처리");
		spring.update(BOARD_DELETE, vo.getSeq());
	}
	
	// 글 상세 조회
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> Spring 기반으로 getBoard() 기능 처리");
		Object[] args = {vo.getSeq()};
		return spring.queryForObject(BOARD_GET, args, new BoardRowMapper());
	}

	// 글 목록 검색
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> Spring 기반으로 getBoardList() 기능 처리");
		return spring.query(BOARD_LIST, new BoardRowMapper());
	}
}












