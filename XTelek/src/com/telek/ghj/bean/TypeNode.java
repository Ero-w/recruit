package com.telek.ghj.bean;

import java.util.LinkedList;
import java.util.List;

public class TypeNode implements Node {
	private long menuid;
	private String menuname;
	private String icon;
	private List<Object> menus=new LinkedList<Object>();
	
	public TypeNode(long menuid,String menuname,String icon) {
		this.menuid=menuid;
		this.menuname=menuname;
		this.icon=icon;
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
	
	public void addNode(Node node) {
		this.menus.add(node);
	}

}
