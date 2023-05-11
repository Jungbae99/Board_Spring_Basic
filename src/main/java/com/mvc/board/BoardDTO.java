package com.mvc.board;

import java.sql.Timestamp;

public class BoardDTO {
	
	// DTO : Data Transfer Object : 데이터교환을 하기위한 자바빈 객체
	/*
	ID	NUMBER(4,0)
	WRITER	NVARCHAR2(50 CHAR)
	TITLE	NVARCHAR2(50 CHAR)
	CONTENT	NVARCHAR2(400 CHAR)
	REG_DATE	TIMESTAMP(6)
	VIEW_COUNT	NUMBER(4,0)
	*/
	private Integer id;
	private String writer;
	private String title;
	private String content;
	private Timestamp regDate;
	private Integer viewCount;
	
	//기본생성자 필수
	public BoardDTO() {
		
	}
	
	
	// 초기화생성자
	public BoardDTO(Integer id, String writer, String title, String content, Timestamp regDate, Integer viewCount) {
		super();
		this.id = id;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.viewCount = viewCount;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getWriter() {
		return writer;
	}


	public void setWriter(String writer) {
		this.writer = writer;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Timestamp getRegDate() {
		return regDate;
	}


	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}


	public Integer getViewCount() {
		return viewCount;
	}


	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}
	
	
	
	

}
