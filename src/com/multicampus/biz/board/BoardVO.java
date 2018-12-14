package com.multicampus.biz.board;

import java.util.Date; // 기본 생성자 있음 + 시분초 표시

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.web.multipart.MultipartFile;

// 1. VO(Value Object == Data Transfer Object) 클래스
@XmlAccessorType(XmlAccessType.FIELD) // 객체를 XML로 변화할 수 있도록 해줌. XmlAccessType.FIELD: 변수들을 Element로 자동변환
public class BoardVO {
	@XmlAttribute	// 새 태그가 아니고,속성으로 들어감
	private int seq;
	private String title = "";
	private String writer;
	private String content = "";
	@XmlElement(name="reg-date")		// 태그 이름 설정
	private Date regDate;
	private int cnt;
	@XmlTransient		// 비영속 = 해당 변수들은 XML로 변환하지 마라
	private MultipartFile uploadFile;

	public MultipartFile getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	@Override
	public String toString() {
		return "BoardVO [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content + ", regDate="
				+ regDate + ", cnt=" + cnt + "]";
	}

}
