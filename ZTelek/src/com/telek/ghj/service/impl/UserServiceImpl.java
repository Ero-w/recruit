package com.telek.ghj.service.impl;


import java.util.List;

import com.telek.ghj.bean.UserBean;
import com.telek.ghj.dao.UserDao;
import com.telek.ghj.mapping.TUser;
import com.telek.ghj.service.UserService;
import com.telek.ghj.util.Log;
import com.telek.ghj.util.LogType;

public class UserServiceImpl implements UserService{

	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public int addUser(String email, String password, String realname,
			String mobile, String sex, String school, String major)
			throws Exception {
			this.userDao.addUser(email, password, realname, mobile, sex, school, major);
			return 1;
	}
	
	public int login(String email, String password) throws Exception {
		 return this.userDao.login(email, password);
	}
	
	
	public String getState(String email) throws Exception {
		return this.userDao.getState(email);
	}

	public String getRealName(String email) throws Exception {
		return this.userDao.getRealName(email);
	}

	
	public boolean isExist(String email) throws Exception {
		// TODO Auto-generated method stub
		int i=this.userDao.getName(email);
		if(i==0){
			return true;
		}else{
			return false;
		}

	}
	
	public long getUserId(String email)throws Exception{
		return this.userDao.getUserId(email);
	}
	


	public UserBean getUser(String email) throws Exception {
		List<TUser> list=this.userDao.getUser(email);
		if(list.size()==1){
			TUser u=list.get(0);
			UserBean user=new UserBean(
					u.getUserid(),
					u.getEmail(),
					u.getPassword(),
					u.getRealname(),
					u.getMobile(),
					u.getSex(),
					u.getSchool(),
					u.getMajor(),
					u.getDegree(),
					u.getCet(),
					u.getJava(),
					u.getHtml(),
					u.getSpring(),
					u.getProject(),
					u.getPractice(),
					u.getPicture(),
					u.getFilepath(),
					u.getState(),
					u.getRemark(),
					u.getPlace(),
					u.getPolitical(),
					u.getBirthday());
			return user;
		}else{
			return null;
		}
	}

	public int changeBasicUser(Long userid, String email, String realname,
			String mobile, String sex, String school, String major)
			throws Exception {
		return this.userDao.changeBasicUser(userid, email, realname, mobile, sex, school, major);
	}

	public int changeUserPass(String email, String password) throws Exception {
		return this.userDao.changeUserPass(email, password);
	}

	public int changeDetailUser(long userid, String place, String political,
			String birthday, String degree, String cet, String spring,
			String project, String practice) throws Exception {
		return this.userDao.changeDetailUser(userid, place, political, birthday, degree, cet, spring, project, practice);
	}

	public int uploadFile(String email,String fileRealPath,String fileHttpPath) throws Exception{
		return this.userDao.uploadFile(email, fileRealPath, fileHttpPath);
	}

	public int uploadPicture(String email, String HttpPath) throws Exception {
		return this.userDao.uploadPicture(email, HttpPath);
	}

	public int getPictureState(String email) throws Exception {
		List<TUser> list=this.userDao.getUser(email);
		int i=new Integer(list.get(0).getHtml());
		return i;
	}
}
