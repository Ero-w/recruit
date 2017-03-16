package com.telek.ghj.dao.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.telek.ghj.bean.DeliveryBean;
import com.telek.ghj.dao.DeliveryDao;
import com.telek.ghj.mapping.*;


public class DeliveryDaoImpl implements DeliveryDao{

	private SessionFactory sessionFactory = null;

	private HibernateTemplate hibernateTemplate = null;
	
	public int addDeliery(long userid, long stationid) throws Exception {
		Session session=sessionFactory.openSession();
		Transaction tran=session.beginTransaction();
		
		TUser u=new TUser();
		u.setUserid(userid);
		TStation s=new TStation();
		s.setStationid(stationid);
		TDelivery d=new TDelivery();
		d.setTUser(u);		
		d.setTStation(s);
		d.setState(0L);
		session.save(d);
		tran.commit();
		session.close();
		return 1;
	}
	
	
	public int deleteDeliery(long userid) throws Exception {
		Session session=sessionFactory.openSession();
		Transaction tran=session.beginTransaction();
		
		Query query=session.createQuery("delete from TDelivery d where d.TUser.userid=?");
		query.setLong(0, userid);
		int i=query.executeUpdate();
		tran.commit();
		session.close();
		return i;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List<DeliveryBean> getDelivery(long userid) throws Exception {
		Session session=sessionFactory.openSession();
		SQLQuery query=session.createSQLQuery("select s.stationname,s.type,s.address,d.state " +
				"from t_user u,t_station s,t_delivery d " +
				"where d.userid=u.userid and d.stationid=s.stationid and u.userid=?");
		query.setLong(0, userid);
		query.addScalar("stationname", Hibernate.STRING);
		query.addScalar("type", Hibernate.STRING);
		query.addScalar("address", Hibernate.STRING);
		query.addScalar("state", Hibernate.STRING);
		query.setResultTransformer(Transformers.aliasToBean(DeliveryBean.class));
		List<DeliveryBean> list=query.list();
		session.close();
		if(list.size()>0){
			return list;
		}else{
			return null;
		}
		
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
