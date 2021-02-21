package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.UsersService;
import com.javaex.vo.UsersVo;



@Controller
@RequestMapping(value= "/user")
public class UsersController {
	
	@Autowired
	private UsersService usersService;
	
	@RequestMapping(value="/joinForm", method= {RequestMethod.GET,RequestMethod.POST})
	public String joinForm() {
		System.out.println("UsersController-joinForm");
		return "user/joinForm";
	}
	
	@RequestMapping(value="/loginForm", method = {RequestMethod.GET,RequestMethod.POST})
	public String loginForm() {
		System.out.println("UsersController-loginForm");
		return "user/loginForm";
	}
	
	@RequestMapping(value="/join", method = {RequestMethod.GET,RequestMethod.POST})
	public String join(@ModelAttribute UsersVo usersVo) {
		System.out.println("UsersController-join");
		
		//id, uesrName, password 확인
		System.out.println(usersVo);
		
		usersService.join(usersVo);
		return "user/joinSuccess";
	}
	
	//회원가입 아이디 체크
	@ResponseBody
	@RequestMapping(value="/idcheck", method = {RequestMethod.GET,RequestMethod.POST})
	public String idcheck(@RequestParam("id") String id) {
		System.out.println("UsersController-idcheck");
		System.out.println("id = "+id);
		String result = usersService.idcheck(id);
		return result;
	}
	
}
