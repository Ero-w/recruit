package com.telek.ghj.action.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.telek.ghj.service.AdminService;
import com.telek.ghj.tools.OutTools;

public class LoginAction extends HttpServlet {


	private static final long serialVersionUID = -1049770406324861070L;

	private AdminService adminService=null;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name=request.getParameter("name");
		String pass=request.getParameter("password");
		
		
		try {
			long roleid = adminService.login(name, pass);
			if(roleid>0){
				HttpSession session=request.getSession(true);
				session.setAttribute("roleid",roleid);
				session.setAttribute("name",name);
				OutTools.printTEXT(response, 11);
			}else{
				OutTools.printTEXT(response, 00);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

}
