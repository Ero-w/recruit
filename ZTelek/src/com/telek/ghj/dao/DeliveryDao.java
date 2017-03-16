package com.telek.ghj.dao;

import java.util.List;

import com.telek.ghj.bean.DeliveryBean;

public interface DeliveryDao {
	
	/**
	 * 添加岗位列表
	 * @param userid
	 * @param stationid
	 * @return
	 * @throws Exception
	 */
	public int addDeliery(long userid,long stationid) throws Exception;
	
	/**
	 * 岗位列表
	 * @param userid
	 * @return
	 * @throws Exception
	 */
	public List<DeliveryBean> getDelivery(long userid)throws Exception;
	
	/**
	 * 删除岗位
	 * @param userid
	 * @return
	 * @throws Exception
	 */
	public int deleteDeliery(long userid) throws Exception;
	
}
