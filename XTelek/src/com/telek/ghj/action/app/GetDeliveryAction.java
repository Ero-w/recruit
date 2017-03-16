package com.telek.ghj.action.app;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.telek.ghj.service.DeliveryService;
import com.telek.ghj.tools.DataTools;
import com.telek.ghj.tools.OutTools;

public class GetDeliveryAction extends HttpServlet {
	

	private static final long serialVersionUID = 8163858253326857202L;

	private DeliveryService deliveryService=null;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
			String stationname=DataTools.nvl(request, "stationname", "");
			long page=DataTools.nvl(request, "page", 1L);//接收并处理显示的当前页的信息
			long rows=DataTools.nvl(request, "rows",10L);//接收并处理每页显示的行数信息
			try {
				Map<String, Object> jsonMap=deliveryService.getDelivery(stationname,page,rows);
				OutTools.printJSON(response, jsonMap);//JSON格式输出
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
