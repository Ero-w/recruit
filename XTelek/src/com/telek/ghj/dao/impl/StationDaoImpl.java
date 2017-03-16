package com.telek.ghj.dao.impl;

import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import com.telek.ghj.dao.StationDao;
import com.telek.ghj.mapping.TStation;

public class StationDaoImpl implements StationDao {

	private HibernateTemplate hibernateTemplate = null;
	
	private SessionFactory sessionFactory=null;


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



	public int deleteTStation(long id) throws Exception {
		TStation s=new TStation();
		s.setStationid(id);
		this.hibernateTemplate.delete(s);
		return 1;
	}

	public int addTStation(String stationname, String type, String address,
			long pnumber, String responsibility, String require)
			throws Exception {
		TStation s=new TStation();
		s.setStationname(stationname);
		s.setType(type);
		s.setAddress(address);
		s.setPnumber(pnumber);
		s.setResponsibility(responsibility);
		s.setRequire(require);
		hibernateTemplate.save(s);
		return 1;
	}

	public int updateTStation(String stationname, String type, String address,
			long pnumber, String responsibility, String require,long stationid)
			throws Exception {
		int i=this.hibernateTemplate.bulkUpdate("update TStation s set" +
				" s.stationname=?,s.type=?,s.address=?,s.pnumber=?,s.responsibility=?,s.require=?" +
				"where s.stationid=?",
				new Object[]{stationname,type,address,pnumber,responsibility,require,stationid});
		return i;
	}

	@SuppressWarnings("unchecked")
	public int check(String stationname, String address) {
		List<TStation> list=this.hibernateTemplate.find("from TStation s where s.stationname=? and s.address=?",new Object[]{stationname,address});
		if(list.size()>0){
			return 1;
		}else{
			return 0;
		}
	}

	@SuppressWarnings("unchecked")
	public long getTStationCount(String name) throws Exception {
		List<TStation> list=this.hibernateTemplate.find("from TStation s where s.stationname like '%'||?||'%'", new Object[]{name});
		 return list.size();
	}

	@SuppressWarnings("unchecked")
	public List<TStation> getTStationList(String name, int begin, int length)
			throws Exception {
		Session session=sessionFactory.openSession();
		Query qeury=session.createQuery("from TStation s where s.stationname like '%'||?||'%'");
		qeury.setString(0, name);
		qeury.setFirstResult(begin-1);
		qeury.setMaxResults(length);
		List<TStation> list=qeury.list();
		session.close();
		return list;
	}
	
}
