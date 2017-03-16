package com.telek.ghj.mapping;

import java.util.HashSet;
import java.util.Set;

/**
 * TRole entity. @author MyEclipse Persistence Tools
 */

public class TRole implements java.io.Serializable {

	// Fields

	private Long roleid;
	private String rolename;
	private Set TRolePemos = new HashSet(0);
	private Set TAdmins = new HashSet(0);

	// Constructors

	/** default constructor */
	public TRole() {
	}

	/** minimal constructor */
	public TRole(Long roleid) {
		this.roleid = roleid;
	}

	/** full constructor */
	public TRole(Long roleid, String rolename, Set TRolePemos, Set TAdmins) {
		this.roleid = roleid;
		this.rolename = rolename;
		this.TRolePemos = TRolePemos;
		this.TAdmins = TAdmins;
	}

	// Property accessors

	public Long getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public Set getTRolePemos() {
		return this.TRolePemos;
	}

	public void setTRolePemos(Set TRolePemos) {
		this.TRolePemos = TRolePemos;
	}

	public Set getTAdmins() {
		return this.TAdmins;
	}

	public void setTAdmins(Set TAdmins) {
		this.TAdmins = TAdmins;
	}

}