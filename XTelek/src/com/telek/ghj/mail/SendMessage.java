package com.telek.ghj.mail;

import java.io.IOException;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

public class SendMessage {
	
	public static int sendMessage(String mobile,String content) throws HttpException, IOException {
		HttpClient client = new HttpClient();
		PostMethod post = new PostMethod("http://gbk.sms.webchinese.cn"); 
		post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=gbk");//在头文件中设置转码
		NameValuePair[] data ={ new NameValuePair("Uid", "hujunjie"),new NameValuePair("Key", "7b1adefce6de5b59ac98"),new NameValuePair("smsMob",mobile),new NameValuePair("smsText",content)};
		post.setRequestBody(data);
		
		client.executeMethod(post);
		Header[] headers = post.getResponseHeaders();
		int statusCode = post.getStatusCode();
		System.out.println("statusCode:"+statusCode);
		for(Header h : headers)
		{
		System.out.println(h.toString());
		}
		String result = new String(post.getResponseBodyAsString().getBytes("gbk")); 
		post.releaseConnection();
		return new Integer(result);
	}
}
