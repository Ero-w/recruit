package com.telek.ghj.action.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.telek.ghj.service.UserService;
import com.telek.ghj.tools.DataTools;

public class RegisterAction extends HttpServlet{

	private static final long serialVersionUID = 1925175958774674280L;
	
	private UserService userService=null;
	

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
			String email=DataTools.nvl(request, "email", "");
			String	password=DataTools.nvl(request, "password", "");
			String realname=DataTools.nvl(request, "realname", "");
			String mobile=DataTools.nvl(request, "mobile", "");
			String sex=DataTools.nvl(request, "sex", "");
			String school=DataTools.nvl(request, "school", "");
			String major=DataTools.nvl(request, "major", "");
		
			try {
				userService.addUser(email, password, realname, mobile, sex, school, major);
				Thread.sleep(1000);
				response.sendRedirect("login.jsp");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}
