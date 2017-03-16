package com.telek.ghj.dao;

import java.util.List;

import com.telek.ghj.bean.UBean;
import com.telek.ghj.mapping.TUser;

public interface AdminDao {
	public long login(String name,String password) throws Exception;
	
//	public List<MenuBean> getMenu(long roleid) throws Exception;
	
	public long getStudentCount(String keyword) throws Exception;
	
	public List<TUser> getUser(String keword,int begin,int length) throws Exception;
	
	public int updatePass(String oldword,String newword)throws Exception; 
	
	public List<TUser> downUser(String email) throws Exception;
	
	//public String getFilePath() throws Exception;
	
	public List<UBean> forInter() throws Exception;
	
	public int updateForInter(String email) throws Exception;  
}
