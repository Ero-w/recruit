package com.telek.ghj.action.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.telek.ghj.mapping.TStation;
import com.telek.ghj.service.StationService;
import com.telek.ghj.tools.DataTools;

public class GetPositionAction extends HttpServlet{

	private static final long serialVersionUID = 8828746515882722165L;
	
	private StationService stationService=null;
	

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		long id=DataTools.nvl(request, "id", 0l);
		try {
			TStation tstation=stationService.getPostion(id);
			request.setAttribute("tstation", tstation);
			
			request.getRequestDispatcher("position.jsp").forward(request, response);
			
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
