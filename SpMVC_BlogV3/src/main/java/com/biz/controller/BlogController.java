package com.biz.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.blog.model.BlogVO;
import com.biz.blog.service.BlogService;

@RequestMapping(value = "/blog")
@Controller
public class BlogController {
	
	@Autowired
	private BlogService bService;
	
	@RequestMapping(value = "/list", method=RequestMethod.GET)
	public String list(Model model) {
		System.out.println("블로그 리스트 보기");
		
		List<BlogVO> blogList = bService.selectAll();
		if(blogList != null) {
		int size = blogList.size();
		model.addAttribute("TITLE", blogList.get(size - 1).getTitle());
		model.addAttribute("CONTENT", blogList.get(size - 1).getContent());
		model.addAttribute("USER", blogList.get(size - 1).getUser());
		} else {
			model.addAttribute("TITLE", "데이터가없음");
		}
		return "list";
	}
	
	
	@RequestMapping(value = "/input", method=RequestMethod.GET)
	public String input() {
		return "write";
	}
	@RequestMapping(value ="/writer", method=RequestMethod.POST)
	public String write(@ModelAttribute BlogVO blogVO, Model model) {
		
		System.out.println("USER :" + blogVO.getUser());
		System.out.println("TITLE : " + blogVO.getTitle());
		System.out.println("CONTENT :" + blogVO.getContent());
		
		bService.insert(blogVO);
		
		
		model.addAttribute("TITLE", blogVO.getTitle());
		model.addAttribute("CONTENT", blogVO.getContent());
		model.addAttribute("USER", blogVO.getUser());
		return "redirect:/blog/list";
	}
	
	

}
