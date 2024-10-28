package com.xian.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xian.pojo.Books;
import com.xian.pojo.Sort;
import com.xian.pojo.Users;
import com.xian.service.SortService;
import com.xian.service.SysAdminService;
import com.xian.vo.Page;

@Controller
@RequestMapping("/sysadmin")
public class SysAdminController {
	@Autowired
	private SysAdminService sysAdminService;
	
	@Autowired
	private SortService sortService;
	
	@ModelAttribute("sorts")
	public List<Sort> loadSorts(){
		List<Sort> sorts = sortService.findAll();
		return sorts;
	}

	@RequestMapping("/index")
	public String toIndex() {
		return "sysadmin/index";
	}

	@RequestMapping("/quit")
	public String quit(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:/index";
	}

	@RequestMapping("/toAdd")
	public String toAdd() {
		return "sysadmin/add";
	}

	@RequestMapping("/show")
	public String getBooks(Model model, Books book) {
		System.out.println(book);
		if (book.getSid() != null) {
			model.addAttribute("sid", book.getSid());
		}
		if (!"".equals(book.getBname()) || book.getBname().length() > 0) {
			model.addAttribute("bname", book.getBname());
		}

		Page page = sysAdminService.getBooks(book);
		model.addAttribute("page", page);
		model.addAttribute("currentPage", book.getCurrentPage());
		model.addAttribute("totalPage", page.getTotalPage());
		
		return "sysadmin/show";
	}

	@RequestMapping("/add")
	public String addBooks(Books book) {
		sysAdminService.addBooks(book);
		return "redirect:/sysadmin/show";
	}

	@RequestMapping("/selById")
	public String selBookById(Model model, Integer id) {
		Books book = sysAdminService.getBookById(id);
		model.addAttribute("book", book);
		return "sysadmin/update";
	}

	@RequestMapping("/update")
	public String updateBooks(Books book) {
		sysAdminService.updateBooks(book);
		return "redirect:/sysadmin/show";
	}

	@RequestMapping("/delete")
	public String deleteBooks(Integer id) {
		sysAdminService.deleteBooks(id);
		return "redirect:/sysadmin/show";
	}

	// 下面部分为user模块
	@RequestMapping("/showUser")
	public String showUser(Model model, Users user) {
		List<Users> users = sysAdminService.getUsers(user);
		model.addAttribute("users", users);
		return "sysadmin/showUser";
	}

	@RequestMapping("/toAddUser")
	public String toAddUser() {
		return "sysadmin/addUser";
	}

	@RequestMapping("/addUser")
	public String addUser(Users user) {
		sysAdminService.addUsers(user);
		return "redirect:/sysadmin/showUser";
	}

	@RequestMapping("/selUserById")
	public String selUserById(Model model, Integer id) {
		Users user = sysAdminService.getUserById(id);
		model.addAttribute("user", user);
		return "sysadmin/updateUser";
	}

	@RequestMapping("/updateUser")
	public String updateUser(Users user) {
		sysAdminService.updateUser(user);
		return "redirect:/sysadmin/showUser";
	}

	@RequestMapping("/deleteUser")
	public String deleteUser(Integer id) {
		sysAdminService.deleteUser(id);
		return "redirect:/sysadmin/showUser";
	}

	@RequestMapping("/checkCode")
	@ResponseBody
	public String checkCode(String code) {
		int user = sysAdminService.selectUsers(code);
		if (user != 0) {
			return "1";
		}
		return "0";
	}

}
