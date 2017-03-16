package com.telek.ghj.bean;

import java.util.LinkedList;
import java.util.List;

public class ItemNode implements Node {
	private long menuid;
	private String menuname;
	private String icon;
	private String url;
	private List<Object> child=new LinkedList<Object>();
	
	public ItemNode(long menuid,String menuname,String icon,String url) {
		this.menuid=menuid;
		this.menuname=menuname;
		this.icon=icon;
		this.url=url;
	}

	public long getMenuid() {
		return menuid;
	}

	public void setMenuid(long menuid) {
		this.menuid = menuid;
	}

	public String getMenuname() {
		return menuname;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public void addNode(Node node) {
		this.child.add(node);
	}
}