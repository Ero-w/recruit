package com.telek.ghj.action.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;

import com.telek.ghj.tools.DataTools;
import com.telek.ghj.tools.OutTools;

public class ReadResumeAction extends HttpServlet {

	private static final long serialVersionUID = 6438181914784912718L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		String 	filepath=DataTools.nvl(request, "filepath", ""); 

		
		try {
			OPCPackage opcPackage = POIXMLDocument
					.openPackage(filepath);
			POIXMLTextExtractor extractor = new XWPFWordExtractor(opcPackage);
			String text2007 = extractor.getText();
			 String[] s = text2007.split("\n");
			 String ss="";
			 for(int i=0;i<s.length;i++){
				 System.out.println(s[i]);
				 ss=ss+"<br/>"+s[i];
			 }
			OutTools.printTEXT(response, ss);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
