package com.javaex.dao;

import org.springframework.beans.factory.annotation.Autowired;

public class BlogDao {

	@Autowired
	//private Sqlsession sqlSession;
	
	public void selectCheckId() {
		System.out.println("BlogDao-selectCheckId()");
	}

}
