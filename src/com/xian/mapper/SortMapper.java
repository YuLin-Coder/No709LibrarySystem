package com.xian.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xian.pojo.Sort;

public interface SortMapper {

	public List<Sort> selectAll();
	
	public Sort selectById(Integer id);
	
	public void insert(String sname);
	
	public List<Sort> selectBySname(String sname);

	public void update(@Param("id")Integer id,@Param("sname")String sname);
	
	public void delete(Integer id);
}


