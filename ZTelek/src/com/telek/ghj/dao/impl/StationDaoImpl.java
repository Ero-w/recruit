package com.telek.ghj.dao.impl;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import com.telek.ghj.dao.StationDao;
import com.telek.ghj.mapping.TStation;

public class StationDaoImpl implements StationDao {

	private HibernateTemplate hibernateTemplate = null;
	
	@SuppressWarnings("unchecked")
	public List<TStation> getTstation(String nature, String keyword)
			throws Exception {


		List<TStation> list = hibernateTemplate.find(
				"from TStation s where s.type like '%'||?||'%' and s.stationname like '%'||?||'%'",
				new Object[] {nature, keyword });
		return list;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public TStation getPostion(long id) throws Exception {
		List<TStation> list= hibernateTemplate.find("from TStation s where s.stationid=?", new Object[]{id});
		return list.get(0);
	}
	
	

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}



}
