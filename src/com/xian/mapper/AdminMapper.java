package com.xian.mapper;

import java.util.List;

import com.xian.pojo.Admin;
import com.xian.pojo.Borrows;
import com.xian.pojo.Reserve;
import com.xian.pojo.Users;

public interface AdminMapper
{
	//查询所有借阅记录
	List<Borrows> getBorrows(Borrows borrows);
	
	int getCount(Borrows borrow);
	
	int getCount2(Borrows borrow);
	//允许借阅
	void updateBorrows(Integer id);
	//不允许借阅
	void notAllowBorrows(Integer id);
	//添加未归还图书
	void inserBackBooks(Integer id);
	//查看申请归还的图书
	List<Borrows> getBackBooks(Borrows borrows);
	//同意归还
	void allowBackBook(Integer id);
	//显示所有用户申请预定图书
	List<Reserve> getAllReserve();
	//同意申请预定图书
	void updateReserveBook(Integer id);
	//查询管理员
	Admin getAdmin(Users user);
	//不同意申请预定图书
	void notAllowReserveBook(Integer id);
	//添加归还图书数目，先查询出borrows的id,根据borrows的bid得到book的ID
	int selectBorrowsId(Integer id);
	int selectBooksId(Integer id);
	//增加图书数
	void updateBooks(Integer id);
	//减少图书数量
	void descBooks(Integer id);
	//更新归还时间
	void updateBorrowsTime(Borrows borrow);
	//更新预定结束时间
	void updateReserveTime(Reserve reserve);
}
