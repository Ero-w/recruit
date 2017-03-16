package com.telek.ghj.action.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.telek.ghj.service.StationService;
import com.telek.ghj.tools.DataTools;
import com.telek.ghj.tools.OutTools;

public class DeleteTStation extends HttpServlet {


	private static final long serialVersionUID = -5779293877377498133L;

	private StationService stationService=null;
	

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		String list = DataTools.nvl(request, "list", "");
		String list2=(String) list.subSequence(1,list.length()-1);
		String [] s=list2.split(",");
		for(int i=0;i<s.length;i++){
			try {
				stationService.deleteTStation(Integer.parseInt((s[i])));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		OutTools.printTEXT(response, "11");
	}
	
	public StationService getStationService() {
		return stationService;
	}


	public void setStationService(StationService stationService) {
		this.stationService = stationService;
	}

}
