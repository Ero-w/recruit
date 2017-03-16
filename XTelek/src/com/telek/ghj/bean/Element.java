package com.telek.ghj.bean;


public class Element {
	private Node node;
	private long baseid;
	
	public Element(Node node,long baseid) {
		this.node=node;
		this.baseid=baseid;
	}
	public Node getNode() {
		return node;
	}
	public void setNode(Node node) {
		this.node = node;
	}
	
	public long getBaseid() {
		return baseid;
	}
	public void setBaseid(long baseid) {
		this.baseid = baseid;
	}
}
