package com.telek.ghj.service.impl;


import java.util.*;

import com.google.gson.Gson;
import com.telek.ghj.bean.*;
import com.telek.ghj.dao.AdminDao;
import com.telek.ghj.mapping.TStation;
import com.telek.ghj.mapping.TUser;
import com.telek.ghj.service.AdminService;
import com.telek.ghj.tools.PageTools;
public class AdminServiceImpl implements AdminService{
	
	private AdminDao adminDao;

	public long login(String name, String password) throws Exception{
		return this.adminDao.login(name, password);
	}
	
	

	public Map<String, Object> findStudentDataGrid(String nature, long page,
			long rows) throws Exception {
		// TODO Auto-generated method stub
		long total=this.adminDao.getStudentCount(nature);//查询获取分页的数据总量
		PageTools pageTools=new PageTools(page,rows,total); //计算查询分页信息
		
		List<TUser> list=adminDao.getUser(nature, (int)pageTools.getBegin(), (int)pageTools.getRows());
		ArrayList<Object> arrayList = new ArrayList<Object>();
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> jsMap = new HashMap<String, Object>();
			jsMap.put("userid",list.get(i).getUserid());
			jsMap.put("email",list.get(i).getEmail());
			jsMap.put("password",list.get(i).getPassword());
			jsMap.put("realname",list.get(i).getRealname());
			jsMap.put("mobile",list.get(i).getMobile());
			jsMap.put("sex",list.get(i).getSex());
			jsMap.put("school",list.get(i).getSchool());
			jsMap.put("major",list.get(i).getMajor());
			jsMap.put("degree",list.get(i).getDegree());
			jsMap.put("cet",list.get(i).getCet());
			jsMap.put("java",list.get(i).getJava());
			jsMap.put("html",list.get(i).getHtml());
			jsMap.put("spring",list.get(i).getSpring());
			jsMap.put("project",list.get(i).getProject());
			jsMap.put("practice",list.get(i).getPractice());
			jsMap.put("picture",list.get(i).getPicture());
			jsMap.put("filepath",list.get(i).getFilepath());
			jsMap.put("state",list.get(i).getState());
			jsMap.put("remark",list.get(i).getRemark());
			jsMap.put("place",list.get(i).getPlace());
			jsMap.put("political",list.get(i).getPolitical());
			jsMap.put("birthday",list.get(i).getBirthday());
			arrayList.add(jsMap);
		}
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", total);
		jsonMap.put("rows", arrayList);
		
		return jsonMap;		

	}
	
	
	public int updatePass(String oldword, String newword) throws Exception {
		return this.adminDao.updatePass(oldword, newword);
	}

	
	

	public List<TUser> downUser(String email) throws Exception {
		return this.adminDao.downUser(email);
	}


	
//	public String getJson(long roleid) throws Exception {
//		// TODO Auto-generated method stub
//		List<MenuBean> l=adminDao.getMenu(roleid);
//		MenuBean mb=l.get(0);
//		
//		List<Element> list=new LinkedList<Element>();
//		RootNode root=null;
//		ItemNode node=new ItemNode((mb.getPemoid()),mb.getPemoname().toString(),"icon-nav",mb.getUrl().toString());
//		list.add(new Element(node,mb.getBaseid()));
//
//		
//		for (int i=0;i<list.size();i++)
//		{
//			Element element=list.get(i);
//			for (int j=0;j<list.size();j++) {
//				if(element.getBaseid()==list.get(j).getNode().getMenuid()) {
//					list.get(j).getNode().addNode(element.getNode());
//					break;
//				}
//			}
//		}
//		Map<String, Object> jsonMap = new HashMap<String, Object>();
//		jsonMap.put("menus", root.getMenuid());
//		String json = new Gson().toJson(jsonMap);
//		return json;
//	}

	public AdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

}
