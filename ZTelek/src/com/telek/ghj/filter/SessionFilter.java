package com.telek.ghj.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionFilter implements Filter {

	private String keyName="realname";
	
	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		if (this.keyName == null || this.keyName.equals("")) {
			throw new Error("无法进行登录验证，请检查web.xml的设置");
		} else {
			HttpServletRequest httpServletRequest = (HttpServletRequest) request;
			HttpSession session = httpServletRequest.getSession(false);

			if (session != null && session.getAttribute("realname") != null
					&& !session.getAttribute("realname").toString().equals("")) {
				chain.doFilter(request, response);
			} else {
				((HttpServletResponse) response).sendRedirect("../login.jsp");
			}
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		if (filterConfig.getInitParameter("keyName") != null
				&& !filterConfig.getInitParameter("keyName").equals("")) {
			this.keyName = filterConfig.getInitParameter("keyName");
		} else {
			throw new Error("无法进行登录验证，请检查web.xml的设置");
		}
		
	}

}
