package com.telek.ghj.mail;

import java.io.*;
import java.util.*;

/**
 * @description 数据库配置文件读取类，向database.properties中读取数据库的配置信息
 * 
 * @date 2015-12-13
 * @version 1.0
 * @author ZWJ
 * @see
 */
public class ConfigReader {

	/**
	 * TODO 向配置文件读取信息
	 * 
	 * @param key_name
	 * @return
	 */
	public static String getConfig(String key_name) {
		String key_Value = "";
		try {
			
			InputStream inputStream = 
					ConfigReader.class.getClassLoader().getResourceAsStream("email.properties");
			/* 获得配置文件路径 */
//			String filePath = System.getProperty("user.dir")
//					+ "/email.properties";
//			InputStream inputStream = new BufferedInputStream(
//					new FileInputStream(filePath));
			/* 创建操作配置文件的对象 */
			Properties format = new Properties();
			/* 加载操作文件 */
			format.load(inputStream);
			/* 通过键名获得键值 */
			key_Value = format.getProperty(key_name);
		} catch (IOException e) {
		}
		return key_Value;
	}

}
