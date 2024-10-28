package com.xian.service;

import java.util.List;

import com.xian.pojo.Books;
import com.xian.pojo.Borrows;
import com.xian.pojo.Reserve;
import com.xian.pojo.Users;
import com.xian.vo.Page;

public interface BooksService
{
	//查询所有图书
//List<Books> getAllBooks(Books book);
	Page getAllBooks(Books book);
	//借阅图书
	Books getBook(Integer id);
	//确认借阅图书
	void insertBorrow(Borrows borrow);
	//查询借阅的图书
	List<Borrows> getBorrows(Integer uid);
	//查询需要归还的图书
	List<Borrows> getBacks(Integer id);
	//申请归还
	void updateBacks(Integer id);
	//预定信息
	void insertReserve(Reserve reserve);
	//查询预定图书信息
	List<Reserve> getReserveBook(Integer id);
	//查询是否存在用户
	Users selectUser(Users user);
	//用户借书减少图书数量
	/*void updateBooks(Integer id);*/
}
