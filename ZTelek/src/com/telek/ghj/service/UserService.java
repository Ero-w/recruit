package com.telek.ghj.service;
import com.telek.ghj.bean.UserBean;

public interface UserService {
	public int addUser(String email,String password,String realname,String mobile,String sex,String school,String major) throws Exception; 

	public int login(String email,String password) throws Exception;
	
	public String getState(String email) throws Exception;
	
	public long getUserId(String email)throws Exception;
	
	public String getRealName(String email) throws Exception;
	
	public boolean isExist(String email)throws Exception;
	
	public UserBean getUser(String email) throws Exception;
	
	public int changeBasicUser(Long userid, String email,String realname,
			String mobile, String sex, String school,String major)throws Exception;

	public int changeUserPass(String email,String password)throws Exception;
	
	public int changeDetailUser(long userid,String place,String political,
			String birthday,String degree,String cet,String spring,String project,String practice)throws Exception;
	
	public int uploadFile(String email,String fileRealPath,String fileHttpPath) throws Exception;

	public int uploadPicture(String email,String HttpPath) throws Exception;
	
	public int getPictureState(String email) throws Exception;
}
