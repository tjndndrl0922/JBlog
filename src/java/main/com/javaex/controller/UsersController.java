package com.javaex.controller;

import javax.servlet.http.HttpSession;

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
	
	//회원가입 폼
	@RequestMapping(value="/joinForm", method= {RequestMethod.GET,RequestMethod.POST})
	public String joinForm() {
		System.out.println("UsersController-joinForm");
		return "user/joinForm";
	}
	
	//회원가입
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
	
	@RequestMapping(value="/loginForm", method = {RequestMethod.GET,RequestMethod.POST})
	public String loginForm() {
		System.out.println("UsersController-loginForm");
		return "user/loginForm";
	}
	
	//로그인
	@RequestMapping(value="/login", method = {RequestMethod.GET,RequestMethod.POST})
	public String login(@ModelAttribute UsersVo usersVo, HttpSession session) {
		System.out.println("UsersController-login");
		
		UsersVo authUser = usersService.login(usersVo);
		if(authUser != null) {
			System.out.println("login 성공");
			session.setAttribute("authUser", authUser);
			return "redirect:/";
		} else {
			System.out.println("login 실패");
			return "redirect:/user/loginForm?result=fail";
		}

	}
	
	//로그아웃
	@RequestMapping(value="/logout", method = {RequestMethod.GET,RequestMethod.POST})
	public String logout(HttpSession session) {
		System.out.println("UsersController-logout");
		
		session.getAttribute("authUser");
		session.removeAttribute("authUser");
		session.invalidate();
		
		return "redirect:/";
	}
	
}
