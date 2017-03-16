package com.telek.ghj.bean;

import java.util.LinkedList;
import java.util.List;

public class RootNode  implements Node {
	private long menuid;
	private List<Object> menus=new LinkedList<Object>();
	
	public RootNode(long menuid) {
		this.menuid=menuid;
	}

	public long getMenuid() {
		return menuid;
	}

	public void setMenuid(long menuid) {
		this.menuid = menuid;
	}
	
	public void addNode(Node node) {
		this.menus.add(node);
	}

}
