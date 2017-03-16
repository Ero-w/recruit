package com.telek.ghj.service;

import java.util.List;

import com.telek.ghj.bean.DeliveryBean;

public interface DeliveryService {

	public List<DeliveryBean> getDelivery(long userid)throws Exception;
	
	
}
