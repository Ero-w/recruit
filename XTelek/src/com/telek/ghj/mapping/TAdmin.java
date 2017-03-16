package com.telek.ghj.mapping;

/**
 * TAdmin entity. @author MyEclipse Persistence Tools
 */

public class TAdmin implements java.io.Serializable {

	// Fields

	private Long id;
	private TRole TRole;
	private String name;
	private String password;
	private String remark;

	// Constructors

	/** default constructor */
	public TAdmin() {
	}

	/** minimal constructor */
	public TAdmin(Long id) {
		this.id = id;
	}

	/** full constructor */
	public TAdmin(Long id, TRole TRole, String name, String password,
			String remark) {
		this.id = id;
		this.TRole = TRole;
		this.name = name;
		this.password = password;
		this.remark = remark;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TRole getTRole() {
		return this.TRole;
	}

	public void setTRole(TRole TRole) {
		this.TRole = TRole;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}