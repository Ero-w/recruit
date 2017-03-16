package com.telek.ghj.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.telek.ghj.dao.UserDao;
import com.telek.ghj.mapping.TUser;

public class UserDaoImpl implements UserDao {

	private SessionFactory sessionFactory = null;

	private HibernateTemplate hibernateTemplate = null;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public int addUser(String email, String password, String realname,
			String mobile, String sex, String school, String major)
			throws Exception {

		Session session = sessionFactory.openSession();
		Transaction tran = session.beginTransaction();

		TUser u = new TUser();
		u.setEmail(email);
		u.setPassword(password);
		u.setRealname(realname);
		u.setMobile(mobile);
		u.setSex(sex);
		u.setSchool(school);
		u.setMajor(major);
		u.setState("0");
		u.setRemark("0");
		u.setHtml("0");
		u.setJava("./picture/moren.png");

		session.save(u);
		tran.commit();
		session.close();
		return 1;
	}

	@SuppressWarnings("unchecked")
	public int login(String email, String password) throws Exception {
		List<TUser> list = hibernateTemplate.find(
				"from TUser u where u.email=? and u.password=?", new Object[] {
						email, password });
		if (list.size() == 1 && list.get(0) != null) {

			return 1;
		
		} else {
			return 0;
		}
	}
	
	@SuppressWarnings("unchecked")
	public String getState(String email) throws Exception {
		List<TUser> list=hibernateTemplate.find("from TUser u where u.email=?", new Object[]{email});
		
		if (list.size() == 1 && list.get(0) != null) {
			return list.get(0).getState();
		} else {
			return null;
		}
		
	}
	
	
	@SuppressWarnings("unchecked")
	public String getRealName(String email) throws Exception {
		List<TUser> list=hibernateTemplate.find("from TUser u where u.email=?", new Object[]{email});
		if (list.size() == 1 && list.get(0) != null) {
			return list.get(0).getRealname();
		} else {
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	public long getUserId(String email)throws Exception{
		List<TUser> list=hibernateTemplate.find("from TUser u where u.email=?", new Object[]{email});
		if (list.size() == 1 && list.get(0) != null) {
			return list.get(0).getUserid();
		} else {
			return 0;
		}
	}
	
	/**
	 * 是否存在重名
	 */
	@SuppressWarnings("unchecked")
	public int getName(String email) throws Exception {
		List<TUser> list=hibernateTemplate.find("from TUser u where u.email=?", new Object[]{email});
		if (list.size() == 1 && list.get(0) != null) {
			return 1;
		} else {
			return 0;
		}
	}
	
	/**
	 * 申请岗位
	 */
	public int changeState(long userid) throws Exception {
		int i=hibernateTemplate.bulkUpdate("update TUser u set u.state=1 where u.userid=?", new Object[]{userid});
		if(i>0){
			return 1;
		}else{
			return 0;
		}
	}

	/**
	 * 退回该岗位
	 */
	public int changBackState(long userid) throws Exception {
		int i=hibernateTemplate.bulkUpdate("update TUser u set u.state=0 where u.userid=?", new Object[]{userid});
		if(i>0){
			return 1;
		}else{
			return 0;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<TUser> getUser(String email) throws Exception {
		List<TUser> list=hibernateTemplate.find("from TUser u where u.email=?",new Object[]{email});
		if (list.size() == 1 && list.get(0) != null) {
			return list;
		} else {
			return null;
		}
	}

	public int changeBasicUser(Long userid, String email, String realname,
			String mobile, String sex, String school, String major)
			throws Exception {
		int i=hibernateTemplate.bulkUpdate("update TUser u set " +
				"u.email=?,u.realname=?,u.mobile=?,u.sex=?,u.school=?,u.major=? where u.userid=?",
				new Object[]{email,realname,mobile,sex,school,major,userid});
		if(i==1){
			return 1;
		}else{
			return 0;
		}
	}

	public int changeUserPass(String email, String npassword) throws Exception {
		int i=hibernateTemplate.bulkUpdate("update TUser u set u.password=? where u.email=?", new Object[]{npassword,email});
		if(i==1){
			return 1;
		}else{
			return 0;
		}
	}

	public int changeDetailUser(long userid, String place, String political,
			String birthday, String degree, String cet, String spring,
			String project, String practice)throws Exception {
		int i=hibernateTemplate.bulkUpdate("update TUser u set " +
				"u.place=?,u.political=?,u.birthday=?,u.degree=?,u.cet=?,u.spring=?,u.project=?,u.practice=? where u.userid=?", new Object[]{place,political,
				birthday,degree,cet,spring,project,practice,userid});
		if(i==1){
			return 1;
		}else{
			return 0;
		}
	}

	public int uploadFile(String email, String fileRealPath, String fileHttpPath)
			throws Exception {
		int i=hibernateTemplate.bulkUpdate("update TUser u set u.filepath=?,u.picture=?,u.remark=1 where u.email=?", new Object[]{fileRealPath,fileHttpPath,email});
		if(i==1){
			return 1;
		}else{
			return 0;
		}
	}

	public int uploadPicture(String email, String httpPath)
			throws Exception {
		int i=hibernateTemplate.bulkUpdate("update TUser u set u.java=?,u.html=1 where u.email=?",new Object[]{httpPath,email});
		if(i==1){
			return 1;
		}else{
			return 0;
		}
	}



}
