package com.telek.ghj.action.app;

import java.io.IOException;
import java.net.UnknownHostException;

import com.telek.ghj.mail.MailMessage;
import com.telek.ghj.mail.SMTPClient;

public class Test {
	
	public static void main(String[] args) {
		String email="458348770@qq.com";
		String realname="干海杰";
		String content =realname+"！您的简历投递成功";
		String subject="简历投递成功";
		
		MailMessage message = new MailMessage();
		
		message.setTo(new String[]{email});
		message.setContent(content);
		message.setSubject(subject);
		
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

}
