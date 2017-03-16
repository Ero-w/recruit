package com.telek.ghj.service.impl;

import com.telek.ghj.dao.DeliveryDao;
import com.telek.ghj.dao.UserDao;
import com.telek.ghj.service.TranService;

public class TranServiceImpl implements TranService{

	private UserDao userDao;
	
	private DeliveryDao deliveryDao;
	
	
	public int execDelivery(long userid, long stationid) throws Exception {
		int i=this.userDao.changeState(userid);
		int j=this.deliveryDao.addDeliery(userid, stationid);
		if(i!=1 ||j!=1){
			throw new Exception("申请失败");
		}
		return i+j;
	}


	public int removeDelivery(long userid) throws Exception {
		int i=this.userDao.changBackState(userid);
		int j=this.deliveryDao.deleteDeliery(userid);
		if(i!=1||j!=1){
			throw new Exception("退档失败");
		}
		return i+j;
	}
	
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public DeliveryDao getDeliveryDao() {
		return deliveryDao;
	}

	public void setDeliveryDao(DeliveryDao deliveryDao) {
		this.deliveryDao = deliveryDao;
	}





	
}
