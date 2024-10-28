package com.xian.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xian.constant.PageConstant;
import com.xian.mapper.AdminMapper;
import com.xian.pojo.Admin;
import com.xian.pojo.Borrows;
import com.xian.pojo.Reserve;
import com.xian.pojo.Users;
import com.xian.service.AdminService;
import com.xian.vo.Page;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminMapper adminMapper;

	@Override
	public Page getBorrows(Borrows borrows) {
		// 开始
		Page page = new Page();
		if (borrows.getCurrentPage() == 0) {
			borrows.setCurrentPage(PageConstant.PAGE_NUM);
		}
		int start = (borrows.getCurrentPage() - 1) * PageConstant.PAGE_SIZE;
		borrows.setStart(start);
		List<Borrows> list = adminMapper.getBorrows(borrows);
		page.setList(list);
		int count = adminMapper.getCount(borrows);
		int counPage = count / PageConstant.PAGE_SIZE;
		if (count % PageConstant.PAGE_SIZE != 0) {
			counPage++;
		}
		// 总页数
		page.setTotalPage(counPage);
		// 总记录数
		page.setCount(count);
		return page;
	}

	@Override
	public void updateBorrows(Integer id) {
		// TODO Auto-generated method stub
		adminMapper.updateBorrows(id);
	}

	@Override
	public void notAllowBorrows(Integer id) {
		// TODO Auto-generated method stub
		adminMapper.notAllowBorrows(id);
	}

	@Override
	public void inserBackBooks(Integer id) {
		// TODO Auto-generated method stub
		adminMapper.inserBackBooks(id);
	}

	@Override
	public Page getBackBooks(Borrows borrows) {
		Page page = new Page();
		if (borrows.getCurrentPage() == 0) {
			borrows.setCurrentPage(PageConstant.PAGE_NUM);
		}
		int start = (borrows.getCurrentPage() - 1) * PageConstant.PAGE_SIZE;
		borrows.setStart(start);
		List<Borrows> list = adminMapper.getBackBooks(borrows);
		page.setList(list);
		int count = adminMapper.getCount2(borrows);
		int counPage = count / PageConstant.PAGE_SIZE;
		if (count % PageConstant.PAGE_SIZE != 0) {
			counPage++;
		}
		// 总页数
		page.setTotalPage(counPage);
		// 总记录数
		page.setCount(count);
		return page;
	}

	@Override
	public void allowBackBook(Integer id) {
		// TODO Auto-generated method stub
		adminMapper.allowBackBook(id);
	}

	@Override
	public List<Reserve> getAllReserve() {
		// TODO Auto-generated method stub
		return adminMapper.getAllReserve();
	}

	@Override
	public void updateReserveBook(Integer id) {
		// TODO Auto-generated method stub
		adminMapper.updateReserveBook(id);
	}

	@Override
	public Admin getAdmin(Users user) {
		// TODO Auto-generated method stub
		return adminMapper.getAdmin(user);
	}

	@Override
	public void notAllowReserveBook(Integer id) {
		// TODO Auto-generated method stub
		adminMapper.notAllowReserveBook(id);
	}

	@Override
	public int selectBorrowsId(Integer id) {
		// TODO Auto-generated method stub
		return adminMapper.selectBorrowsId(id);
	}

	@Override
	public int selectBooksId(Integer id) {
		// TODO Auto-generated method stub
		return adminMapper.selectBooksId(id);
	}

	@Override
	public void updateBooks(Integer id) {
		// TODO Auto-generated method stub
		adminMapper.updateBooks(id);
	}

	@Override
	public void descBooks(Integer id) {
		// TODO Auto-generated method stub
		adminMapper.descBooks(id);
	}

	@Override
	public void updateBorrowsTime(Borrows borrow) {
		// TODO Auto-generated method stub
		adminMapper.updateBorrowsTime(borrow);
	}

	@Override
	public void updateReserveTime(Reserve reserve) {
		// TODO Auto-generated method stub
		adminMapper.updateReserveTime(reserve);
	}

}
