package com.telek.ghj.action.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LogOutAction extends HttpServlet {

	private static final long serialVersionUID = 6017250838118132231L;

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		
		if(session!=null&&session.getAttribute("roleid") != null
				&& !session.getAttribute("roleid").toString().equals("")){

			session.invalidate();
		}
		
		response.sendRedirect("login.jsp");
		
	}

}
