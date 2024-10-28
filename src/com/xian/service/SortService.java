package com.xian.service;

import java.util.List;

import com.xian.exception.SortException;
import com.xian.pojo.Sort;

public interface SortService {
	public List<Sort> findAll();

	public Sort findById(Integer id);

	public void add(String sname);

	public List<Sort> findBySname(String sname);

	public void modify(Integer id,String sname);
	
	public void remove(Integer id) throws SortException;
}
