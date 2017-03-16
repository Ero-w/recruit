package com.telek.ghj.dao;

import java.util.List;

import com.telek.ghj.bean.DeliverySituation;

public interface DeliveryDao {

	public long getDeliverySituationCount(String stationname) throws Exception;
	
	public List<DeliverySituation> getDeliverySituation(String stationname)throws Exception;
	
	
	public long getDeliveryCount(String stationname)throws Exception;
	
	public List<DeliverySituation> getDelivery(String stationname)throws Exception;
	
	
	public long getDelivery2Count(String stationname)throws Exception;
	
	public List<DeliverySituation> getDelivery2(String stationname)throws Exception;
	
	
	public int updateDelivery(String email) throws Exception;
	
	public int updateDelivery2(String email) throws Exception;
}
