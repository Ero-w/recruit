package com.telek.ghj.action.app;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.telek.ghj.service.AdminService;
import com.telek.ghj.tools.DataTools;
import com.telek.ghj.tools.OutTools;

public class GetUserList extends HttpServlet{

	private static final long serialVersionUID = 5525425862826153979L;

	private AdminService adminService=null;
	


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		request.setCharacterEncoding("utf-8");//设置服务器端接收客户端传递的数据的编码方式
		response.setCharacterEncoding("utf-8");//设置服务器端向客户端发送数据的编码方式(对应JSP的pageEncoding)
		response.setContentType("text/html;charset=utf-8");//设置当浏览器接收到数据时，识别的数据格式及其编码方式（对应JSP的contentType）
		
		
		String keyword=DataTools.nvl(request, "school", "");
		long page=DataTools.nvl(request, "page", 1L);//接收并处理显示的当前页的信息
		long rows=DataTools.nvl(request, "rows",10L);//接收并处理每页显示的行数信息
		
		try {
			Map<String, Object> jsonMap=adminService.findStudentDataGrid(keyword, page, rows);
			OutTools.printJSON(response, jsonMap);//JSON格式输出
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
