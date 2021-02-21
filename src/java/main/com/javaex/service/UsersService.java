package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UsersDao;
import com.javaex.vo.UsersVo;

@Service
public class UsersService {

	@Autowired
	private UsersDao usersDao;
	
	//회원가입
	public int join(UsersVo usersVo) {
		System.out.println("UsersService-join");
		return usersDao.insert(usersVo);
	}
	
	//회원가입 아이디 체크
	public String idcheck(String id) {
		System.out.println("UsersService-idcheck()");
		UsersVo usersVo = usersDao.selectOne(id);
		String result="";
		
		if(usersVo==null) {
			//사용할수 있는 아이디
			result="can";
		}else {
			//중복아이디, 사용할 수 없는 아이디
			result="cant";
		}
		return result;
	}
}
