package com.xian.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.xian.pojo.Books;
import com.xian.pojo.Borrows;
import com.xian.pojo.Reserve;
import com.xian.pojo.Users;
import com.xian.service.BooksService;
import com.xian.vo.Page;

@Controller
@RequestMapping("/user")
public class UsersController {
	@Autowired
	private BooksService booksService;

	@RequestMapping("/index")
	public String toIndex() {
		return "/users/index";
	}

	@RequestMapping("/quit")
	public String quit(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:/index";
	}

	@RequestMapping("/show")
	public String toShow(Model model, Books book) {
		System.out.println(book);
		if (book.getSid() != null) {
			model.addAttribute("sid", book.getSid());
		}
		if (!"".equals(book.getBname()) || book.getBname().length() > 0) {
			model.addAttribute("bname", book.getBname());
		}
		Page page = booksService.getAllBooks(book);
		model.addAttribute("page", page);
		model.addAttribute("currentPage", book.getCurrentPage());
		model.addAttribute("totalPage", page.getTotalPage());
		return "/users/show";
	}

	@RequestMapping("/borrow")
	public String toBorrow(Model model, Integer id) {
		Books book = booksService.getBook(id);
		System.out.println(book);
		model.addAttribute("book", book);
		return "/users/borrows";
	}

	/**
	 * 差用户id未注入，到时候添加登录功能在补充
	 */
	@RequestMapping("/insert")
	public String insertBorrow(Borrows borrow, HttpSession session) {
		Users user = (Users) session.getAttribute("user");
		System.out.println("id" + borrow);
		borrow.setUid(user.getId());
		Date date = new Date();
		borrow.setStartTime(date);
		borrow.setStatus(0);
		booksService.insertBorrow(borrow);
		// booksService.updateBooks(borrow.getBid());
		return "redirect:/user/back";
	}

	/**
	 * @return 也是注入用户ID，这里先用1
	 */
	@RequestMapping("/back")
	public String getBorrows(Model model, HttpSession session) {
		Users user = (Users) session.getAttribute("user");
		List<Borrows> borrows = booksService.getBorrows(user.getId());
		model.addAttribute("borrows", borrows);
		return "users/back";
	}

	/**
	 * @return 这里注入session再把1换成session取得的id
	 */
	@RequestMapping("/showBackBook")
	public String showBackBook(Model model, HttpSession session) {
		Users user = (Users) session.getAttribute("user");
		List<Borrows> backs = booksService.getBacks(user.getId());
		model.addAttribute("backs", backs);
		return "users/showBackBook";
	}

	@RequestMapping("/backBooks")
	public String backBooks(Integer id) {
		booksService.updateBacks(id);
		return "redirect:/user/showBackBook";
	}

	// 预定图书,注入session后把1换成session的User中id
	@RequestMapping("/reserve")
	public String reserveBooks(Reserve reserve, HttpSession session) {
		Users user = (Users) session.getAttribute("user");
		reserve.setUid(user.getId());
		Date date = new Date();
		System.out.println(date);
		reserve.setStartTime(date);
		booksService.insertReserve(reserve);
		return "redirect:/user/showReserveBook";
	}

	/**
	 * @return 到时候注入session，1换成session的id
	 */
	@RequestMapping("/showReserveBook")
	public String showReserveBook(Model model, HttpSession session) {
		Users user = (Users) session.getAttribute("user");
		List<Reserve> reserveBooks = booksService.getReserveBook(user.getId());
		model.addAttribute("reserveBooks", reserveBooks);
		return "/users/reserveBook";
	}
	
}
