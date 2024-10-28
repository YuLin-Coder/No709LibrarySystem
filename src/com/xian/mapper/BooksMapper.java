package com.xian.mapper;

import java.util.List;

import com.xian.pojo.Books;
import com.xian.pojo.Borrows;
import com.xian.pojo.Reserve;
import com.xian.pojo.Users;

public interface BooksMapper {
	// 查询所有图书
	List<Books> getAllBooks(Books book);

	// 根据图书名称和类别查询图书的数量
	int getCount(Books book);

	// 借阅图书信息
	Books getBook(Integer id);

	// 确认借阅图书
	void insertBorrow(Borrows borrow);

	// 查询借阅的图书
	List<Borrows> getBorrows(Integer uid);

	// 查询需要归还的图书
	List<Borrows> getBacks(Integer id);

	// 申请归还
	void updateBacks(Integer id);

	// 预定信息
	void insertReserve(Reserve reserve);

	// 查询预定图书信息
	List<Reserve> getReserveBook(Integer id);

	// 查询是否存在用户
	Users selectUser(Users user);
}
