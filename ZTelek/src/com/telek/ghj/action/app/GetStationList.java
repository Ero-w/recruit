package com.telek.ghj.action.app;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.telek.ghj.mapping.TStation;
import com.telek.ghj.service.StationService;
import com.telek.ghj.tools.DataTools;
import com.telek.ghj.tools.OutTools;

public class GetStationList extends HttpServlet{

	private static final long serialVersionUID = 5525425862826153979L;

	private StationService stationService=null;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		request.setCharacterEncoding("utf-8");//设置服务器端接收客户端传递的数据的编码方式
		response.setCharacterEncoding("utf-8");//设置服务器端向客户端发送数据的编码方式(对应JSP的pageEncoding)
		response.setContentType("text/html;charset=utf-8");//设置当浏览器接收到数据时，识别的数据格式及其编码方式（对应JSP的contentType）
		
		
		String nature=DataTools.nvl(request, "nature", "");
		String keyword=DataTools.nvl(request, "keyword", "");
		
		try {
			List<TStation> list=stationService.getTstation(nature, keyword);
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("stationlist.jsp").forward(request, response);
		} catch (Exception e) {
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
