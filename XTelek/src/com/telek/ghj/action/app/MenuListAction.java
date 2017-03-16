package com.telek.ghj.action.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.telek.ghj.service.AdminService;
import com.telek.ghj.tools.OutTools;

public class MenuListAction extends HttpServlet {

//	private static final long serialVersionUID = 8900500315990181222L;
//	
//	private AdminService  adminService=null;
//
//	
//	public void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//			this.doPost(request, response);
//	}
//
//
//	public void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//			HttpSession session = request.getSession(false);
//		
//		if(session!=null&&session.getAttribute("roleid") != null
//				&& !session.getAttribute("roleid").toString().equals("")){
//			
//			long roleid = Long.parseLong(session.getAttribute("roleid")
//					.toString());
//	
//			try {
//				String json=adminService.getJson(roleid);
//				OutTools.printTEXT(response, json);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}
//	
//	
//	public AdminService getAdminService() {
//		return adminService;
//	}
//
//
//	public void setAdminService(AdminService adminService) {
//		this.adminService = adminService;
//	}
//

}
