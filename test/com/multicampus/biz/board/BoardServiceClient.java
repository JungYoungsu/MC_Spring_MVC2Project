package com.multicampus.biz.board;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BoardServiceClient {
	public static void main(String[] args) {
		// 1. Spring 컨테이너를 구동한다.
		ClassPathXmlApplicationContext container = 
			new ClassPathXmlApplicationContext("springConfig.xml");
		
		// 2. BoardService 타입의 구현 클래스 객체를 Lookup한다.
		BoardService boardService = 
			(BoardService) container.getBean("boardService");
		
		// 3. Lookup한 객체의 메소드 테스트
		BoardVO vo = new BoardVO();
		vo.setSeq(100);
		vo.setTitle("임시 제목");
		vo.setWriter("익명");
		vo.setContent("임시 내용...............");
		boardService.insertBoard(vo);

		List<BoardVO> boardList = boardService.getBoardList(vo);
		for (BoardVO board : boardList) {
			System.out.println("---> " + board.toString());
		}
	}
}






