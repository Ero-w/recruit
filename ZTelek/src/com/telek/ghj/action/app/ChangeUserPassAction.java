package com.telek.ghj.action.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.telek.ghj.service.UserService;
import com.telek.ghj.tools.DataTools;
import com.telek.ghj.tools.OutTools;

public class ChangeUserPassAction extends HttpServlet {


	private static final long serialVersionUID = 5963497094129906211L;

	
	private UserService userService=null;
	
	


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			String email=DataTools.nvl(request, "email", "");
			String password=DataTools.nvl(request, "password", "");
			String npassword=DataTools.nvl(request, "newpass", "");
			
			
			try {
				int i=this.userService.login(email, password);
				if(i==1){
					int j=userService.changeUserPass(email, npassword);
					if(j==1){
						OutTools.printTEXT(response, "true");
					}else{
						OutTools.printTEXT(response, "false");
					}
				}else{
					OutTools.printTEXT(response, "error");
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
