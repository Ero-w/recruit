package com.telek.ghj.dao.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.telek.ghj.bean.DeliverySituation;
import com.telek.ghj.bean.UBean;
import com.telek.ghj.dao.AdminDao;
import com.telek.ghj.mapping.TAdmin;
import com.telek.ghj.mapping.TUser;


public class AdminDaoImpl implements AdminDao {

	private HibernateTemplate hibernateTemplate = null;

	private SessionFactory sessionFactory = null;


	@SuppressWarnings("unchecked")
	public long login(String name, String password) throws Exception {
		List<TAdmin> list=this.hibernateTemplate.find("from TAdmin a where a.name=? and a.password=?", new Object[]{name,password});
		if (list.size() == 1 && list.get(0) != null) {
			return list.get(0).getTRole().getRoleid();
		} else {
			return 0l;
		}
	}
	

	
	@SuppressWarnings("unchecked")
	public long getStudentCount(String keyword) throws Exception {
		List<TUser> list=this.hibernateTemplate.find("from TUser u where u.school like '%'||?||'%'",new Object[]{keyword});
		return list.size();
	}

	@SuppressWarnings("unchecked")
	public List<TUser> getUser(String keword, int begin, int length)
			throws Exception {
		Session session=sessionFactory.openSession();
		Query qeury=session.createQuery("from TUser u where u.school like '%'||?||'%'");
		qeury.setString(0, keword);
		qeury.setFirstResult(begin-1);
		qeury.setMaxResults(length);
		List<TUser> list=qeury.list();
		session.close();
		return list;
	}
	
	public int updatePass(String oldword, String newword) throws Exception {
		int i=hibernateTemplate.bulkUpdate("update TAdmin a set a.password=?", new Object[]{newword});
		return i;
	}
	

	@SuppressWarnings("unchecked")
	public List<TUser> downUser(String email) throws Exception {
		List<TUser> list=hibernateTemplate.find("from TUser u where u.email=?", new Object[]{email});
		return list;
	}
	
	
	

	@SuppressWarnings("unchecked")
	public List<UBean> forInter() throws Exception {
		Session session=sessionFactory.openSession();
		SQLQuery query=session.createSQLQuery("select u.email,u.realname,u.mobile,u.sex,u.school,u.major,u.degree,u.place,u.birthday,u.political" +
				" from t_user u,t_delivery d where u.userid=d.userid and d.state=2");
		query.addScalar("email", Hibernate.STRING);
		query.addScalar("realname", Hibernate.STRING);
		query.addScalar("mobile", Hibernate.STRING);
		query.addScalar("sex", Hibernate.STRING);
		query.addScalar("major", Hibernate.STRING);
		query.addScalar("degree", Hibernate.STRING);
		query.addScalar("place", Hibernate.STRING);
		query.addScalar("birthday", Hibernate.STRING);
		query.addScalar("political", Hibernate.STRING);
		query.setResultTransformer(Transformers.aliasToBean(UBean.class));
		List<UBean> list=query.list();
		session.close();
		return list;
	}

	public int updateForInter(String email) throws Exception {
		Session session=sessionFactory.openSession();
		SQLQuery query=session.createSQLQuery("update t_delivery d set d.state=3 where d.userid=(select u.userid  from t_user u where u.email=?)");
		query.setString(0, email);
		int i =query.executeUpdate();
		session.close();
		return i;	
	}
	
//	@SuppressWarnings("unchecked")
//	public List<MenuBean> getMenu(long roleid) throws Exception {
//		Session session = sessionFactory.openSession();
//		SQLQuery query=session.createSQLQuery("slect level,pemoid,pemoname,nvl(baseid,0) baseid,url FROM (select th.*,tp.pemoname,nvl(tp.baseid,0) baseid ,url from (select tr.*,trp.pemoid from  t_role tr join t_role_pemo trp  on tr.roleid=trp.roleid) th join t_pemo tp on  th.pemoid=tp.pemoid and roleid=?) ty START WITH pemoid=? CONNECT BY PRIOR pemoid=baseid");
//		query.setLong(0, roleid);
//		query.setLong(1, 1);
//		
//		query.addScalar("level",Hibernate.STRING);
//		query.addScalar("pemoid",Hibernate.LONG);
//		query.addScalar("pemoname",Hibernate.STRING);
//		query.addScalar("baseid",Hibernate.LONG);
//		query.addScalar("url",Hibernate.STRING);
//		query.setResultTransformer(Transformers.aliasToBean(MenuBean.class));
//		List<MenuBean> list=query.list();
//		if(list.size()>0){
//			return list;
//		}else{
//			return null;
//		}
//	}
//	
	
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}






}
