package com.telek.ghj.dao;

import java.util.*;

import com.telek.ghj.mapping.TStation;


public interface StationDao {
	
	public long getTStationCount(String name) throws Exception;
	
	public List<TStation> getTStationList(String name,int begin,int length)throws Exception;
	
	public int deleteTStation(long id) throws Exception;
	
	public int addTStation(String stationname,String type,String address,long pnumber,String responsibility,String require) throws Exception;

	public int updateTStation(String stationname,String type,String address,long pnumber,String responsibility,String require,long stationid) throws Exception;

	public int check(String stationname,String address);
}
