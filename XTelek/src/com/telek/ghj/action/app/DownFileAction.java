package com.telek.ghj.action.app;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.telek.ghj.mapping.TUser;
import com.telek.ghj.service.AdminService;
import com.telek.ghj.tools.DataTools;

public class DownFileAction extends HttpServlet {

	private static final long serialVersionUID = -3051635884500686103L;

	private AdminService adminService=null;

	public AdminService getAdminService() {
		return adminService;
	}


	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email=DataTools.nvl(request, "email", "");
		
		try {
			List<TUser> list=adminService.downUser(email);
			TUser u=list.get(0);
			
			String path=u.getFilepath();
			String name=u.getRealname()+"的简历.doc";
			
			name=new String(name.getBytes("utf-8"),"ISO-8859-1");
			response.addHeader("Content-Disposition", "attachment;filename=\""+name+"\"");//浏览器使用什么名称保存下载文件
			
			FileInputStream fis=new FileInputStream(path);//输入流，负责读取文件。
			
			if(fis!=null){
				OutputStream out=response.getOutputStream();
				byte[] buff=new byte[1024];
				int bytesReader=0;
				while((bytesReader=fis.read(buff,0,buff.length))!=-1) {
					out.write(buff,0,bytesReader);
					out.flush();
				}
				out.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
