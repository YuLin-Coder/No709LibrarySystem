package com.xian.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xian.pojo.Borrows;
import com.xian.pojo.Reserve;
import com.xian.service.AdminService;
import com.xian.service.SortService;
import com.xian.vo.Page;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@RequestMapping("/index")
	public String toIndex() {
		return "/admin/index";
	}

	@RequestMapping("/quit")
	public String quit(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:/index";
	}

	@RequestMapping("/show")
	public String toshow(Model model, Borrows borrow) {
		if (borrow.getSid() != null) {
			model.addAttribute("sid", borrow.getSid());
		}
		if (!"".equals(borrow.getUname()) || borrow.getUname().length() > 0) {
			model.addAttribute("uname", borrow.getUname());
		}
		Page page = adminService.getBorrows(borrow);
		model.addAttribute("page", page);
		model.addAttribute("currentPage", borrow.getCurrentPage());
		model.addAttribute("totalPage", page.getTotalPage());
		return "/admin/show";
	}

	@RequestMapping("/allow")
	public String allowBorrows(Integer id) {
		// 审批，并增加未归还图书
		adminService.updateBorrows(id);
		adminService.inserBackBooks(id);
		// 图书数目减1
		int booksId = adminService.selectBooksId(id);
		adminService.descBooks(booksId);
		return "redirect:/admin/show";
	}

	@RequestMapping("/notAllow")
	public String notAllow(Integer id) {
		adminService.notAllowBorrows(id);
		// 更新结束时间
		Date endTime = new Date();
		Borrows borrow = new Borrows();
		borrow.setId(id);
		borrow.setEndTime(endTime);
		adminService.updateBorrowsTime(borrow);
		return "redirect:/admin/show";
	}

	@RequestMapping("/backBooks")
	public String getBackBooks(Model model,Borrows borrow) {
		Page page = adminService.getBackBooks(borrow);
		
		model.addAttribute("page", page);
		model.addAttribute("currentPage", borrow.getCurrentPage());
		model.addAttribute("totalPage", page.getTotalPage());
		
		return "/admin/showBackBook";
	}

	@RequestMapping("/allowBackBook")
	public String allowBackBook(Integer id) {
		adminService.allowBackBook(id);
		int borrowsId = adminService.selectBorrowsId(id);
		int booksId = adminService.selectBooksId(borrowsId);
		// 图书数目加1
		adminService.updateBooks(booksId);
		// 更新归还时间
		Date endTime = new Date();
		Borrows borrow = new Borrows();
		borrow.setId(borrowsId);
		borrow.setEndTime(endTime);
		adminService.updateBorrowsTime(borrow);
		return "redirect:/admin/backBooks";
	}

	// 获得所有预定图书信息
	@RequestMapping("/showReserveBook")
	public String showReserveBook(Model model) {
		List<Reserve> allReserves = adminService.getAllReserve();
		model.addAttribute("allReserves", allReserves);
		return "/admin/showReserveBook";
	}

	// 允许预定图书信息
	@RequestMapping("/allowReserveBook")
	public String allowReserveBook(Integer id) {
		adminService.updateReserveBook(id);
		// 预定处理时间
		Date endTime = new Date();
		Reserve reserve = new Reserve();
		reserve.setId(id);
		reserve.setEndTime(endTime);
		adminService.updateReserveTime(reserve);
		return "redirect:/admin/showReserveBook";
	}

	// 允许预定图书信息
	@RequestMapping("/notAllowReserveBook")
	public String notAllowReserveBook(Integer id) {
		adminService.notAllowReserveBook(id);
		Date endTime = new Date();
		Reserve reserve = new Reserve();
		reserve.setId(id);
		reserve.setEndTime(endTime);
		adminService.updateReserveTime(reserve);
		return "redirect:/admin/showReserveBook";
	}

}
