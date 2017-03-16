package com.telek.ghj.service.impl;

import java.util.List;

import com.telek.ghj.bean.DeliveryBean;
import com.telek.ghj.dao.DeliveryDao;
import com.telek.ghj.service.DeliveryService;

public class DeliveryServiceImpl implements DeliveryService{

	private DeliveryDao deliveryDao;
	

	public List<DeliveryBean> getDelivery(long userid) throws Exception {
		// TODO Auto-generated method stub
		return this.deliveryDao.getDelivery(userid);
	}
	
	public DeliveryDao getDeliveryDao() {
		return deliveryDao;
	}

	public void setDeliveryDao(DeliveryDao deliveryDao) {
		this.deliveryDao = deliveryDao;
	}



}
