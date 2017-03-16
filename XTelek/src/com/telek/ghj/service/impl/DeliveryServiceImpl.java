package com.telek.ghj.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.telek.ghj.bean.DeliverySituation;
import com.telek.ghj.dao.DeliveryDao;
import com.telek.ghj.service.DeliveryService;
import com.telek.ghj.tools.PageTools;

public class DeliveryServiceImpl implements DeliveryService{

	private DeliveryDao deliveryDao=null;
	


	@SuppressWarnings("unused")
	public Map<String, Object> getDeliverySituation(String stationname,long page,long rows)
			throws Exception {
		long total=this.deliveryDao.getDeliverySituationCount(stationname);
		PageTools pageTools=new PageTools(page,rows,total);
		List<DeliverySituation> list=this.deliveryDao.getDeliverySituation(stationname);
		ArrayList<Object> arrayList = new ArrayList<Object>();
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> jsMap = new HashMap<String, Object>();
			jsMap.put("stationname",list.get(i).getStationname());
			jsMap.put("address",list.get(i).getAddress());
			jsMap.put("email",list.get(i).getEmail());
			jsMap.put("realname",list.get(i).getRealname());
			jsMap.put("mobile",list.get(i).getMobile());
			jsMap.put("filepath",list.get(i).getFilepath());
			arrayList.add(jsMap);
		}
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", total);
		jsonMap.put("rows", arrayList);
		return jsonMap;		
	}
	
	
	public Map<String, Object> getDelivery(String stationname,long page,long rows) throws Exception {
		long total=this.deliveryDao.getDeliveryCount(stationname);
		PageTools pageTools=new PageTools(page,rows,total);
		List<DeliverySituation> list=this.deliveryDao.getDelivery(stationname);
		ArrayList<Object> arrayList = new ArrayList<Object>();
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> jsMap = new HashMap<String, Object>();
			jsMap.put("stationname",list.get(i).getStationname());
			jsMap.put("address",list.get(i).getAddress());
			jsMap.put("email",list.get(i).getEmail());
			jsMap.put("realname",list.get(i).getRealname());
			jsMap.put("mobile",list.get(i).getMobile());
			jsMap.put("filepath",list.get(i).getFilepath());
			arrayList.add(jsMap);
		}
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", total);
		jsonMap.put("rows", arrayList);
		return jsonMap;		
	}
	
	
	public Map<String, Object> getDelivery2(String stationname,long page,long rows) throws Exception {
		long total=this.deliveryDao.getDelivery2Count(stationname);
		PageTools pageTools=new PageTools(page,rows,total);
		List<DeliverySituation> list=this.deliveryDao.getDelivery2(stationname);
		ArrayList<Object> arrayList = new ArrayList<Object>();
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> jsMap = new HashMap<String, Object>();
			jsMap.put("stationname",list.get(i).getStationname());
			jsMap.put("address",list.get(i).getAddress());
			jsMap.put("email",list.get(i).getEmail());
			jsMap.put("realname",list.get(i).getRealname());
			jsMap.put("mobile",list.get(i).getMobile());
			jsMap.put("filepath",list.get(i).getFilepath());
			arrayList.add(jsMap);
		}
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		jsonMap.put("total", total);
		jsonMap.put("rows", arrayList);
		return jsonMap;		
	}
	
	
	public int updateDelivery(String email) throws Exception {
		return this.deliveryDao.updateDelivery(email);
	}
	
	public int updateDelivery2(String email) throws Exception {
		return this.deliveryDao.updateDelivery2(email);
	}
	
	
	public DeliveryDao getDeliveryDao() {
		return deliveryDao;
	}

	public void setDeliveryDao(DeliveryDao deliveryDao) {
		this.deliveryDao = deliveryDao;
	}







}
