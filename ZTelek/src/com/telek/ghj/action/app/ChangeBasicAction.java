package com.telek.ghj.action.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.telek.ghj.service.UserService;
import com.telek.ghj.tools.DataTools;
import com.telek.ghj.tools.OutTools;

public class ChangeBasicAction extends HttpServlet {

	private static final long serialVersionUID = 980840882132795530L;
	
	private UserService userService=null;



	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		Long userid=DataTools.nvl(request, "userid", 0l);
		String email=DataTools.nvl(request, "email", "");
		String realname=DataTools.nvl(request, "realname", "");
		String mobile=DataTools.nvl(request, "mobile", "");
		String sex=DataTools.nvl(request, "sex", "");
		String school=DataTools.nvl(request, "school", "");
		String major=DataTools.nvl(request, "major", "");
		
		try {
			int i=userService.changeBasicUser(userid, email, realname, mobile, sex, school, major);
			if(i==1){
				OutTools.printTEXT(response, "true");
			}else{
				OutTools.printTEXT(response, "false");
			}
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
