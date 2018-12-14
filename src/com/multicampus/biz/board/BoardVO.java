package com.multicampus.biz.board;

import java.util.Date; // �⺻ ������ ���� + �ú��� ǥ��

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.web.multipart.MultipartFile;

// 1. VO(Value Object == Data Transfer Object) Ŭ����
@XmlAccessorType(XmlAccessType.FIELD) // ��ü�� XML�� ��ȭ�� �� �ֵ��� ����. XmlAccessType.FIELD: �������� Element�� �ڵ���ȯ
public class BoardVO {
	@XmlAttribute	// �� �±װ� �ƴϰ�,�Ӽ����� ��
	private int seq;
	private String title = "";
	private String writer;
	private String content = "";
	@XmlElement(name="reg-date")		// �±� �̸� ����
	private Date regDate;
	private int cnt;
	@XmlTransient		// �񿵼� = �ش� �������� XML�� ��ȯ���� ����
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
