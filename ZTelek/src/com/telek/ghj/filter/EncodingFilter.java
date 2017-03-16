package com.telek.ghj.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter{

	private String charset="utf-8";

	public void destroy() {
	
	}
	
	public void doFilter(ServletRequest request, ServletResponse response,
		FilterChain chain) throws IOException, ServletException {		
	
		request.setCharacterEncoding(this.charset);//设置服务器端接收客户端传递的数据的编码方式
		response.setCharacterEncoding(this.charset);//设置服务器端向客户端发送数据的编码方式(对应JSP的pageEncoding)
		response.setContentType("text/plain;charset="+this.charset);//设置当浏览器接收到数据时，识别的数据格式及其编码方式（对应JSP的contentType）
		
		chain.doFilter(request, response);
	}
	

	public void init(FilterConfig filterConfig) throws ServletException {
		//获取web.xm配置文件中所设置的参数（只在初始化函数中能够取值）
		if(filterConfig.getInitParameter("charset")!=null && filterConfig.getInitParameter("charset").equals("")){
			this.charset=filterConfig.getInitParameter("charset");
		}
	}

}
