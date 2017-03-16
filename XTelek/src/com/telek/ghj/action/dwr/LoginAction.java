package com.telek.ghj.action.dwr;

import com.telek.ghj.service.AdminService;

public class LoginAction {
	
	private AdminService adminService=null;

	public LoginAction(){
		System.out.println("drw-login");
	}
	
	public int login(String name,String pass) throws Exception{
		return 1;
	}
	
	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

}
