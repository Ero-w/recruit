package com.telek.ghj.ztest.service;

import java.io.IOException;
import java.net.UnknownHostException;

import org.junit.*;

import com.telek.ghj.mail.MailMessage;
import com.telek.ghj.mail.SMTPClient;

public class InfoTest {
	
	@Before
	public void before(){
		System.out.println("before");
	}
	
	
	@Test
	public void mailTest(){
		MailMessage message = new MailMessage();
		message.setTo(new String[]{"gan_h_j@163.com"});
		message.setContent("测试内容");
		message.setSubject("测试主题");
		try {
			SMTPClient.sendEMail(message);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	@After
	public void after(){
		System.out.println("after");
	}
}
