package com.telek.ghj.action.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.telek.ghj.mail.SendMessage;
import com.telek.ghj.tools.DataTools;
import com.telek.ghj.tools.OutTools;

public class SendMessageAction extends HttpServlet {

	private static final long serialVersionUID = 2946054001266620430L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		String list=DataTools.nvl(request, "list", "");
		String content=DataTools.nvl(request, "content", "");
		
		String list2=(String) list.subSequence(1,list.length()-1);
		String [] s=list2.split(",");
		
		int sum=0;
		
		for(int i=0;i<s.length;i++){
			SendMessage.sendMessage(s[i], content);
			sum++;
		}
		OutTools.printTEXT(response, sum);
	}
}
