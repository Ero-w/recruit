package com.telek.ghj.action.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.telek.ghj.service.TranService;
import com.telek.ghj.service.UserService;
import com.telek.ghj.tools.DataTools;
import com.telek.ghj.tools.OutTools;

public class BackAction extends HttpServlet {

	private static final long serialVersionUID = -6291789726967939104L;

	
	private TranService tranService=null;
	
	private UserService userService=null;
	


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
			long userid=DataTools.nvl(request, "userid", 0l);
			String email=DataTools.nvl(request, "email", "");
			try {
				int a=tranService.removeDelivery(userid);
				if(a==2){
					HttpSession session=request.getSession(true);
					session.setAttribute("state", "0");
					OutTools.printTEXT(response, "11");
				}{
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
