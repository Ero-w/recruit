package com.telek.ghj.action.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutAction extends HttpServlet {

	private static final long serialVersionUID = -7512766140074737692L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			HttpSession session = request.getSession(false);
			
			if(session!=null&&session.getAttribute("realname") != null
					&& !session.getAttribute("realname").toString().equals("")){
				session.invalidate();
			}
				
			response.sendRedirect("telek.jsp");
		
		}
	}
