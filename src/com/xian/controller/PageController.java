package com.xian.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.xian.pojo.Admin;
import com.xian.pojo.Sort;
import com.xian.pojo.SysAdmin;
import com.xian.pojo.Users;
import com.xian.service.AdminService;
import com.xian.service.BooksService;
import com.xian.service.SortService;
import com.xian.service.SysAdminService;

@Controller
public class PageController {
	@Autowired
	private BooksService bookService;

	@Autowired
	private AdminService adminService;

	@Autowired
	private SysAdminService sysAdminService;

	@Autowired
	private SortService sortService;

	@RequestMapping("/index")
	public String toIndex() {
		return "login";
	}

	@RequestMapping("/login")
	public String login(Users user, int loginType, Model model, HttpSession session) {
		// 普通用户
		if (loginType == 1) {
			Users users = bookService.selectUser(user);
			if (users != null) {
				session.setAttribute("user", users);
				return "redirect:/user/index";
			} else {
				model.addAttribute("msg", "账号或密码错误");
				return "login";
			}
		} else if (loginType == 2) {
			Admin admin = adminService.getAdmin(user);
			if (admin != null) {
				session.setAttribute("admin", admin);
				return "redirect:/admin/index";
			} else {
				model.addAttribute("msg", "账号或密码错误");
				return "login";
			}
		} else if (loginType == 3) {
			SysAdmin sysAdmin = sysAdminService.getSysAdmin(user);
			if (sysAdmin != null) {
				session.setAttribute("sysAdmin", sysAdmin);
				return "redirect:/sysadmin/index";
			} else {
				model.addAttribute("msg", "账号或密码错误");
				return "login";
			}
		}
		return "login";
	}

	@ModelAttribute("sorts")
	public List<Sort> findAllSorts(HttpSession session) {
		List<Sort> sorts = sortService.findAll();
		session.setAttribute("sorts", sorts);
		return sorts;
	}
}
