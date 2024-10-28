package com.xian.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xian.constant.PageConstant;
import com.xian.mapper.SysAdminMapper;
import com.xian.pojo.Books;
import com.xian.pojo.SysAdmin;
import com.xian.pojo.Users;
import com.xian.service.SysAdminService;
import com.xian.vo.Page;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class SysAdminServiceImpl implements SysAdminService {

	@Autowired
	private SysAdminMapper sysAdminMapper;

	@Override
	public Page getBooks(Books book) {
		Page page = new Page();
		if (book.getCurrentPage() == 0) {
			book.setCurrentPage(PageConstant.PAGE_NUM);
		}
		int start = (book.getCurrentPage() - 1) * PageConstant.PAGE_SIZE;
		book.setStart(start);
		List<Books> list = sysAdminMapper.getBooks(book);
		page.setList(list);
		int count = sysAdminMapper.getCount(book);
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
	public void addBooks(Books book) {
		sysAdminMapper.addBooks(book);
	}

	@Override
	public Books getBookById(Integer id) {
		return sysAdminMapper.getBookById(id);
	}

	@Override
	public void updateBooks(Books book) {
		sysAdminMapper.updateBooks(book);
	}

	@Override
	public void deleteBooks(Integer id) {
		sysAdminMapper.deleteBooks(id);
	}

	@Override
	public List<Users> getUsers(Users user) {
		return sysAdminMapper.getUsers(user);
	}

	@Override
	public void addUsers(Users user) {
		sysAdminMapper.addUsers(user);
	}

	@Override
	public Users getUserById(Integer id) {
		return sysAdminMapper.getUserById(id);
	}

	@Override
	public void updateUser(Users user) {
		sysAdminMapper.updateUser(user);
	}

	@Override
	public void deleteUser(Integer id) {
		sysAdminMapper.deleteUser(id);
	}

	@Override
	public SysAdmin getSysAdmin(Users user) {
		return sysAdminMapper.getSysAdmin(user);
	}

	@Override
	public int selectUsers(String code) {
		return sysAdminMapper.selectUsers(code);
	}

}
