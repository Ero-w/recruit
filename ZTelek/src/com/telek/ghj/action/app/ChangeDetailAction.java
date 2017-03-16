package com.telek.ghj.action.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.telek.ghj.service.UserService;
import com.telek.ghj.tools.DataTools;
import com.telek.ghj.tools.OutTools;

public class ChangeDetailAction extends HttpServlet {

	private static final long serialVersionUID = 1865802837267319876L;

	private UserService userService=null;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
			
		long userid=DataTools.nvl(request, "userid", 0l);
		String place=DataTools.nvl(request, "place", "");
		String political=DataTools.nvl(request, "political","");
		String birthday=DataTools.nvl(request, "birthday", "");
		String degree=DataTools.nvl(request, "degree", "");
		String cet=DataTools.nvl(request, "cet","");
		String spring=DataTools.nvl(request, "spring", "");
		String project=DataTools.nvl(request, "project", "");
		String practice=DataTools.nvl(request, "practice", "");
		
		try {
			int i=userService.changeDetailUser(userid, place, political, birthday, degree, cet, spring, project, practice);
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
