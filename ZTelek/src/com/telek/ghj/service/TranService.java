package com.telek.ghj.service;


public interface TranService {
	
	/**
	 * 修改简历和插入一条投递表
	 */
	public int execDelivery(long userid,long stationid) throws Exception;
	
	public int removeDelivery(long userid) throws Exception;
}
