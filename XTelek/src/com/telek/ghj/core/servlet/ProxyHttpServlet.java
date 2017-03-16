package com.telek.ghj.core.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * 代理Servlet类，用于调用原型Servlet。将原型Servlet交给Spring管理
 */
public class ProxyHttpServlet extends HttpServlet {

	// 原型对象
	private HttpServlet httpServlet = null;

	private static final long serialVersionUID = -6293994819179118042L;

	private ApplicationContext applicationContext = null;

	public ProxyHttpServlet() {
		System.out.println("ProxyHttpServlet");
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.applicationContext = WebApplicationContextUtils
				.getRequiredWebApplicationContext(this.getServletContext());
	}

	// tomcat直接调用service函数,如果没有重写该函数，系统自动调用父类所继承的service函数(判断应该执行doGet还是doPost)
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String targetAction = this.getInitParameter("targetAction");// 获取配置文件中的Servlet原型
		if (targetAction == null || targetAction.equals("")) {
			targetAction = request.getParameter("targetAction");// 获取提交请求时所设置的Servlet原型
			if (targetAction == null || targetAction.equals("")) {
				targetAction=request.getServerName();//获取当前的Servlet名称
				if (targetAction == null || targetAction.equals("")) {
					throw new ServletException("Servlet原型不存在");
				} else {
					//配置文件中已设置的Servlet原型(Servelt名称匹配);
				}
			} else {
				// 提交请求时已设置的Servlet原型(request参数匹配)
			}

		} else {
			//配置文件中已设置的Servlet原型(Servlet参数匹配)
		}

		this.httpServlet=(HttpServlet)this.applicationContext.getBean(targetAction);
		this.httpServlet.init(this.getServletConfig());
		this.httpServlet.service(request, response);
	}
}
