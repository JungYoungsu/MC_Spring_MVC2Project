package com.multicampus.biz.board;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="board-list")		// ��Ʈ ������Ʈ + �̸� ����
@XmlAccessorType(XmlAccessType.FIELD)
public class BoardListVO {
	private List<BoardVO> boards;

	public List<BoardVO> getBoards() {
		return boards;
	}

	public void setBoards(List<BoardVO> boards) {
		this.boards = boards;
	}

}
