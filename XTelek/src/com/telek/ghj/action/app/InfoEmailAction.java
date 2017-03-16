package com.telek.ghj.action.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.telek.ghj.mail.MailMessage;
import com.telek.ghj.mail.SMTPClient;
import com.telek.ghj.tools.DataTools;
import com.telek.ghj.tools.OutTools;

public class InfoEmailAction extends HttpServlet {

	private static final long serialVersionUID = -5330587956211151245L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		String list=DataTools.nvl(request, "list", "");
		String subject=DataTools.nvl(request, "subject", "");
		String time=DataTools.nvl(request, "time", "");
		String locale=DataTools.nvl(request, "locale", "");
		String comment=DataTools.nvl(request, "comment", "");
		
		String list2=(String) list.subSequence(1,list.length()-1);
		String [] s=list2.split(",");
		
		for(int i=0;i<s.length;i++){
			MailMessage message = new MailMessage();
			message.setTo(new String[]{s[i]});
			message.setContent("时间为："+time+"\n"+"地点为："+locale+"\n"+comment);
			message.setSubject(subject);
			SMTPClient.sendEMail(message);
		}
		OutTools.printTEXT(response, "11");
	}

}
