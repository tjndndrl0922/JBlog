package com.javaex.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.BlogService;

@Controller
@RequestMapping(value = "/")
public class BlogController {

	@Autowired
	private BlogService blogService;

	@RequestMapping(value = "{id}", method = { RequestMethod.GET, RequestMethod.POST })
	public String blogMain(@PathVariable("id") String id,
			@RequestParam(value = "cateNo", required = false, defaultValue = "0") int cateNo,
			@RequestParam(value = "postNo", required = false, defaultValue = "0") int postNo, Model model) {
		System.out.println("BlogController-blogMain()");
		return "";
	}	
		
}
