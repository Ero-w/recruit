package com.telek.ghj.dao;

import java.util.List;

import com.telek.ghj.mapping.TUser;

public interface UserDao {
	public int addUser(String email,String password,String realname,String mobile,String sex,String school,String major) throws Exception; 

	public int login(String email,String password) throws Exception;
	
	public String getState(String email) throws Exception;
	
	public String getRealName(String email) throws Exception;
	
	public long getUserId(String email)throws Exception;
	
	public int getName(String email) throws Exception;
	
	public int changeState(long userid) throws Exception;
	
	public int changBackState(long userid) throws Exception;
	
	public List<TUser> getUser(String email) throws Exception;
	
	public int changeBasicUser(Long userid, String email,String realname,
			String mobile, String sex, String school,String major)throws Exception;
	
	public int changeUserPass(String email,String npassword)throws Exception;
	
	public int changeDetailUser(long userid,String place,String political,
			String birthday,String degree,String cet,String spring,String project,String practice)throws Exception;
	
	/**
	 * 		String fileRealPath="";//文件的上传路径（文件的保存）
		String fileHttpPath="";//文件的下载路径（文件咋下载）
	 */
	public int uploadFile(String email,String fileRealPath,String fileHttpPath) throws Exception;
		
	public int uploadPicture(String email,String HttpPath) throws Exception;
	
}
