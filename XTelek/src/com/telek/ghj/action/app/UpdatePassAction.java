package com.telek.ghj.action.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.telek.ghj.service.AdminService;
import com.telek.ghj.tools.DataTools;
import com.telek.ghj.tools.OutTools;

public class UpdatePassAction extends HttpServlet {


	private static final long serialVersionUID = 8701238953148919667L;
	
	private AdminService adminService=null;



	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		String newPass=DataTools.nvl(request, "newPass", "");
		String oldPass=DataTools.nvl(request, "oldPass", "");
		
		HttpSession session = request.getSession(false);
		String name=session.getAttribute("name").toString();
		
		try {
			long i=adminService.login(name, oldPass);
			if(i!=0){
				adminService.updatePass(oldPass, newPass);
				OutTools.printTEXT(response, "ok");
			}else{
				OutTools.printTEXT(response, "false");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
