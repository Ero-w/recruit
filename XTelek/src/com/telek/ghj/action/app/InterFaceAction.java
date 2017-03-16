package com.telek.ghj.action.app;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.telek.ghj.service.TranService;
import com.telek.ghj.tools.OutTools;


public class InterFaceAction extends HttpServlet {


	private static final long serialVersionUID = 1373156049365843043L;
	
	
	private TranService tranService=null;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			try {
				Map<String, Object> jsonMap=tranService.ToInter();
				if(jsonMap!=null){
					OutTools.printJSON(response, jsonMap);
				}else{
					OutTools.printJSON(response, "暂时无数据");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public TranService getTranService() {
		return tranService;
	}


	public void setTranService(TranService tranService) {
		this.tranService = tranService;
	}

}
