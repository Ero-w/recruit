package com.telek.ghj.action.app;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.registry.infomodel.User;

import com.telek.ghj.bean.UserBean;
import com.telek.ghj.mapping.TUser;
import com.telek.ghj.service.UserService;
import com.telek.ghj.tools.DataTools;
import com.telek.ghj.tools.OutTools;

/**
 * 查询我得信息
 * 照片、文件 
 *
 */
public class GetUserAction  extends HttpServlet {

	private static final long serialVersionUID = 2770022338629395636L;

	private UserService userService=null;
	
	public UserService getUserService() {
		return userService;
	}


	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
			String email=DataTools.nvl(request, "email", "");
			try {
				UserBean user=userService.getUser(email);
				if(user!=null){
					OutTools.printJSON(response, user);
				}{
					OutTools.printJSON(response, null);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
		
	}

}
