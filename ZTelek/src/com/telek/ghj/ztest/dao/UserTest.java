package com.telek.ghj.ztest.dao;

import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.telek.ghj.dao.UserDao;


public class UserTest {
	
	ApplicationContext ac=new FileSystemXmlApplicationContext("WebRoot/WEB-INF/cfg/applicationContext*.xml");
	UserDao userDao=(UserDao)ac.getBean("userDao");
	
	@Before
	public void before(){
		System.out.println("before");
	}
	
	@Test
	public void  doAdd(){
		
		String email="1";
		String password="2";
		String realname="3";
		String mobile="";
		String sex="男";
		String school="hdu";
		String major="ji";
		try {
			userDao.addUser(email, password, realname, mobile, sex, school, major);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@After
	public void after(){
		System.out.println("after");
	}
}
