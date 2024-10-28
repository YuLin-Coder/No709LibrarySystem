package com.xian.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xian.exception.SortException;
import com.xian.pojo.Sort;
import com.xian.service.SortService;

@Controller
@RequestMapping("/sort")
public class SortController {

	@Autowired
	private SortService sortService;

	@RequestMapping("/findAll")
	public String findAll(Model model) {
		List<Sort> sorts = sortService.findAll();
		model.addAttribute("sorts", sorts);
		return "/sysadmin/showSort";
	}

	@RequestMapping("/toAddSort")
	public String toAddUser() {
		return "sysadmin/addSort";
	}

	@RequestMapping("/add")
	public String add(String sname) {
		sortService.add(sname);
		return "redirect:/sort/findAll";
	}

	@RequestMapping("/findBySname")
	public String findBySname(String sname, Model model) {
		List<Sort> sorts = sortService.findBySname(sname);
		model.addAttribute("sorts", sorts);
		return "/sysadmin/showSort";
	}

	@RequestMapping("/findById")
	public String findById(Integer id, Model model) {
		Sort sort = sortService.findById(id);
		model.addAttribute("sort", sort);
		return "/sysadmin/updateSort";
	}

	@RequestMapping("/modify")
	public String modify(Integer id, String sname) {
		sortService.modify(id, sname);
		return "redirect:/sort/findAll";
	}
	
	@RequestMapping("/remove")
	public String remove(Integer id,Model model){
		try {
			sortService.remove(id);
		} catch (SortException e) {
			model.addAttribute("errorMsg", e.getMessage());
		}
		return "forward:/sort/findAll";
	}
	
	
	
	
	
	
	
	
}
