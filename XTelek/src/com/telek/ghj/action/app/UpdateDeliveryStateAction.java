package com.telek.ghj.action.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.telek.ghj.mail.MailMessage;
import com.telek.ghj.mail.SMTPClient;
import com.telek.ghj.service.DeliveryService;
import com.telek.ghj.tools.DataTools;
import com.telek.ghj.tools.OutTools;

public class UpdateDeliveryStateAction extends HttpServlet {


	private static final long serialVersionUID = -7260269392127267506L;

	
	private DeliveryService deliveryService=null;
	

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String list = DataTools.nvl(request, "list", "");
		String list2=(String) list.subSequence(1,list.length()-1);
		String [] s=list2.split(",");
		for(int i=0;i<s.length;i++){
			try {
				deliveryService.updateDelivery(s[i]);
				String content ="！恭喜您在简历海选中顺利晋级";
				String subject="简历初审通过";
				MailMessage message = new MailMessage();
				message.setTo(new String[]{s[i]});
				message.setContent(content);
				message.setSubject(subject);
				SMTPClient.sendEMail(message);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		OutTools.printTEXT(response, "11");
		
	}
	
	
	public DeliveryService getDeliveryService() {
		return deliveryService;
	}


	public void setDeliveryService(DeliveryService deliveryService) {
		this.deliveryService = deliveryService;
	}


}
