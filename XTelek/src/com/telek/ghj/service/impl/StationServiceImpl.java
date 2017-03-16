package com.telek.ghj.service.impl;

import java.util.*;

import com.telek.ghj.dao.StationDao;
import com.telek.ghj.mapping.TStation;
import com.telek.ghj.mapping.TUser;
import com.telek.ghj.service.StationService;
import com.telek.ghj.tools.PageTools;

public class StationServiceImpl implements StationService{

	private StationDao stationDao;
	
	
	public StationDao getStationDao() {
		return stationDao;
	}

	public void setStationDao(StationDao stationDao) {
		this.stationDao = stationDao;
	}

	public Map<String, Object> getTStationList(String name,long page,long rows) throws Exception{
		long total=this.stationDao.getTStationCount(name);//查询获取分页的数据总量
		PageTools pageTools=new PageTools(page,rows,total); //计算查询分页信息
		
		List<TStation> list=stationDao.getTStationList(name, (int)pageTools.getBegin(), (int)pageTools.getRows());
		ArrayList<Object> arrayList = new ArrayList<Object>();
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> jsMap = new HashMap<String, Object>();
			jsMap.put("stationid",list.get(i).getStationid());
			jsMap.put("stationname",list.get(i).getStationname());
			jsMap.put("type",list.get(i).getType());
			jsMap.put("address",list.get(i).getAddress());
			jsMap.put("pnumber",list.get(i).getPnumber());
			jsMap.put("responsibility",list.get(i).getResponsibility());
			jsMap.put("require",list.get(i).getRequire());
			arrayList.add(jsMap);
		}
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", total);
		jsonMap.put("rows", arrayList);
		return jsonMap;		

	}
		

	public int deleteTStation(long id) throws Exception {
		return this.stationDao.deleteTStation(id);
	}

	public int addTStation(String stationname, String type, String address,
			long pnumber, String responsibility, String require)
			throws Exception {
		return this.stationDao.addTStation(stationname, type, address, pnumber, responsibility, require);
		
	}

	public int updateTStation(String stationname, String type, String address,
			long pnumber, String responsibility, String require,long stationid)
			throws Exception {
		return this.stationDao.updateTStation(stationname, type, address, pnumber, responsibility,require,stationid);
	}

	public boolean isAvilable(String stationname, String address)
			throws Exception {
		int i=this.stationDao.check(stationname, address);
		if(i==0){
			return true;
		}else{
			return false;
		}
	}





	
}
