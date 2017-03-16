package com.telek.ghj.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import com.telek.ghj.bean.UBean;
import com.telek.ghj.dao.AdminDao;
import com.telek.ghj.service.TranService;

public class TranServiceImpl implements TranService {

	private AdminDao adminDao=null;

	public Map<String, Object> ToInter() throws Exception {
		List<UBean> list=this.adminDao.forInter();
		int sum=0;
		for(int i=0;i<list.size();i++){
			int a=this.adminDao.updateForInter(list.get(i).getEmail());
			sum=sum+a;
		}
		
		ArrayList<Object> arrayList = new ArrayList<Object>();
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> jsMap = new HashMap<String, Object>();
			jsMap.put("email",list.get(i).getEmail());
			jsMap.put("realname",list.get(i).getRealname());
			jsMap.put("mobile",list.get(i).getMobile());
			jsMap.put("sex",list.get(i).getSex());
			jsMap.put("school",list.get(i).getSchool());
			jsMap.put("major",list.get(i).getMajor());
			jsMap.put("degree",list.get(i).getDegree());
			jsMap.put("place",list.get(i).getPlace());
			jsMap.put("birthday",list.get(i).getBirthday());
			jsMap.put("political",list.get(i).getPolitical());
			arrayList.add(jsMap);
		}
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("sum", sum);
		jsonMap.put("list", arrayList);
		return jsonMap;		
	}

	
	public AdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}



}
