package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UsersVo;

@Repository
public class UsersDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//회원가입
	public int insert(UsersVo usersVo) {
		System.out.println("UsersDao-insert()");
		return sqlSession.insert("users.insert", usersVo);
	}
	
	//회원가입 아이디 체크
	public UsersVo selectOne(String id) {
		System.out.println("UsersDao-selectOne()");
		return sqlSession.selectOne("users.selectById", id);
	}
}
