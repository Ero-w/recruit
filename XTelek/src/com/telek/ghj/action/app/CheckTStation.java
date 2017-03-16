package com.telek.ghj.action.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.telek.ghj.service.StationService;
import com.telek.ghj.tools.DataTools;
import com.telek.ghj.tools.OutTools;

public class CheckTStation extends HttpServlet {


	private static final long serialVersionUID = 546860287275068712L;

	private StationService stationService=null;
	

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String stationname=DataTools.nvl(request, "stationname", "");
		String address=DataTools.nvl(request, "address", "");
		
		try {
			boolean b=this.stationService.isAvilable(stationname, address);
			if(b){
				OutTools.printTEXT(response, "11");
			}else{
				OutTools.printTEXT(response, "00");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public StationService getStationService() {
		return stationService;
	}


	public void setStationService(StationService stationService) {
		this.stationService = stationService;
	}


}
