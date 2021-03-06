package com.telek.ghj.action.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.telek.ghj.service.StationService;
import com.telek.ghj.tools.DataTools;
import com.telek.ghj.tools.OutTools;

public class UpdateTStation extends  HttpServlet {


	private static final long serialVersionUID = -7591658920887510321L;

	private StationService stationService=null;
	

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		long stationid=DataTools.nvl(request, "stationid", 0l);
		String stationname=DataTools.nvl(request, "stationname2", "");
		String type=DataTools.nvl(request, "type", "");
		String address=DataTools.nvl(request, "address", "");
		long pnumber=DataTools.nvl(request, "pnumber", 0l);
		String responsibility=DataTools.nvl(request, "responsibility", "");
		String require=DataTools.nvl(request, "require", "");
		
		try {
			int i=this.stationService.updateTStation(stationname, type, address, pnumber, responsibility, require,stationid);
			if(i==1){
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
