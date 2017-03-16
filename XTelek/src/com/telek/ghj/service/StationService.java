package com.telek.ghj.service;



import java.util.*;

import com.telek.ghj.mapping.TStation;


public interface StationService {
	public Map<String, Object> getTStationList(String name,long page,long rows)throws Exception;
	
	public int deleteTStation(long id) throws Exception;
	
	public int addTStation(String stationname,String type,String address,long pnumber,String responsibility,String require) throws Exception;

	public int updateTStation(String stationname,String type,String address,long pnumber,String responsibility,String require,long stationid) throws Exception;

	public boolean isAvilable(String stationname,String address)throws Exception;
}
