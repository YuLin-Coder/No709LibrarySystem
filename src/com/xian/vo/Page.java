package com.xian.vo;

import java.io.Serializable;
import java.util.List;

import com.xian.pojo.Books;

public class Page implements Serializable{

	// 总记录数
	private int count;
	// 总页数
	private int totalPage;

	List list;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Page [count=" + count + ", totalPage=" + totalPage + ", list=" + list + "]";
	}

}
