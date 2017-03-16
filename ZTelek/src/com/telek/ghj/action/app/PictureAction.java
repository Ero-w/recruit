package com.telek.ghj.action.app;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.telek.ghj.service.UserService;

public class PictureAction  extends HttpServlet {


	private static final long serialVersionUID = 334242167726214907L;
	
	private UserService userService=null;




	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String email="";
		String uploadName="";//上传文件名称
		String fileRealPath="";//文件的上传路径（文件的保存）
		String fileHttpPath="";//文件的下载路径（文件咋下载）
		
		String zfileRealPath="";//文件的上传路径（文件的保存）后台
		String zfileHttpPath="";//文件的下载路径（文件咋下载）后台
		
		String HttpPath="";
		DiskFileItemFactory factory=new DiskFileItemFactory();//保存上传数据的对象（所有上传的数据）（缓存）
		
		factory.setSizeThreshold(1024*1024*50);//单位字节（设置允许在factory缓存中存储的数据最大值，如果超出这个最大值，系统将会将上传的内容缓存到磁盘文件）
		
		ServletFileUpload upload=new ServletFileUpload(factory);//获取上传数据的对象(按照一定的规则获取数据)（文件的读写格式）
		
		try {
			List<FileItem> list=upload.parseRequest(request);
			System.out.println(list.size());
			for(int i=0;i<list.size();i++){
				FileItem item=list.get(i);
				if (item.isFormField()) { //获取表单元素是否为文件上传标签
					//非文件上传
					if (item.getFieldName().equalsIgnoreCase("email")) {
						email= new String(item.getString().getBytes("ISO-8859-1"),"utf-8");
					} 
				} else {
					//是文件上传（文件大小，文件类型、文件名称处理）
					
					long size=item.getSize();//获取上传文件字节数
					uploadName=item.getName();//上传文件名
					
					//System.out.println(item.getName());//获取上传的文件名
					/* 如果忽略IE6浏览器，此代码可以省略
					String fileName=item.getName();//获取上传文件的文件名（IE6获取是路径,其它浏览器获取的只有文件名）
					String[] names=StringUtils.split(fileName,System.getProperty("file.separator"));//使用路径分割符进行字符串的拆分
					fileName=names[names.length-1];//获取文件名*/
					
					String fileExt=uploadName.substring(uploadName.lastIndexOf("."));
					
					Date date=new  Date(System.currentTimeMillis());//获取系统时间
					SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmmssSSS");
					String fileName=format.format(date);
					
					fileName=fileName+fileExt;
					
					fileRealPath="D:\\tomcat-6.0.18\\webapps\\ZTelek\\picture\\"+fileName;//文件上传路径
					fileHttpPath="E:\\workspace\\ZTelek\\WebRoot\\picture\\"+fileName;
					zfileRealPath="D:\\tomcat-6.0.18\\webapps\\XTelek\\picture\\"+fileName;//文件的上传路径（文件的保存）
					zfileHttpPath="E:\\workspace\\XTelek\\WebRoot\\picture\\"+fileName;//文件的下载路径（文件咋下载）
					
					
					HttpPath="./picture/"+fileName;//文件下载路径
					
					//System.out.println(getServletContext().getRealPath("/upload"));//获取存储上传文件的绝对路径
					item.write(new File(fileRealPath));//新建文件，写入上传的数据
					item.write(new File(fileHttpPath));
					item.write(new File(zfileRealPath));//新建文件，写入上传的数据
					item.write(new File(zfileHttpPath));
					//item.write(new File(fileHttpPath));
				}
			}
			int a=userService.uploadPicture(email, HttpPath);
			if(a==1){
				response.sendRedirect("center/manage.jsp");
			}else{
				response.sendRedirect("center/telek.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//加载request对象中的数据
		
	}

	public UserService getUserService() {
		return userService;
	}


	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
