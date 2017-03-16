package com.telek.ghj.service.impl;

import java.util.List;

import com.telek.ghj.dao.StationDao;
import com.telek.ghj.mapping.TStation;
import com.telek.ghj.service.StationService;

public class StationServiceImpl implements StationService{

	private StationDao stationDao;
	
	public List<TStation> getTstation(String nature, String keyword)
			throws Exception {
		return this.stationDao.getTstation(nature, keyword);

	}
	
	public TStation getPostion(long id) throws Exception {
		// TODO Auto-generated method stub
		return stationDao.getPostion(id);
	}
	
	
	public StationDao getStationDao() {
		return stationDao;
	}

	public void setStationDao(StationDao stationDao) {
		this.stationDao = stationDao;
	}



	
}
