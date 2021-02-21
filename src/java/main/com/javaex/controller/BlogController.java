package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/blog")
public class BlogController {

	@RequestMapping(value="",method = {RequestMethod.GET,RequestMethod.POST})
	public String blogMain() {
		System.out.println("BlogController-blogMain()");
		
		return "";
	}
}
