package com.telek.ghj.mapping;

import java.util.HashSet;
import java.util.Set;

/**
 * TPemo entity. @author MyEclipse Persistence Tools
 */

public class TPemo implements java.io.Serializable {

	// Fields

	private Long pemoid;
	private String pemoname;
	private Long baseid;
	private String url;
	private Set TRolePemos = new HashSet(0);

	// Constructors

	/** default constructor */
	public TPemo() {
	}

	/** minimal constructor */
	public TPemo(Long pemoid) {
		this.pemoid = pemoid;
	}

	/** full constructor */
	public TPemo(Long pemoid, String pemoname, Long baseid,
			String url, Set TRolePemos) {
		this.pemoid = pemoid;
		this.pemoname = pemoname;
		this.baseid = baseid;
		this.url = url;
		this.TRolePemos = TRolePemos;
	}

	// Property accessors

	public Long getPemoid() {
		return this.pemoid;
	}

	public void setPemoid(Long pemoid) {
		this.pemoid = pemoid;
	}

	public String getPemoname() {
		return this.pemoname;
	}

	public void setPemoname(String pemoname) {
		this.pemoname = pemoname;
	}

	public Long getBaseid() {
		return this.baseid;
	}

	public void setBaseid(Long baseid) {
		this.baseid = baseid;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Set getTRolePemos() {
		return this.TRolePemos;
	}

	public void setTRolePemos(Set TRolePemos) {
		this.TRolePemos = TRolePemos;
	}

}