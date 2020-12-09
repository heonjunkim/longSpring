package com.biz.bbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/bbs")
public class EmAPIController {
	
	
	@RequestMapping(value="/bbs",method=RequestMethod.GET)
	public String list(Model model) {
		
		return null;
	}
	
	public String write() {		
		return null;
	}
	
	public String detail() {
		return null;
	}
	
	public String update() {
		return null;
	}
	
	public String delete() {
		return null;
	}
	
	

}
