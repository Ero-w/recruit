package com.telek.ghj.tools;

import java.util.*;

import com.telek.ghj.bean.Node;


/**
 * 菜单树
 * @author King
 */
public class TreeMenu {
	
	/**
	 * 节点接口
	 * @author King
	 */
//	public static interface Node {
//		public long getMenuid();
//		public void addNode(Node node);
//	}
	
//	/**
//	 * 根节点
//	 * @author King
//	 */
//	public static class RootNode implements Node {
//		private long menuid;
//		private List<Object> menus=new LinkedList<Object>();
//		
//		public RootNode(long menuid) {
//			this.menuid=menuid;
//		}
//
//		public long getMenuid() {
//			return menuid;
//		}
//
//		public void setMenuid(long menuid) {
//			this.menuid = menuid;
//		}
//		
//		public void addNode(Node node) {
//			this.menus.add(node);
//		}
//	}
	
	/**
	 * 分类节点
	 * @author King
	 */
//	public static class TypeNode implements Node {
//		private long menuid;
//		private String menuname;
//		private String icon;
//		private List<Object> menus=new LinkedList<Object>();
//		
//		public TypeNode(long menuid,String menuname,String icon) {
//			this.menuid=menuid;
//			this.menuname=menuname;
//			this.icon=icon;
//		}
//
//		public long getMenuid() {
//			return menuid;
//		}
//
//		public void setMenuid(long menuid) {
//			this.menuid = menuid;
//		}
//
//		public String getMenuname() {
//			return menuname;
//		}
//
//		public void setMenuname(String menuname) {
//			this.menuname = menuname;
//		}
//
//		public String getIcon() {
//			return icon;
//		}
//
//		public void setIcon(String icon) {
//			this.icon = icon;
//		}
//		
//		public void addNode(Node node) {
//			this.menus.add(node);
//		}
//	}
	
	/**
	 * 应用节点
	 * @author King
	 */
//	public static class ItemNode implements Node {
//		private long menuid;
//		private String menuname;
//		private String icon;
//		private String url;
//		private List<Object> child=new LinkedList<Object>();
//		
//		public ItemNode(long menuid,String menuname,String icon,String url) {
//			this.menuid=menuid;
//			this.menuname=menuname;
//			this.icon=icon;
//			this.url=url;
//		}
//
//		public long getMenuid() {
//			return menuid;
//		}
//
//		public void setMenuid(long menuid) {
//			this.menuid = menuid;
//		}
//
//		public String getMenuname() {
//			return menuname;
//		}
//
//		public void setMenuname(String menuname) {
//			this.menuname = menuname;
//		}
//
//		public String getIcon() {
//			return icon;
//		}
//
//		public void setIcon(String icon) {
//			this.icon = icon;
//		}
//		
//		public String getUrl() {
//			return url;
//		}
//
//		public void setUrl(String url) {
//			this.url = url;
//		}
//		
//		public void addNode(Node node) {
//			this.child.add(node);
//		}
//	}
//	
	/**
	 * 元素
	 * @author King
	 */
//	public static class Element {
//		private Node node;
//		private long baseid;
//		
//		public Element(Node node,long baseid) {
//			this.node=node;
//			this.baseid=baseid;
//		}
//		public Node getNode() {
//			return node;
//		}
//		public void setNode(Node node) {
//			this.node = node;
//		}
//		
//		public long getBaseid() {
//			return baseid;
//		}
//		public void setBaseid(long baseid) {
//			this.baseid = baseid;
//		}
	}
	
//	public static String getJson(long roleId) throws DataBaseException { 
//		DataTable dt=DataBaseClass.executeReader("SELECT level,pemoid,pemoname,nvl(baseid,0) baseid,url FROM (select th.*,tp.pemoname,nvl(tp.baseid,0) baseid ,url from (select tr.*,trp.pemoid from  t_role tr join t_role_pemo trp  on tr.roleid=trp.roleid) th join t_pemo tp on  th.pemoid=tp.pemoid and roleid=?) ty START WITH pemoid=? CONNECT BY PRIOR pemoid=baseid",new Object[]{roleId,1}); 
//		List<Element> list=new LinkedList<Element>();
//		RootNode root=null;
//		for (int i=0;i<dt.getRowCount();i++)
//		{
//			if (Long.parseLong(dt.getValue(i, 0).toString())==1)
//			{
//				root=new RootNode(Long.parseLong(dt.getValue(i, 1).toString()));
//				list.add(new Element(root,Long.parseLong(dt.getValue(i, 3).toString())));
//			} else if (Long.parseLong(dt.getValue(i, 0).toString())==2) {
//				TypeNode node=new TypeNode(Long.parseLong(dt.getValue(i, 1).toString()),dt.getValue(i, 2).toString(),"icon-nav");
//				list.add(new Element(node,Long.parseLong(dt.getValue(i, 3).toString())));
//			} else {
//				ItemNode node=new ItemNode(Long.parseLong(dt.getValue(i, 1).toString()),dt.getValue(i, 2).toString(),"icon-nav",dt.getValue(i, 4).toString());
//				list.add(new Element(node,Long.parseLong(dt.getValue(i, 3).toString())));
//			}
//		}
//		for (int i=0;i<list.size();i++)
//		{
//			Element element=list.get(i);
//			for (int j=0;j<list.size();j++) {
//				if(element.baseid==list.get(j).getNode().getMenuid()) {
//					list.get(j).getNode().addNode(element.getNode());
//					break;
//				}
//			}
//		}
//		Map<String, Object> jsonMap = new HashMap<String, Object>();
//		jsonMap.put("menus", root.menus);
//		String json = new Gson().toJson(jsonMap);
//		return json;
//	}
//}
