package com.telek.ghj.action.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.telek.ghj.service.UserService;
import com.telek.ghj.tools.DataTools;
import com.telek.ghj.tools.OutTools;


public class LoginAction extends HttpServlet {

	private UserService userService=null;
	

	private static final long serialVersionUID = -1049770406324861070L;

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request, response);
	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			String email=DataTools.nvl(request, "email", "");
			String password=DataTools.nvl(request, "password", "");
			
			try {
				int i=userService.login(email, password);
				if(i>0){
					String state=userService.getState(email);
					String realname=userService.getRealName(email);
					long userid=userService.getUserId(email);
					HttpSession session=request.getSession(true);
					session.setAttribute("email", email);
					session.setAttribute("realname", realname);
					session.setAttribute("state", state);
					session.setAttribute("userid", userid);
					OutTools.printTEXT(response, 11);
				}else{
					OutTools.printTEXT(response, 00);
				}
				
			} catch (Exception e) {
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
