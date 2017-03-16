package com.telek.ghj.action.app;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.telek.ghj.bean.DeliveryBean;
import com.telek.ghj.service.DeliveryService;
import com.telek.ghj.tools.DataTools;
import com.telek.ghj.tools.OutTools;

public class GetStationAction extends HttpServlet {


	private static final long serialVersionUID = -2709223625296893926L;
	
	private DeliveryService deliveryService=null;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
			long userid=DataTools.nvl(request, "userid", 0l);
			
			try {
				List<DeliveryBean> list=this.deliveryService.getDelivery(userid);
				if(list!=null&&list.size()>0){
					DeliveryBean deliveryBean=list.get(0);
					OutTools.printJSON(response, deliveryBean);
				}else{
					OutTools.printTEXT(response, "false");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
	}
	
	
	public DeliveryService getDeliveryService() {
		return deliveryService;
	}


	public void setDeliveryService(DeliveryService deliveryService) {
		this.deliveryService = deliveryService;
	}

}
