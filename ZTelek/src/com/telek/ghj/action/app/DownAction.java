package com.telek.ghj.action.app;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.telek.ghj.bean.UserBean;
import com.telek.ghj.service.UserService;
import com.telek.ghj.tools.DataTools;

public class DownAction extends HttpServlet {


	private static final long serialVersionUID = -2385520522782406637L;

	
	private UserService userService=null;
	

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
			String email=DataTools.nvl(request, "email", "");
			
			try {
				UserBean u=this.userService.getUser(email);
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
	
	public UserService getUserService() {
		return userService;
	}


	public void setUserService(UserService userService) {
		this.userService = userService;
	}


}
