package com.telek.ghj.tools;

import java.io.*;
import javax.servlet.http.*;

import com.google.gson.Gson;

public class OutTools {
	/**
	 * 输出JSON格式数据
	 * @param response 输出的操作对象
	 * @param object 输出的数据对象
	 * @throws IOException 
	 */
	public static void printJSON(HttpServletResponse response,Object object) throws IOException { 
		String json = new Gson().toJson(object);
        PrintWriter out=response.getWriter();
        out.print(json);
        out.flush();
        out.close();
	}
	
	/**
	 * 输出TEXT格式数据
	 * @param response 输出的操作对象
	 * @param text 输出的文本
	 * @throws IOException 
	 */
	public static void printTEXT(HttpServletResponse response,String text) throws IOException { 
        PrintWriter out=response.getWriter();
        out.print(text);
        out.flush();
        out.close();
	}
	
	/**
	 * 输出TEXT格式数据
	 * @param response 输出的操作对象
	 * @param text 输出的文本
	 * @throws IOException 
	 */
	public static void printTEXT(HttpServletResponse response,Object text) throws IOException { 
        PrintWriter out=response.getWriter();
        out.print(text.toString());
        out.flush();
        out.close();
	}
	
}