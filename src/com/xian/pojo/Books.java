package com.xian.pojo;

import java.io.Serializable;

/**
 * 图书
 */
public class Books implements Serializable{
	private Integer id;
	private String bname;
	private Integer sid;
	private String number;
	private String author;
	private String birth;
	private String edition;
	private String sname;

	// 页面数据
	private int start;
	// 当前页数
	private int currentPage;

	public Books() {
		super();
	}

	public Books(Integer id, String bname, Integer sid, String number, String author, String birth, String edition) {
		super();
		this.id = id;
		this.bname = bname;
		this.sid = sid;
		this.number = number;
		this.author = author;
		this.birth = birth;
		this.edition = edition;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	@Override
	public String toString() {
		return "Books [id=" + id + ", bname=" + bname + ", sid=" + sid + ", number=" + number + ", author=" + author
				+ ", birth=" + birth + ", edition=" + edition + ", sname=" + sname + ", start=" + start
				+ ", currentPage=" + currentPage + "]";
	}

}
