package com.telek.ghj.tools;

import javax.servlet.http.*;

public class DataTools { 
	/**
	 * 获取request的参数值
	 * @param request request对象
	 * @param keyName Parameter的键名
	 * @param defaultValue 默认值
	 * @return
	 */
	public static int nvl(HttpServletRequest request,String keyName,int defaultValue) {
		int keyValue=0;
		if (request.getParameter(keyName)!=null && !request.getParameter(keyName).equals("")) {
			try {
				keyValue=Integer.parseInt(request.getParameter(keyName));
			} catch (Exception e) {
				keyValue=defaultValue;
			}
		} else {
			keyValue=defaultValue;
		}
		return keyValue;
	}
	
	/**
	 * 获取request的参数值
	 * @param request request对象
	 * @param keyName Parameter的键名
	 * @param defaultValue 默认值
	 * @return
	 */
	public static long nvl(HttpServletRequest request,String keyName,long defaultValue) {
		long keyValue=0;
		if (request.getParameter(keyName)!=null && !request.getParameter(keyName).equals("")) {
			try {
				keyValue=Long.parseLong(request.getParameter(keyName));
			} catch (Exception e) {
				keyValue=defaultValue;
			}
		} else {
			keyValue=defaultValue;
		}
		return keyValue;
	}
	
	/**
	 * 获取request的参数值
	 * @param request request对象
	 * @param keyName Parameter的键名
	 * @param defaultValue 默认值
	 * @return
	 */
	public static String nvl(HttpServletRequest request,String keyName,String defaultValue) {
		String keyValue=null;
		if (request.getParameter(keyName)!=null && !request.getParameter(keyName).equals("")) {
			try {
				keyValue=request.getParameter(keyName);
			} catch (Exception e) {
				keyValue=defaultValue;
			}
		} else {
			keyValue=defaultValue;
		}
		return keyValue;
	}
}
