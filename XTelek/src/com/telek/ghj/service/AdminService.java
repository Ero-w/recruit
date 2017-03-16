package com.telek.ghj.service;

import java.util.List;
import java.util.Map;

import com.telek.ghj.bean.UBean;
import com.telek.ghj.mapping.TUser;

public interface AdminService {
	public long login(String name,String password) throws Exception;

	public Map<String, Object> findStudentDataGrid(String nature,long page,long rows) throws Exception;
	
	public int updatePass(String oldword,String newword)throws Exception; 
	
	public List<TUser> downUser(String email) throws Exception;
	
}
