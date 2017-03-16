package com.telek.ghj.dao.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.telek.ghj.bean.DeliverySituation;
import com.telek.ghj.dao.DeliveryDao;

public class DeliveryDaoImpl implements DeliveryDao{

	private SessionFactory sessionFactory=null;	
	
	private HibernateTemplate hibernateTemplate=null;


	@SuppressWarnings("unchecked")
	public long getDeliverySituationCount(String stationname) throws Exception {
		Session session=sessionFactory.openSession();
		SQLQuery query=session.createSQLQuery("select s.stationname,s.address,u.email,u.realname,u.mobile,u.filepath " +
				"from t_user u,t_station s,t_delivery d " +
				"where d.userid=u.userid and d.stationid=s.stationid and d.state=0 and s.stationname like '%'||?||'%'");
		query.setString(0, stationname);
		query.addScalar("stationname", Hibernate.STRING);
		query.addScalar("address", Hibernate.STRING);
		query.addScalar("email", Hibernate.STRING);
		query.addScalar("realname", Hibernate.STRING);
		query.addScalar("mobile", Hibernate.STRING);
		query.addScalar("filepath", Hibernate.STRING);
		query.setResultTransformer(Transformers.aliasToBean(DeliverySituation.class));//执行部SQL查询结果持久化类(JavaBean)
		List<DeliverySituation> list=query.list();
		session.close();
		return list.size();
	}




	@SuppressWarnings("unchecked")
	public List<DeliverySituation> getDeliverySituation(String stationname)
			throws Exception {
			Session session=sessionFactory.openSession();
			SQLQuery query=session.createSQLQuery("select s.stationname,s.address,u.email,u.realname,u.mobile,u.filepath " +
					"from t_user u,t_station s,t_delivery d " +
					"where d.userid=u.userid and d.stationid=s.stationid and d.state=0 and s.stationname like '%'||?||'%'");
			query.setString(0, stationname);
			query.addScalar("stationname", Hibernate.STRING);
			query.addScalar("address", Hibernate.STRING);
			query.addScalar("email", Hibernate.STRING);
			query.addScalar("realname", Hibernate.STRING);
			query.addScalar("mobile", Hibernate.STRING);
			query.addScalar("filepath", Hibernate.STRING);
			query.setResultTransformer(Transformers.aliasToBean(DeliverySituation.class));//执行部SQL查询结果持久化类(JavaBean)
			List<DeliverySituation> list=query.list();
			session.close();
			return list;
	}

	
	
	@SuppressWarnings("unchecked")
	public long getDeliveryCount(String stationname) throws Exception {
		Session session=sessionFactory.openSession();
		SQLQuery query=session.createSQLQuery("select s.stationname,s.address,u.email,u.realname,u.mobile,u.filepath " +
				"from t_user u,t_station s,t_delivery d " +
				"where d.userid=u.userid and d.stationid=s.stationid and d.state=1 and s.stationname like '%'||?||'%'");
		query.setString(0, stationname);
		query.addScalar("stationname", Hibernate.STRING);
		query.addScalar("address", Hibernate.STRING);
		query.addScalar("email", Hibernate.STRING);
		query.addScalar("realname", Hibernate.STRING);
		query.addScalar("mobile", Hibernate.STRING);
		query.addScalar("filepath", Hibernate.STRING);
		query.setResultTransformer(Transformers.aliasToBean(DeliverySituation.class));//执行部SQL查询结果持久化类(JavaBean)
		List<DeliverySituation> list=query.list();
		session.close();
		return list.size();
	}
	
	@SuppressWarnings("unchecked")
	public List<DeliverySituation> getDelivery(String stationname)
			throws Exception {
		Session session=sessionFactory.openSession();
		SQLQuery query=session.createSQLQuery("select s.stationname,s.address,u.email,u.realname,u.mobile,u.filepath " +
				"from t_user u,t_station s,t_delivery d " +
				"where d.userid=u.userid and d.stationid=s.stationid and d.state=1 and s.stationname like '%'||?||'%'");
		query.setString(0, stationname);
		query.addScalar("stationname", Hibernate.STRING);
		query.addScalar("address", Hibernate.STRING);
		query.addScalar("email", Hibernate.STRING);
		query.addScalar("realname", Hibernate.STRING);
		query.addScalar("mobile", Hibernate.STRING);
		query.addScalar("filepath", Hibernate.STRING);
		query.setResultTransformer(Transformers.aliasToBean(DeliverySituation.class));//执行部SQL查询结果持久化类(JavaBean)
		List<DeliverySituation> list=query.list();
		session.close();
		return list;
	}
	
	
	@SuppressWarnings("unchecked")
	public long getDelivery2Count(String stationname) throws Exception {
		Session session=sessionFactory.openSession();
		SQLQuery query=session.createSQLQuery("select s.stationname,s.address,u.email,u.realname,u.mobile,u.filepath " +
				"from t_user u,t_station s,t_delivery d " +
				"where d.userid=u.userid and d.stationid=s.stationid and d.state=2 and s.stationname like '%'||?||'%'");
		query.setString(0, stationname);
		query.addScalar("stationname", Hibernate.STRING);
		query.addScalar("address", Hibernate.STRING);
		query.addScalar("email", Hibernate.STRING);
		query.addScalar("realname", Hibernate.STRING);
		query.addScalar("mobile", Hibernate.STRING);
		query.addScalar("filepath", Hibernate.STRING);
		query.setResultTransformer(Transformers.aliasToBean(DeliverySituation.class));//执行部SQL查询结果持久化类(JavaBean)
		List<DeliverySituation> list=query.list();
		session.close();
		return list.size();
	}
	
	@SuppressWarnings("unchecked")
	public List<DeliverySituation> getDelivery2(String stationname)
			throws Exception {
		Session session=sessionFactory.openSession();
		SQLQuery query=session.createSQLQuery("select s.stationname,s.address,u.email,u.realname,u.mobile,u.filepath " +
				"from t_user u,t_station s,t_delivery d " +
				"where d.userid=u.userid and d.stationid=s.stationid and d.state=2 and s.stationname like '%'||?||'%'");
		query.setString(0, stationname);
		query.addScalar("stationname", Hibernate.STRING);
		query.addScalar("address", Hibernate.STRING);
		query.addScalar("email", Hibernate.STRING);
		query.addScalar("realname", Hibernate.STRING);
		query.addScalar("mobile", Hibernate.STRING);
		query.addScalar("filepath", Hibernate.STRING);
		query.setResultTransformer(Transformers.aliasToBean(DeliverySituation.class));//执行部SQL查询结果持久化类(JavaBean)
		List<DeliverySituation> list=query.list();
		session.close();
		return list;
	}
	

	
	public int updateDelivery(String email) throws Exception {
		Session session=sessionFactory.openSession();
		SQLQuery query=session.createSQLQuery("update t_delivery d set d.state=1 where d.userid=(select u.userid  from t_user u where u.email=?)");
		query.setString(0, email);
		int i =query.executeUpdate();
		session.close();
		return i;
	}
	
	
	public int updateDelivery2(String email) throws Exception {
		Session session=sessionFactory.openSession();
		SQLQuery query=session.createSQLQuery("update t_delivery d set d.state=2 where d.userid=(select u.userid  from t_user u where u.email=?)");
		query.setString(0, email);
		int i =query.executeUpdate();
		session.close();
		return i;
	}
	
	
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








}
