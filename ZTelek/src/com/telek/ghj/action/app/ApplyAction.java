package com.telek.ghj.action.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.telek.ghj.mail.MailMessage;
import com.telek.ghj.mail.SMTPClient;
import com.telek.ghj.service.TranService;
import com.telek.ghj.service.UserService;
import com.telek.ghj.tools.DataTools;
import com.telek.ghj.tools.OutTools;

public class ApplyAction extends HttpServlet {

	private static final long serialVersionUID = 35248064910759090L;
	
	private TranService tranService;
	
	private UserService userService=null;
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			long userid=DataTools.nvl(request, "userid", 0l);
			long stationid=DataTools.nvl(request, "stationid",0l);
			
			String email=DataTools.nvl(request, "email", "");
			String realname=DataTools.nvl(request, "realname", "");
			String content =realname+"！您的简历投递成功";
			String subject="简历投递成功";
			MailMessage message = new MailMessage();
			
			
			message.setTo(new String[]{email});
			message.setContent(content);
			message.setSubject(subject);
			
			try {
				int a=tranService.execDelivery(userid, stationid);
				
				if(a==2){
					String state=userService.getState(email);
					HttpSession session=request.getSession(true);
					session.setAttribute("state", state); 
					SMTPClient.sendEMail(message);
					OutTools.printTEXT(response, "11");
				}else{
					OutTools.printTEXT(response, "00");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}
	
	public TranService getTranService() {
		return tranService;
	}


	public void setTranService(TranService tranService) {
		this.tranService = tranService;
	}


	public UserService getUserService() {
		return userService;
	}


	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
