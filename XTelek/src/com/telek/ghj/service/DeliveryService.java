package com.telek.ghj.service;

import java.util.Map;


public interface DeliveryService {
	public Map<String, Object> getDeliverySituation(String stationname,long page,long rows)throws Exception;
	
	public Map<String, Object> getDelivery(String stationname,long page,long rows)throws Exception;
	
	public Map<String, Object> getDelivery2(String stationname,long page,long rows)throws Exception;
	
	public int updateDelivery(String email) throws Exception;
	
	public int updateDelivery2(String email) throws Exception;
}
